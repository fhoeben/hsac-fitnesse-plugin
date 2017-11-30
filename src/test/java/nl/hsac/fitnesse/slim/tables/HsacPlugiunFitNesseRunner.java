package nl.hsac.fitnesse.slim.tables;

import fitnesse.junit.DescriptionFactory;
import fitnesse.junit.FitNesseRunner;
import fitnesse.junit.JUnitRunNotifierResultsListener;
import fitnesse.testrunner.MultipleTestsRunner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

/**
 * Custom jUnitRunner which allows us to run tests with slim coverage, without the run failing because we added an extra
 * page.
 */
public class HsacPlugiunFitNesseRunner extends FitNesseRunner {
    public HsacPlugiunFitNesseRunner(Class<?> suiteClass) throws InitializationError {
        super(suiteClass);
    }

    @Override
    protected void addTestSystemListeners(RunNotifier notifier, MultipleTestsRunner testRunner, Class<?> suiteClass, DescriptionFactory descriptionFactory) {
        testRunner.addTestSystemListener(new CustomJUnitRunNotifierListener(notifier, suiteClass, descriptionFactory));
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
