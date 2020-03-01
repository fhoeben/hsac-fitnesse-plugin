package nl.hsac.fitnesse.testrun;

import fitnesse.FitNesseContext;
import fitnesse.testrunner.run.FileBasedTestRunFactory;
import fitnesse.util.partitioner.ListPartitioner;
import fitnesse.wiki.WikiPage;

import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * Partitions test pages based on the test-results.csv file in the files section,
 * if it is present.
 */
public class TestResultsBasedTestRunFactory extends FileBasedTestRunFactory {
    public static final String TEST_RESULTS_FILE_ARG = "testResultsFile";

    public TestResultsBasedTestRunFactory(FitNesseContext context) {
        super(context);
    }

    @Override
    protected ListPartitioner<WikiPage> createPartitioner(File f) {
        List<DurationRecord<String>> durations = new TestResultCsvParser().parse(f);
        return new DurationBasedWikiPagePartitioner(durations);
    }

    @Override
    protected Optional<File> getFile(List<WikiPage> pages) {
        // if the test results file does not exist this factory cannot make a run
        return super.getFile(pages).filter(File::exists);
    }

    @Override
    protected String getFilename(List<WikiPage> pages) {
        String explicitFile = pages.get(0).getVariable(TEST_RESULTS_FILE_ARG);
        return explicitFile == null ? "test-results.csv" : explicitFile;
    }
}
