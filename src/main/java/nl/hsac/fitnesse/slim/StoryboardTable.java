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
        List<SlimAssertion> assertions = super.invokeAction(startingCol, endingCol, row, expectation);
        addScreenshotAssertionForRow(assertions, row);
        return assertions;
    }

    protected void addScreenshotAssertionForRow(List<SlimAssertion> assertions, int row) {
        int screenshotColumn = addScreenshotColumn(row);
        SlimAssertion screenshotAssertion = createAssertionForTakeScreenshot(screenshotColumn, row);
        assertions.add(screenshotAssertion);
    }

    protected int addScreenshotColumn(int row) {
        table.addColumnToRow(row, "");
        return table.getColumnCountInRow(row) - 1;
    }

    protected SlimAssertion createAssertionForTakeScreenshot(int screenshotColumn, int row) {
        updateCounters();
        String screenshotName = getScreenshotName(row);
        Instruction instruction = callFunction(getTableType() + "Actor", getActionName(), screenshotName);
        return makeAssertion(instruction, new ScreenshotExpectation(screenshotColumn, row));
    }

    protected void updateCounters() {
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

    protected class ScreenshotExpectation extends RowExpectation {
        ScreenshotExpectation(int col, int row) {
            super(col, row);
        }

        @Override
        protected SlimTestResult createEvaluationMessage(String actual, String expected) {
            int row = getRow();
            try {
                table.substitute(getCol(), row, actual);
            } catch (Throwable t) {
                table.substitute(getCol(), row, actual + ": " + t.getMessage());
            }
            return SlimTestResult.plain();
        }
    }
}
