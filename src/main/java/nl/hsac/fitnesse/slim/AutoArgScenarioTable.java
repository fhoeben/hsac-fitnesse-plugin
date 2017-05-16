package nl.hsac.fitnesse.slim;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;
import fitnesse.testsystems.slim.tables.ScenarioTable;
import fitnesse.testsystems.slim.tables.SlimAssertion;
import fitnesse.testsystems.slim.tables.SlimTable;
import fitnesse.testsystems.slim.tables.SyntaxError;

/**
 * ScenarioTable that looks for in- and output parameters in all its rows, without the
 * parameters having to be specified in the first row also.
 */
public class AutoArgScenarioTable extends ScenarioTable {
    private final static Pattern ARG_PATTERN = Pattern.compile("@\\{(.+?)\\}");
    private static final Pattern OUT_PATTERN = Pattern.compile("\\$(.+?)=");

    private List<String> inputs;
    private List<String> tableParameters;
    private List<String> outputs;

    public AutoArgScenarioTable(Table table, String tableId, SlimTestContext testContext) {
        super(table, tableId, testContext);
    }

    @Override
    public List<SlimAssertion> getAssertions() throws SyntaxError {
        inputs = findArguments(ARG_PATTERN);
        outputs = findArguments(OUT_PATTERN);
        return super.getAssertions();
    }

    @Override
  protected void getScenarioArguments() {
    super.getScenarioArguments();
    
    // Store the table arguments for later during Call() method    
    if (determineParameterized()){
      String argumentString = table.getCellContents(2, 0);
      String[] arguments = argumentString.split(",");
      tableParameters = new LinkedList<String>();
      for (String args : arguments) {
        tableParameters.add(args);
      }
    }

    for (String input : inputs) {
      addInput(input);
    }
    
    for (String output : outputs) {
      addOutput(output);
    }
  }

    private List<String> findArguments(Pattern pattern) {
        List<String> found = new LinkedList<String>();
        int rowCount = table.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            int columnCount = table.getColumnCountInRow(row);
            for (int column = 0; column < columnCount; column++) {
                String cellContent = table.getCellContents(column, row);
                Matcher m = pattern.matcher(cellContent);
                while (m.find()) {
                    String input = m.group(1);
                    found.add(input);
                }
            }
        }
        return found;
    }
    
  @Override
  public List<SlimAssertion> call(final Map<String, String> scenarioArguments, SlimTable parentTable, int row)
      throws SyntaxError {
    
    // Insert the matching table parameter values as added scenarioArguments for the running table
    Table execTable = parentTable.getTable();   
    if (tableParameters != null){
      if (execTable.getColumnCountInRow(0) == (tableParameters.size() * 2)){ // should be twice as much cell then parameters -- otherwise we are missing a parameter or a placeholder
        int i=1;
        for (String parameter : tableParameters) {      
          String value = execTable.getCellContents(i, 0);
          scenarioArguments.put(parameter, value);
          i = i + 2;
        }      
      }
    }
    
    return super.call(scenarioArguments, parentTable, row);    
  }

}
