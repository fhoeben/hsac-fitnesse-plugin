package nl.hsac.fitnesse.slim;

import fitnesse.slim.instructions.Instruction;
import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;
import fitnesse.testsystems.slim.results.SlimTestResult;
import fitnesse.testsystems.slim.tables.ScriptTable;
import fitnesse.testsystems.slim.tables.SlimAssertion;
import fitnesse.testsystems.slim.tables.SlimExpectation;

import java.util.List;


/**
 * Script table which takes a 'screenshot' on each action.
 */
public class StoryboardTable extends ScriptTable {
    private static String lastPage = null;
    private static String lastTop = null;
    private static int storyboardCount;
    private static int screenshotCount;
    private String screenshotPrefix;

    public StoryboardTable(Table table, String tableId, SlimTestContext context) {
        super(table, tableId, context);
        String fullPath = context.getPageToTest().getFullPath();
        screenshotPrefix = fullPath;
        if (!fullPath.equals(lastPage)) {
            lastTop = null;
            storyboardCount = 0;
            screenshotCount = 0;
            lastPage = fullPath;
        }
    }

    @Override
    protected String getTableKeyword() {
        return "storyboard";
    }

    protected String getActionName() {
        return "takeScreenshot";
    }

    protected int getStoryboardCounter() {
        return storyboardCount;
    }

    protected String getScreenshotPrefix() {
        return screenshotPrefix;
    }

    protected int getScreenshotCounter() {
        return screenshotCount;
    }

    @Override
    protected List<SlimAssertion> invokeAction(int startingCol, int endingCol, int row, SlimExpectation expectation) {
        updateCounters();
        String screenshotName = getScreenshotName(row);
        List<SlimAssertion> realAssertions = super.invokeAction(startingCol, endingCol, row, expectation);
        Instruction instruction = callFunction(getTableType() + "Actor", getActionName(), screenshotName);
        table.addColumnToRow(row, "");
        int screenshotColumn = table.getColumnCountInRow(row) - 1;
        SlimAssertion screenshotAssertion = makeAssertion(instruction, new ScreenshotExpectation(screenshotColumn, row));
        realAssertions.add(screenshotAssertion);
        return realAssertions;
    }

    private void updateCounters() {
        String topTable = id.split("\\.")[0];
        if (!topTable.equals(lastTop)) {
            lastTop = topTable;
            storyboardCount++;
            screenshotCount = 0;
        }
        screenshotCount++;
    }

    protected String getScreenshotName(int row) {
        return String.format("%s/%s/%02d-%03d",
                                getTableKeyword(), getScreenshotPrefix(),
                                getStoryboardCounter(), getScreenshotCounter());
    }

    private class ScreenshotExpectation extends RowExpectation {
        ScreenshotExpectation(int col, int row) {
            super(col, row);
        }

        @Override
        protected SlimTestResult createEvaluationMessage(String actual, String expected) {
            try {
                table.substitute(getCol(), getRow(), actual);
            } catch (Throwable t) {
                table.substitute(getCol(), getRow(), actual + ": " + t.getMessage());
            }
            return SlimTestResult.plain();
        }
    }
}
