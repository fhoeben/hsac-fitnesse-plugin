package nl.hsac.fitnesse.testrun;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PositionFinderTest {
    private final static List<DurationRecord<String>> RECORDS = TestResultCsvParserTest.getDurationRecords();

    private final PositionFinder<String> finder = new PositionFinder<>();

    @Test
    public void testPositionsEmptyList() {
        Map<String, Integer> positions = finder.getPositionMap(Collections.emptyList(), RECORDS, 4);
        assertEquals(0, positions.size());
    }

    @Test
    public void testPositionsEmptyDurations() {
        String name1 = RECORDS.get(0).getElement();
        String name4 = RECORDS.get(3).getElement();
        List<String> names = Arrays.asList(name1, name4);

        Map<String, Integer> positions = finder.getPositionMap(names, Collections.emptyList(), 2);
        assertEquals(0, positions.size());
    }

    @Test
    public void testPositionsSomeFound() {
        String name1 = RECORDS.get(0).getElement();
        String name3 = RECORDS.get(2).getElement();
        String name4 = RECORDS.get(3).getElement();
        List<String> names = Arrays.asList(name1, name3, name4);
        Map<String, Integer> positions = finder.getPositionMap(names, RECORDS, 2);
        assertEquals(3, positions.size());
        assertEquals(1, (int) positions.get(name1));
        assertEquals(1, (int) positions.get(name3));
        assertEquals(0, (int) positions.get(name4));
    }

    @Test
    public void testPositionsAllFound() {
        List<String> names = RECORDS.stream()
                .map(DurationRecord::getElement)
                .collect(Collectors.toList());

        Map<String, Integer> positions = finder.getPositionMap(names, RECORDS, 4);

        Set<Integer> indices = new LinkedHashSet<>(positions.values());
        assertEquals(4, indices.size());
        for (int i = 0; i < 4; i++) {
            assertTrue(indices.contains(i));
        }

        assertEquals(names.size(), positions.size());

        assertEquals(0, (long) positions.get("HsacExamples.SlimTests.BrowserTests.CustomFixtureTest"));
        List<String> in0 = positions.entrySet().stream()
                .filter(e -> e.getValue() == 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        assertEquals(1, in0.size());

        List<String> in1 = positions.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        assertEquals(51, in1.size());

        List<String> in2 = positions.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        assertEquals(60, in2.size());

        List<String> in3 = positions.entrySet().stream()
                .filter(e -> e.getValue() == 3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        assertEquals(55, in3.size());

        Map<String, Long> timePerTest = DurationRecord.toMap(RECORDS);
        assertEquals(1318937L, in0.stream().mapToLong(timePerTest::get).sum());
        assertEquals(112349L, in1.stream().mapToLong(timePerTest::get).sum());
        assertEquals(112348L, in2.stream().mapToLong(timePerTest::get).sum());
        assertEquals(112348L, in3.stream().mapToLong(timePerTest::get).sum());
    }

}
