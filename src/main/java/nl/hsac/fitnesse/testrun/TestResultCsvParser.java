package nl.hsac.fitnesse.testrun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Parses test-results.csv (generated by nl.hsac.fitnesse.junit.reportmerge.HtmlReportIndexGenerator)
 * to extract test durations.
 */
public class TestResultCsvParser {

    public List<DurationRecord<String>> parse(String filename) {
        return parse(new File(filename));
    }

    public List<DurationRecord<String>> parse(File file) {
        if (!file.canRead()) {
            throw new IllegalArgumentException("Unable to read: " + file.getAbsolutePath());
        }

        List<DurationRecord<String>> records = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int i = 0;
            while (true) {
                i++;
                Optional<String[]> linePresent = splitNextLine(reader);
                if (!linePresent.isPresent()) {
                    break;
                }
                String[] parts = linePresent.get();
                DurationRecord<String> record = createRecord(i, parts);
                if (record != null) {
                    records.add(record);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading: " + file.getAbsolutePath(), e);
        }
        return records;
    }

    protected DurationRecord<String> createRecord(int lineNumber, String[] parts) {
        if (parts.length != 6) {
            throw new IllegalStateException("Wrong number of columns on line: " + lineNumber + " not 6 but: " + parts.length);
        }
        DurationRecord<String> record = null;
        if (lineNumber > 1 && "false".equals(parts[2])) {
            // not header row or suite overview
            String time = parts[4];
            if (!"unknown".equals(time)) {
                String page = parts[1];
                try {
                    Long duration = Long.valueOf(time);
                    record = new DurationRecord<>(page, duration);
                } catch (NumberFormatException e) {
                    throw new IllegalStateException("Unable to parse time column from line: " + lineNumber + ". Value: " + time);
                }
            }
        }
        return record;
    }

    protected Optional<String[]> splitNextLine(BufferedReader reader) throws IOException {
        return Optional.ofNullable(reader.readLine()).map(l -> l.split("\t"));
    }
}