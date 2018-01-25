package nl.hsac.fitnesse.slim;

import fitnesse.testsystems.TestExecutionException;
import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;
import fitnesse.testsystems.slim.tables.*;
import nl.hsac.fitnesse.slimcoverage.SlimCoverageTestContextImpl;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ScenarioTable that looks for in- and output parameters in all its rows, without the
 * parameters having to be specified in the first row also.
 */
public class AutoArgScenarioTable extends ScenarioTable {
    private static final Pattern ARG_PATTERN = Pattern.compile("@\\{(.+?)\\}");
    private static final Pattern OUT_PATTERN = Pattern.compile("\\$(.+?)=");

    private Set<String> inputs;
    private Set<String> outputs;

    private Map<String, String> currentCallArguments;

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
                if (!addAllMatches(pattern, found, cellContent)
                        && maybeNestedScenario(columnCount, cellContent)) {
                    addNestedScenarioArguments(found, pattern == ARG_PATTERN, cellContent);
                }
            }
        }
        return found;
    }

    private void addNestedScenarioArguments(Set<String> found, boolean addInputs, String cellContent) {
        String scenarioName = cellContent.substring(0, cellContent.length() - 1);
        scenarioName = Disgracer.disgraceClassName(scenarioName);
        SlimTestContext testContext = getTestContext();
        ScenarioTable scenario;
        if (testContext instanceof SlimCoverageTestContextImpl) {
            scenario = ((SlimCoverageTestContextImpl) testContext).getScenarioNoCount(scenarioName);
        } else {
            scenario = testContext.getScenario(scenarioName);
        }
        if (scenario != null) {
            Set<String> scenarioArgs = addInputs ? scenario.getInputs() : scenario.getOutputs();
            found.addAll(scenarioArgs);
        }
    }

    private boolean maybeNestedScenario(int columnCount, String cellContent) {
        return columnCount == 1 && cellContent.endsWith(";");
    }

    private boolean addAllMatches(Pattern pattern, Set<String> found, String cellContent) {
        boolean anyMatches = false;
        Matcher m = pattern.matcher(cellContent);
        while (m.find()) {
            String input = m.group(1);
            found.add(input);
            anyMatches = true;
        }
        return anyMatches;
    }

    public Map<String, String> getCurrentCallArguments() {
        return currentCallArguments;
    }

    @Override
    public List<SlimAssertion> call(Map<String, String> scenarioArguments,
                                    SlimTable parentTable, int row) throws TestExecutionException {
        try {
            currentCallArguments = scenarioArguments;
            if (scenarioArguments.isEmpty()) {
                SlimTestContext context = parentTable.getTestContext();
                if (context instanceof ScenarioTestContext) {
                    ScenarioTestContext sTestContext = (ScenarioTestContext) context;
                    AutoArgScenarioTable caller = getCallingTable(sTestContext);
                    Map<String, String> callerArgs = caller.getCurrentCallArguments();
                    for (Map.Entry<String, String> entry : callerArgs.entrySet()) {
                        String arg = entry.getKey();
                        if (inputs.contains(arg)) {
                            scenarioArguments.put(arg, entry.getValue());
                        }
                    }
                }
            }
            return super.call(scenarioArguments, parentTable, row);
        } finally {
            currentCallArguments = null;
        }
    }

    // TODO : Remove usage of reflective field access once https://github.com/unclebob/fitnesse/pull/1103 is released
    private static final Field stField;

    static {
        try {
            stField = ScenarioTestContext.class.getDeclaredField("this$0");
            stField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private AutoArgScenarioTable getCallingTable(ScenarioTestContext context) {
        try {
            ScenarioTable t = (ScenarioTable) stField.get(context);
            if (t instanceof AutoArgScenarioTable) {
                return (AutoArgScenarioTable) t;
            } else {
                return null;
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
