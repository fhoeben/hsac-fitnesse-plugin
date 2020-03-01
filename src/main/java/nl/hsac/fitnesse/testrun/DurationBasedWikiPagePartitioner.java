package nl.hsac.fitnesse.testrun;

import fitnesse.util.partitioner.EqualLengthListPartitioner;
import fitnesse.util.partitioner.ListPartitioner;
import fitnesse.util.partitioner.MapBasedListPartitioner;
import fitnesse.wiki.WikiPage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Partitions pages based on provided DurationRecords.
 */
public class DurationBasedWikiPagePartitioner implements ListPartitioner<WikiPage> {
  private List<DurationRecord<String>> durationRecords;

  public DurationBasedWikiPagePartitioner(List<DurationRecord<String>> durationRecords) {
    if (durationRecords != null) {
      setDurationRecords(durationRecords);
    }
  }

  public void setDurationRecords(List<DurationRecord<String>> durationRecords) {
    this.durationRecords = durationRecords;
  }

  @Override
  public List<List<WikiPage>> split(List<WikiPage> pages, int partitionCount) {
    List<String> names = pages.stream().map(this::getName).collect(Collectors.toList());
    Map<String, Integer> positionMap = new PositionFinder<String>().getPositionMap(names, durationRecords, partitionCount);
    ListPartitioner<WikiPage> partitioner = createPartitioner(positionMap);
    return partitioner.split(pages, partitionCount);
  }

  protected ListPartitioner<WikiPage> createPartitioner(Map<String, Integer> positionMap) {
    return new MapBasedListPartitioner<>(this::getName, positionMap, this::handleUnknownPages);
  }

  protected String getName(WikiPage wikiPage) {
    return wikiPage.getFullPath().toString();
  }

  protected List<List<WikiPage>> handleUnknownPages(
    List<List<WikiPage>> partitionsFromFile,
    List<WikiPage> pagesNotPresent) {
    return new EqualLengthListPartitioner<WikiPage>().split(pagesNotPresent, partitionsFromFile.size());
  }
}
