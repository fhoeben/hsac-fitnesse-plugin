package nl.hsac.fitnesse.testrun;

import fitnesse.testutil.FitNesseUtil;
import fitnesse.util.partitioner.ListPartitioner;
import fitnesse.wiki.WikiPage;
import fitnesse.wiki.fs.InMemoryPage;
import org.junit.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestResultsBasedTestRunFactoryTest {

    @Test
    public void testDefaultFilename() {
        WikiPage p = InMemoryPage.makeRoot("root");
        TestResultsBasedTestRunFactory factory = new TestResultsBasedTestRunFactory(null);
        assertEquals("test-results.csv", factory.getFilename(Collections.singletonList(p)));
    }

    @Test
    public void testExplicitFilename() {
        WikiPage p = InMemoryPage.makeRoot("root",
                Collections.singletonMap(TestResultsBasedTestRunFactory.TEST_RESULTS_FILE_ARG, "bla.csv"));
        TestResultsBasedTestRunFactory factory = new TestResultsBasedTestRunFactory(null);
        assertEquals("bla.csv", factory.getFilename(Collections.singletonList(p)));
    }

    @Test
    public void cannotRunIfFileAbsent() {
        WikiPage p = InMemoryPage.makeRoot("root");
        TestResultsBasedTestRunFactory factory = new TestResultsBasedTestRunFactory(FitNesseUtil.makeTestContext());
        assertFalse(factory.canRun(Collections.singletonList(p)));
    }

    @Test
    public void canMakePartitioner() {
        TestResultsBasedTestRunFactory factory = new TestResultsBasedTestRunFactory(null);
        ListPartitioner<WikiPage> part = factory.createPartitioner(new File(TestResultCsvParserTest.TEST_RESULTS_CSV));

        assertNotNull(part);
        assertTrue(part instanceof DurationBasedWikiPagePartitioner);
        List<DurationRecord<String>> records = ((DurationBasedWikiPagePartitioner) part).getDurationRecords();
        assertEquals(TestResultCsvParserTest.RECORD_COUNT, records.size());
    }
}
