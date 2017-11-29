package nl.hsac.fitnesse.slimcoverage;

import fitnesse.slim.instructions.Instruction;
import fitnesse.testrunner.WikiTestPage;
import fitnesse.testsystems.TestExecutionException;
import fitnesse.testsystems.TestPage;
import fitnesse.testsystems.TestSummary;
import fitnesse.testsystems.UnableToStopException;
import fitnesse.testsystems.slim.CustomComparatorRegistry;
import fitnesse.testsystems.slim.HtmlSlimTestSystem;
import fitnesse.testsystems.slim.SlimClient;
import fitnesse.testsystems.slim.SlimTestContextImpl;
import fitnesse.testsystems.slim.tables.SlimTable;
import fitnesse.testsystems.slim.tables.SlimTableFactory;
import fitnesse.wiki.WikiPageDummy;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SlimCoverageTestSystem extends HtmlSlimTestSystem {
    private final SlimScenarioUsage usage;
    private boolean inUsageReport = false;

    public SlimCoverageTestSystem(String testSystemName,
                                  SlimTableFactory slimTableFactory,
                                  CustomComparatorRegistry customComparatorRegistry) {
        super(testSystemName, dummySlimClient(), slimTableFactory, customComparatorRegistry);
        this.usage = new SlimScenarioUsage();
    }

    private static SlimClient dummySlimClient() {
        return new SlimClient() {
            @Override
            public void start() throws IOException {
            }

            @Override
            public Map<String, Object> invokeAndGetResponse(List<Instruction> statements) {
                return null;
            }

            @Override
            public void connect() throws IOException {
            }

            @Override
            public void bye() {
            }

            @Override
            public void kill() {
            }
        };
    }

    public SlimScenarioUsage getUsage() {
        return usage;
    }

    @Override
    protected SlimTestContextImpl createTestContext(TestPage testPage) {
        String fullPath = testPage.getFullPath();
        SlimScenarioUsagePer usageByPage = usage.getUsageByPage(fullPath);
        return new SlimCoverageTestContextImpl(testPage, usageByPage);
    }

    @Override
    protected void processTable(SlimTable table, boolean isSuiteTearDownPage) throws TestExecutionException {
        table.getAssertions();
    }

    @Override
    protected void testComplete(TestPage testPage, TestSummary testSummary) {
        if (!inUsageReport) {
            testSummary = new TestSummary(0, 0, 1, 0);
        }
        super.testComplete(testPage, testSummary);
    }

    @Override
    protected void testOutputChunk(String output) {
        if (inUsageReport) {
            super.testOutputChunk(output);
        }
    }

    @Override
    public void bye() throws UnableToStopException {
        try {
            inUsageReport = true;
            reportScenarioUsage();
        } finally {
            super.bye();
        }
    }

    protected void reportScenarioUsageHeader(String header) {
        testOutputChunk("<h4>" + header + "</h4>");
    }

    protected void reportScenarioUsageNewline() {
        testOutputChunk("<br/>");
    }

    protected void reportScenarioUsage() {
        WikiPageDummy dummyRoot = new WikiPageDummy("Scenario Usage Report Parent", "Scenario Usage Report Parent Content", null);
        WikiPageDummy pageDummy = new WikiPageDummy("ScenarioUsageReport", "Scenario Usage Report Content", dummyRoot);
        WikiTestPage testPage = new WikiTestPage(pageDummy);
        testStarted(testPage);
        // ensure we have a single test passed, which is sometimes a requirement
        // (i.e. when run by FitNesseRunner)
        getTestContext().incrementPassedTestsCount();

        Map<String, Integer> totalUsage = usage.getScenarioUsage().getUsage();
        if (totalUsage.isEmpty()) {
            testOutputChunk("No scenarios in run");
        } else {
            Collection<String> unused = usage.getUnusedScenarios();
            if (!unused.isEmpty()) {
                reportScenarioUsageHeader("Unused scenarios:");
                testOutputChunk("<ul>");
                for (String scenarioName : unused) {
                    testOutputChunk("<li>" + scenarioName + "</li>");
                }
                testOutputChunk("</ul>");
                reportScenarioUsageNewline();
            }

            reportScenarioUsageHeader("Total usage count per scenario:");
            testOutputChunk("<table>");
            testOutputChunk("<tr><th>Scenario</th><th>Count</th></tr>");
            outputTableRows(totalUsage);
            testOutputChunk("</table>");
            reportScenarioUsageNewline();

            reportScenarioUsageHeader("Scenarios grouped by usage scope:");
            Map<String, Collection<String>> scenariosBySmallestScope = usage.getScenariosBySmallestScope();
            outputNestedList(scenariosBySmallestScope);
            reportScenarioUsageNewline();

            reportScenarioUsageHeader("Usage count per scenario per page:");
            testOutputChunk("<table>");
            testOutputChunk("<tr><th>Page</th><th>Scenario</th><th>Count</th></tr>");
            for (SlimScenarioUsagePer usagePerPage : usage.getUsage()) {
                String pageName = usagePerPage.getGroupName();
                String pageLink = String.format("<a href=\"/%1$s\">%1$s</a>", pageName);
                outputTableRows(usagePerPage.getUsage(), pageLink);
            }
            testOutputChunk("</table>");

            Map<String, Collection<String>> overriddenPerPage = usage.getOverriddenScenariosPerPage();
            if (!overriddenPerPage.isEmpty()) {
                reportScenarioUsageNewline();
                reportScenarioUsageHeader("Overridden scenario(s) per page:");
                outputNestedList(overriddenPerPage);
            }
        }
        testComplete(testPage, new TestSummary(1, 0, 0, 0));
    }

    private void outputTableRows(Map<String, Integer> tableRows, String... prefixes) {
        for (Map.Entry<String, Integer> usagePerScenario : tableRows.entrySet()) {
            testOutputChunk("<tr>");
            testOutputChunk("<td>");
            for (String prefix : prefixes) {
                testOutputChunk(prefix + "</td><td>");
            }
            testOutputChunk(usagePerScenario.getKey()
                    + "</td><td>"
                    + usagePerScenario.getValue());
            testOutputChunk("</td>");
            testOutputChunk("</tr>");
        }
    }

    private void outputNestedList(Map<String, Collection<String>> nestedList) {
        testOutputChunk("<ul>");
        for (Map.Entry<String, Collection<String>> item : nestedList.entrySet()) {
            String itemName = item.getKey();
            testOutputChunk("<li>");
            testOutputChunk(itemName);
            testOutputChunk("<ul>");
            for (String nestedName : item.getValue()) {
                testOutputChunk("<li>" + nestedName + "</li>");
            }
            testOutputChunk("</ul>");
            testOutputChunk("</li>");
        }
        testOutputChunk("</ul>");
    }

}
