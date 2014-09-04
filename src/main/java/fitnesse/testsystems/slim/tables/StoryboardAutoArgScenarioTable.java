package fitnesse.testsystems.slim.tables;

import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;
import nl.hsac.fitnesse.slim.AutoArgScenarioTable;
import nl.hsac.fitnesse.slim.StoryboardTable;

/**
 * AutoArgScenarioTable that creates storyboard instances when invoked from
 * decision table.
 * NOTE: put in this package because otherwise ScenarioTestContext is not visible
 * @link https://github.com/unclebob/fitnesse/issues/515
 * Once that issue is fixed this class can disapear and we can move the logic
 * to the class with the same name in nl.hsac.fitnesse.slim.
 */
public class StoryboardAutoArgScenarioTable extends AutoArgScenarioTable {
    public StoryboardAutoArgScenarioTable(Table table, String tableId, SlimTestContext testContext) {
        super(table, tableId, testContext);
    }

    @Override
    protected ScriptTable createChild(fitnesse.testsystems.slim.tables.ScenarioTable.ScenarioTestContext testContext, SlimTable parentTable, Table newTable) {
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
