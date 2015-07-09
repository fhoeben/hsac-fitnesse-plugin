package nl.hsac.fitnesse.slim;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    private Set<String> inputs;
    private Set<String> parameters;
    private Set<String> outputs;

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
    protected boolean determineParameterized() {
      if (this.getTable().getColumnCountInRow(0) > 2){
        return true;
      }
      return false;       
    }

    @Override
    protected void getScenarioArguments() {         
        super.getScenarioArguments();
        
        parameters = new LinkedHashSet<String>();
        parameters.addAll(getInputs());
        
        for (String input : inputs) {
            addInput(input);
        }
        for (String output : outputs) {
            addOutput(output);
        }
    }

    private Set<String> findArguments(Pattern pattern) {
        Set<String> found = new LinkedHashSet<String>();
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
    
    // Add the table template parameters to the list of possible arguments along with the profided value
    int i=0;
    for (String parameter : parameters) {
      String value = parentTable.getTable().getCellContents(i+1, 0);
      scenarioArguments.put(parameter, value);
      i++;
    }
    return super.call(scenarioArguments, parentTable, row);    
  }

}
