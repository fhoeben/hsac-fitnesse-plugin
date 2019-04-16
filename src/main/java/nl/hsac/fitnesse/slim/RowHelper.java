package nl.hsac.fitnesse.slim;

import fitnesse.testsystems.slim.Table;
import fitnesse.testsystems.slim.tables.Disgracer;

/**
 * Helper to facilitate working with calls to other scenario's from AutoArgScenarioTables.
 * To be replaced by usage of ScriptTable.RowHelper.
 */
public class RowHelper {
  private static final String SEQUENTIAL_ARGUMENT_PROCESSING_SUFFIX = ";";

  public static String getScenarioNameFromAlternatingCells(Table table, int endingCol, int row) {
    String actionName = getActionNameStartingAt(table, 0, endingCol, row);
    String simpleName = actionName.replace(RowHelper.SEQUENTIAL_ARGUMENT_PROCESSING_SUFFIX, "");
    return Disgracer.disgraceClassName(simpleName);
  }

  public static String getActionNameStartingAt(Table table, int startingCol, int endingCol, int row) {
    StringBuilder actionName = new StringBuilder();
    actionName.append(table.getCellContents(startingCol, row));
    int actionNameCol = startingCol + 2;
    while (actionNameCol <= endingCol &&
      !invokesSequentialArgumentProcessing(actionName.toString())) {
      actionName.append(" ").append(table.getCellContents(actionNameCol, row));
      actionNameCol += 2;
    }
    return actionName.toString().trim();
  }

  public static boolean invokesSequentialArgumentProcessing(String cellContents) {
    return cellContents.endsWith(SEQUENTIAL_ARGUMENT_PROCESSING_SUFFIX);
  }

}
