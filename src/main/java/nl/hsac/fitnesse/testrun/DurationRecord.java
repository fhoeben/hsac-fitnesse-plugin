package nl.hsac.fitnesse.testrun;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Stores duration needed for an element.
 * @param <T> element type
 */
public class DurationRecord<T> implements Comparable<DurationRecord<T>> {
    private final long duration;
    private final T element;

    public static <T> Map<T, Long> toMap(List<DurationRecord<T>> recordList) {
        return recordList.stream()
                .collect(Collectors.toMap(DurationRecord::getElement, DurationRecord::getDuration));
    }

    public static <T> List<DurationRecord<T>> toList(Map<T, Long> map) {
        return map.entrySet().stream()
                .map(e -> new DurationRecord<T>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public DurationRecord(T element, long duration) {
        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }
        this.duration = duration;
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    /**
     * @return time needed (in milliseconds)
     */
    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return element + ": " + duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DurationRecord<?> that = (DurationRecord<?>) o;
        return duration == that.duration &&
                Objects.equals(element, that.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, element);
    }

    @Override
    public int compareTo(DurationRecord<T> o) {
        return Long.compare(duration, o.duration);
    }
}
