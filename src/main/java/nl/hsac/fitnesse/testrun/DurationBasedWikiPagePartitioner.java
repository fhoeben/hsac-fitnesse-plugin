package nl.hsac.fitnesse.testrun;

import fitnesse.testrunner.run.PositionMapBasedWikiPagePartitioner;
import fitnesse.wiki.WikiPage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Partitions pages based on provided DurationRecords.
 */
public class DurationBasedWikiPagePartitioner extends PositionMapBasedWikiPagePartitioner {
  private List<DurationRecord<String>> durationRecords;

  public DurationBasedWikiPagePartitioner(List<DurationRecord<String>> durationRecords) {
    if (durationRecords != null) {
      setDurationRecords(durationRecords);
    }
  }

  @Override
  public List<List<WikiPage>> split(List<WikiPage> pages, int partitionCount) {
    Map<String, Integer> positionMap = createPartitionMap(pages, partitionCount);
    setPartitionMap(positionMap);
    return super.split(pages, partitionCount);
  }

  protected Map<String, Integer> createPartitionMap(List<WikiPage> pages, int partitionCount) {
    List<String> names = getFullPaths(pages);
    return new PositionFinder<String>().getPositionMap(names, durationRecords, partitionCount);
  }

  protected List<String> getFullPaths(List<WikiPage> pages) {
    return pages.stream().map(this::getFullPath).collect(Collectors.toList());
  }

  public void setDurationRecords(List<DurationRecord<String>> durationRecords) {
    this.durationRecords = durationRecords;
  }

  public List<DurationRecord<String>> getDurationRecords() {
    return durationRecords;
  }
}
