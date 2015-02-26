package nl.hsac.fitnesse.slim;

import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;
import fitnesse.testsystems.slim.tables.ScenarioTable;
import fitnesse.testsystems.slim.tables.SlimAssertion;
import fitnesse.testsystems.slim.tables.SyntaxError;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ScenarioTable that looks for in- and output parameters in all its rows, without the
 * parameters having to be specified in the first row also.
 */
public class AutoArgScenarioTable extends ScenarioTable {
    private final static Pattern ARG_PATTERN = Pattern.compile("@\\{(.+?)\\}");
    private static final Pattern OUT_PATTERN = Pattern.compile("\\$(.+?)=");

    private Set<String> inputs;
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
        return !inputs.isEmpty();
    }

    @Override
    protected void getScenarioArguments() {
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
}
