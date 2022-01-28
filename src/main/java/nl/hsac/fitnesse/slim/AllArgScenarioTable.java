package nl.hsac.fitnesse.slim;

import fitnesse.testsystems.TestExecutionException;
import fitnesse.testsystems.slim.HtmlTable;
import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;
import fitnesse.testsystems.slim.tables.SlimAssertion;
import fitnesse.testsystems.slim.tables.SlimTable;

import java.util.List;
import java.util.Map;

/**
 * Scenario table that allows usage @{*} symbol to expand all input variables as a constructor parameter for
 * fixtures. See ArgTableTemplateTest1.wiki for example usage.
 */
public class AllArgScenarioTable extends AutoArgScenarioTable {
    private static final String ALL_ARG_PATTERN = "@{*}";

    public AllArgScenarioTable(Table table, String tableId, SlimTestContext testContext) {
        super(table, tableId, testContext);
    }

    @Override
    public List<SlimAssertion> call(Map<String, String> scenarioArguments,
                                    SlimTable parentTable, int row) throws TestExecutionException {
        String arrayArgs = arrayArgs(scenarioArguments);
        if(getTable() instanceof HtmlTable){
            HtmlTable nTable = (HtmlTable) getTable();
            for(int i = 0; i<nTable.getRowCount();i++){
                int colCount = nTable.getColumnCountInRow(i);
                for(int j = 0; j<colCount ; j++){
                    if(nTable.getCellContents(j,i).trim().equals(ALL_ARG_PATTERN)){
                        nTable.substitute(j,i,arrayArgs);
                    }
                }
            }
        }
        return super.call(scenarioArguments,parentTable,row);
    }

    public static String arrayArgs(Map<String, String> scenarioArguments) throws TestExecutionException {
        if(scenarioArguments.entrySet().size() == 0) throw new TestExecutionException("Scenario has no input arguments.");
        String out = scenarioArguments.entrySet().stream().map(e -> e.getKey()+","+"@{"+e.getKey()+"}").reduce((e,v) -> e = e.concat(","+v)).get();
        return "["+out+"]";
    }

}
