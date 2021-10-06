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
    protected void testOutputChunk(TestPage testPage, String output) {
        if (inUsageReport) {
            super.testOutputChunk(testPage, output);
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

    protected void reportScenarioUsage() {
        WikiPageDummy dummyRoot = new WikiPageDummy("Scenario Usage Report Parent", "Scenario Usage Report Parent Content", null);
        WikiPageDummy pageDummy = new WikiPageDummy("ScenarioUsageReport", "Scenario Usage Report Content", dummyRoot);
        WikiTestPage testPage = new WikiTestPage(pageDummy);
        testStarted(testPage);
        // ensure we have a single test passed, which is sometimes a requirement
        // (i.e. when run by FitNesseRunner)
        getTestContext().incrementPassedTestsCount();

        writeReport(testPage, usage);

        testComplete(testPage, new TestSummary(1, 0, 0, 0));
    }

    protected void writeReport(TestPage testPage, SlimScenarioUsage scenarioUsage) {
        new SlimCoverageReportWriter(scenarioUsage, s -> this.testOutputChunk(testPage, s)).reportScenarioUsage();
    }
}
