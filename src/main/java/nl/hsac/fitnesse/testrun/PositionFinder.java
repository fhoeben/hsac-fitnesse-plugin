package nl.hsac.fitnesse.testrun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * Finds position for each element based on supplied durations.
 */
public class PositionFinder<T> {

    public Map<T, Integer> getPositionMap(List<T> source, List<DurationRecord<T>> durations, int partitionCount) {
        if (source.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<T, Integer> positionMap = new LinkedHashMap<>(source.size() * 2);
        // sort by descending duration
        PriorityQueue<DurationRecord<T>> durationQueue = new PriorityQueue<>(source.size(), Comparator.reverseOrder());
        durations.stream().filter(i -> source.contains(i.getElement())).forEach(durationQueue::add);

        List<Long> partitionSizes = new ArrayList<>(partitionCount);
        for (int i = 0; i < partitionCount; i++) {
            partitionSizes.add(0L);
        }
        while (!durationQueue.isEmpty()) {
            // add record to partition with smallest total duration
            DurationRecord<T> record = durationQueue.poll();
            long duration = record.getDuration();
            int indexToAddTo = smallestPartition(partitionSizes);
            long currentSize = partitionSizes.get(indexToAddTo);
            partitionSizes.set(indexToAddTo, currentSize + duration);
            positionMap.put(record.getElement(), indexToAddTo);
        }
        return positionMap;
    }

    protected int smallestPartition(List<Long> partitionSizes) {
        return IntStream.range(0, partitionSizes.size())
                .reduce((i, j) -> partitionSizes.get(i) > partitionSizes.get(j) ? j : i)
                .getAsInt();
    }
}
