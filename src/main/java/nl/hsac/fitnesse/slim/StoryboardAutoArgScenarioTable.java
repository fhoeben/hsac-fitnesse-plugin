package nl.hsac.fitnesse.slim;

import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;

/**
 * AutoArgScenarioTable that creates storyboard instances when invoked from
 * decision table.
 */
public class StoryboardAutoArgScenarioTable extends fitnesse.testsystems.slim.tables.StoryboardAutoArgScenarioTable {
    /*
     * @link
     * Once that https://github.com/unclebob/fitnesse/issues/515 is fixed the super class' logic
     * can move into this class.
     */
    public StoryboardAutoArgScenarioTable(Table table, String tableId, SlimTestContext testContext) {
        super(table, tableId, testContext);
    }
}
