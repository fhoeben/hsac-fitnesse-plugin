package nl.hsac.fitnesse.slim;

import fitnesse.testsystems.TestExecutionException;
import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;
import fitnesse.testsystems.slim.tables.ScenarioTable;
import fitnesse.testsystems.slim.tables.SlimAssertion;
import fitnesse.testsystems.slim.tables.SlimTable;
import fitnesse.testsystems.slim.tables.SyntaxError;
import nl.hsac.fitnesse.slimcoverage.SlimCoverageTestContextImpl;

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
        Set<String> found = new LinkedHashSet<>();
        int rowCount = table.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            int columnCount = table.getColumnCountInRow(row);
            ScenarioTable calledScenario = getCalledScenario(columnCount - 1, row);
            if (calledScenario != null) {
                addNestedScenarioArguments(found, pattern == ARG_PATTERN, calledScenario);
            }
            for (int column = 0; column < columnCount; column++) {
                String cellContent = table.getCellContents(column, row);
                addAllMatches(pattern, found, cellContent);
            }
        }
        return found;
    }

    private ScenarioTable getCalledScenario(int lastCol, int row) {
        String scenarioName = RowHelper.getScenarioNameFromAlternatingCells(table, lastCol, row);
        ScenarioTable scenario = getScenarioByName(scenarioName);
        if (scenario == null && lastCol == 0) {
            String cellContents = table.getCellContents(0, row);
            scenario = getScenarioByPattern(cellContents);
        }
        return scenario;
    }

    private void addNestedScenarioArguments(Set<String> found, boolean addInputs, ScenarioTable scenario) {
        Set<String> scenarioArgs = addInputs ? scenario.getInputs() : scenario.getOutputs();
        found.addAll(scenarioArgs);
    }

    private ScenarioTable getScenarioByName(String scenarioName) {
        SlimTestContext testContext = getTestContext();
        ScenarioTable scenario;
        if (testContext instanceof SlimCoverageTestContextImpl) {
            scenario = ((SlimCoverageTestContextImpl) testContext).getScenarioNoCount(scenarioName);
        } else {
            scenario = testContext.getScenario(scenarioName);
        }
        return scenario;
    }

    private ScenarioTable getScenarioByPattern(String invokingString) {
        SlimTestContext testContext = getTestContext();
        ScenarioTable scenario;
        if (testContext instanceof SlimCoverageTestContextImpl) {
            scenario = ((SlimCoverageTestContextImpl) testContext).getScenarioByPatternNoCount(invokingString);
        } else {
            scenario = testContext.getScenarioByPattern(invokingString);
        }
        return scenario;
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

    private AutoArgScenarioTable getCallingTable(ScenarioTestContext context) {
        ScenarioTable t = context.getScenarioTable();
        if (t instanceof AutoArgScenarioTable) {
            return (AutoArgScenarioTable) t;
        } else {
            return null;
        }
    }
}
