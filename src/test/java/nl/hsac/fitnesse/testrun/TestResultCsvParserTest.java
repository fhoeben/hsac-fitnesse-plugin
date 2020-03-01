package nl.hsac.fitnesse.testrun;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestResultCsvParserTest {
    static final int RECORD_COUNT = 167;
    static final String TEST_RESULTS_CSV = "src/test/resources/test-results.csv";

    @Test
    public void canParse() {
        List<DurationRecord<String>> records = getDurationRecords();

        // 174 lines in file
        // 1 header record
        // 2 overview pages
        // 4 tests with unknown times
        assertEquals(RECORD_COUNT, records.size());

        DurationRecord<String> record = records.get(3);
        assertEquals("HsacAcceptanceTests.SlimTests.BrowserTest.SuiteSetUp", record.getElement());
        assertEquals(67L, record.getDuration());
    }

    static List<DurationRecord<String>> getDurationRecords() {
        return new TestResultCsvParser().parse(TEST_RESULTS_CSV);
    }

}
