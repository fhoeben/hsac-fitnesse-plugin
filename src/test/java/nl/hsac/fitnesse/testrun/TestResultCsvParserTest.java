package nl.hsac.fitnesse.testrun;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestResultCsvParserTest {
    private TestResultCsvParser parser = new TestResultCsvParser();

    @Test
    public void canParse() {
        List<DurationRecord<String>> records = parser.parse("src/test/resources/test-results.csv");

        // 174 lines in file
        // 1 header record
        // 2 overview pages
        // 4 tests with unknown times
        assertEquals(167, records.size());

        DurationRecord<String> record = records.get(3);
        assertEquals("HsacAcceptanceTests.SlimTests.BrowserTest.SuiteSetUp", record.getElement());
        assertEquals(67L, record.getDuration());
    }

}
