package nl.hsac.fitnesse.slim;

import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;
import fitnesse.testsystems.slim.tables.ScriptTable;
import fitnesse.testsystems.slim.tables.SlimTable;

/**
 * AutoArgScenarioTable that creates storyboard instances when invoked from
 * decision table.
 */
public class StoryboardAutoArgScenarioTable extends AutoArgScenarioTable {
    public StoryboardAutoArgScenarioTable(Table table, String tableId, SlimTestContext testContext) {
        super(table, tableId, testContext);
    }

    @Override
    protected ScriptTable createChild(ScenarioTestContext testContext, SlimTable parentTable, Table newTable) {
        ScriptTable scriptTable;
        if (!(parentTable instanceof ScriptTable)) {
            scriptTable = new StoryboardTable(newTable, id, testContext);
            scriptTable.setCustomComparatorRegistry(customComparatorRegistry);
        } else {
            scriptTable = super.createChild(testContext, parentTable, newTable);
        }

        return scriptTable;
    }
}
