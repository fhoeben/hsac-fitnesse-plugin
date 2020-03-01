package nl.hsac.fitnesse.testrun;

import fitnesse.wiki.WikiPage;
import fitnesse.wiki.WikiPageDummy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DurationBasedWikiPagePartitionerTest {

    @Test
    public void testDurationSplit() {
        List<DurationRecord<String>> records = new TestResultCsvParser().parse("src/test/resources/test-results.csv");
        WikiPageDummy root = new WikiPageDummy("root", "root page", null);
        List<WikiPage> names = records.stream()
                .map(DurationRecord::getElement)
                .map(n -> new WikiPageDummy(n, n, root))
                .collect(Collectors.toList());

        DurationBasedWikiPagePartitioner partitioner = new DurationBasedWikiPagePartitioner(records);

        List<List<WikiPage>> result = partitioner.split(names, 4);

        assertEquals(4, result.size());

        List<WikiPage> all = new ArrayList<>(names.size());
        result.forEach(all::addAll);
        assertEquals(names.size(), all.size());

        assertEquals(1, result.get(0).size());
        assertEquals("HsacExamples.SlimTests.BrowserTests.CustomFixtureTest", geName(result.get(0).get(0)));

        Map<String, Long> timePerTest = DurationRecord.toMap(records);
        assertEquals(1318937L, result.get(0).stream().mapToLong(p -> timePerTest.get(geName(p))).sum());
        assertEquals(112349L, result.get(1).stream().mapToLong(p -> timePerTest.get(geName(p))).sum());
        assertEquals(112348L, result.get(2).stream().mapToLong(p -> timePerTest.get(geName(p))).sum());
        assertEquals(112348L, result.get(3).stream().mapToLong(p -> timePerTest.get(geName(p))).sum());
    }

    private String geName(WikiPage p) {
        return p.getFullPath().toString();
    }

}
