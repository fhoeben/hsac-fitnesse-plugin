package nl.hsac.fitnesse.slim.tables;

/**
 * Sample fixture supporting screenshots as needed by {@link nl.hsac.fitnesse.slim.StoryboardTable}
 */
public class SampleScreenshotFixture {
    public String takeScreenshot(String basename) {
        return "screenshot: " + basename;
    }
}
