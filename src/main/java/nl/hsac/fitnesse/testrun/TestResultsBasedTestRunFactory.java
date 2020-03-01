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
    public static final String SKIP_ARG = "ignoreTestResultsFile";

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
        return super.getFile(pages).filter(File::exists);
    }

    @Override
    protected String getFilename(List<WikiPage> pages) {
        return pages.get(0).getVariable(SKIP_ARG) != null ? null : "test-results.csv";
    }
}
