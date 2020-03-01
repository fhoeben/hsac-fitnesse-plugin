package nl.hsac.fitnesse.testrun;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DurationRecordTest {

    @Test
    public void testCompare() {
        DurationRecord<String> a = new DurationRecord<>("a", 10);
        DurationRecord<String> b = new DurationRecord<>("b", 20);
        DurationRecord<String> c = new DurationRecord<>("c", 20);
        DurationRecord<String> d = new DurationRecord<>("d", 40);

        assertTrue(a.compareTo(b) < 0);
        assertTrue(b.compareTo(a) > 0);
        assertTrue(b.compareTo(c) == 0);
        assertTrue(a.compareTo(d) < 0);
        assertTrue(a.compareTo(a) == 0);
    }

    @Test
    public void testToMap() {
        DurationRecord<String> a = new DurationRecord<>("a", 10);
        DurationRecord<String> b = new DurationRecord<>("b", 20);

        Map<String, Long> map = DurationRecord.toMap(asList(a, b));
        assertEquals(2, map.size());
        assertEquals(10, (long) map.get("a"));
        assertEquals(20, (long) map.get("b"));
    }

    @Test
    public void testToList() {
        Map<String, Long> map = new LinkedHashMap<>();
        map.put("a", 10L);
        map.put("b", 20L);

        List<DurationRecord<String>> list = DurationRecord.toList(map);
        DurationRecord<String> first = list.get(0);
        assertEquals(10, first.getDuration());
        assertEquals("a", first.getElement());
        DurationRecord<String> second = list.get(1);
        assertEquals(20, second.getDuration());
        assertEquals("b", second.getElement());
    }
}
