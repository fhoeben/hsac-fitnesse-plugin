package nl.hsac.fitnesse.slim;

import fitnesse.slim.instructions.Instruction;
import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;
import fitnesse.testsystems.slim.results.SlimTestResult;
import fitnesse.testsystems.slim.tables.ScriptTable;
import fitnesse.testsystems.slim.tables.SlimAssertion;
import fitnesse.testsystems.slim.tables.SlimExpectation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Script table which takes a 'screenshot' on each action.
 */
public class StoryboardTable extends ScriptTable {
    private String screenshotPrefix;

    public StoryboardTable(Table table, String tableId, SlimTestContext context) {
        super(table, tableId, context);
        screenshotPrefix = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
    }

    @Override
    protected String getTableType() {
        return "storyboardTable";
    }

    @Override
    protected String getTableKeyword() {
        return "storyboard";
    }

    protected String getActionName() {
        return "takeScreenshot";
    }

    protected String getScreenshotPrefix() {
        return screenshotPrefix;
    }

    @Override
    protected List<SlimAssertion> invokeAction(int startingCol, int endingCol, int row, SlimExpectation expectation) {
        List<SlimAssertion> realAssertions = super.invokeAction(startingCol, endingCol, row, expectation);
        String screenshotName = getScreenshotName(row);
        Instruction instruction = callFunction(getTableType() + "Actor", getActionName(), screenshotName);
        SlimAssertion screenshotAssertion = makeAssertion(instruction, new ScreenshotExpectation(0, row));
        realAssertions.add(screenshotAssertion);
        return realAssertions;
    }

    protected String getScreenshotName(int row) {
        return String.format("%s/%s/%s_%s", getTableKeyword(), getScreenshotPrefix(), id, row);
    }

    private class ScreenshotExpectation extends RowExpectation {
        public ScreenshotExpectation(int col, int row) {
            super(col, row);
        }

        @Override
        protected SlimTestResult createEvaluationMessage(String actual, String expected) {
            try {
                table.addColumnToRow(getRow(), actual);
            } catch (Throwable t) {
                table.addColumnToRow(getRow(), actual + ": " + t.getMessage());
            }
            return SlimTestResult.plain();
        }
    }
}
