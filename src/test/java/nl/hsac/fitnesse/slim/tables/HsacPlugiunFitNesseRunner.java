package nl.hsac.fitnesse.slim.tables;

import fitnesse.junit.DescriptionFactory;
import fitnesse.junit.FitNesseRunner;
import fitnesse.junit.JUnitRunNotifierResultsListener;
import fitnesse.testrunner.MultipleTestsRunner;
import org.junit.ComparisonFailure;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import util.FileUtil;

import java.io.IOException;

/**
 * Custom jUnitRunner which allows us to run tests with slim coverage, without the run failing because we added an extra
 * page, and check its result.
 */
public class HsacPlugiunFitNesseRunner extends FitNesseRunner {
    public HsacPlugiunFitNesseRunner(Class<?> suiteClass) throws InitializationError {
        super(suiteClass);
    }

    @Override
    protected void addTestSystemListeners(RunNotifier notifier, MultipleTestsRunner testRunner, Class<?> suiteClass, DescriptionFactory descriptionFactory) {
         // custom listener is no longer needed once a fitnesse release including https://github.com/unclebob/fitnesse/pull/1105 is used.
        testRunner.addTestSystemListener(new CustomJUnitRunNotifierListener(notifier, suiteClass, descriptionFactory));
    }

    @Override
    public void run(final RunNotifier notifier) {
        try {
            super.run(notifier);
        } finally {
            checkHtmlResultContent(notifier, "usageCheck", "ScenarioUsageReport.html");

            checkHtmlResultContent(notifier, "storyboardCheck1", "HsacPlugin.StoryboardTest1.html");
            checkHtmlResultContent(notifier, "storyboardCheck2", "HsacPlugin.StoryboardTest2.html");
        }
    }

    private void checkHtmlResultContent(RunNotifier notifier, String name, String actualFile) {
        Class<?> aClass = getTestClass().getJavaClass();
        try {
            String expectedUsageReport = FileUtil.getFileContent("src/test/resources/Expected." + actualFile);
            String actualUsageReport = FileUtil.getFileContent(getOutputDir(aClass) + "/" + actualFile);
            if(!expectedUsageReport.equals(actualUsageReport)) {
                ComparisonFailure e = new ComparisonFailure("Unexpected content in: " + actualFile, expectedUsageReport, actualUsageReport);
                notifier.fireTestFailure(new Failure(Description.createTestDescription(aClass, name), e));
            }
        } catch (InitializationError | IOException e) {
            notifier.fireTestFailure(new Failure(Description.createTestDescription(aClass, name), e));
        }
    }

    private static class CustomJUnitRunNotifierListener extends JUnitRunNotifierResultsListener {
        public CustomJUnitRunNotifierListener(RunNotifier notifier, Class<?> mainClass, DescriptionFactory descriptionFactory) {
            super(notifier, mainClass, descriptionFactory);
        }

        @Override
        public void announceNumberTestsToRun(int testsToRun) {
            // expect one more for the scenario usage report page
            super.announceNumberTestsToRun(testsToRun + 1);
        }
    }
}
