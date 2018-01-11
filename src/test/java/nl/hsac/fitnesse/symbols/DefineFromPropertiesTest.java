package nl.hsac.fitnesse.symbols;

import org.junit.Test;

import java.net.URL;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DefineFromPropertiesTest {
    private final DefineFromProperties symbol = new DefineFromProperties();

    @Test
    public void resolveParamToURLFile() {
        URL url = symbol.resolveParamToURL(".gitignore");
        assertEquals("file", url.getProtocol());
        String path = url.getPath();
        assertEndsWith("path", ".gitignore", path);
    }

    @Test
    public void resolveParamToURLWithProtocol() {
        URL url = symbol.resolveParamToURL("file:.gitignore");
        assertEquals("file", url.getProtocol());
        String path = url.getPath();
        assertEndsWith("path", ".gitignore", path);
    }

    @Test
    public void resolveParamToURLFileNotFound() {
        expectIllegalArgument(() -> symbol.resolveParamToURL(".gitignore2"),
                ".gitignore2 does not exist, and no resource on classpath: .gitignore2");
    }

    @Test
    public void resolveParamToURLClasspathFile() {
        URL url = symbol.resolveParamToURL("Expected.ScenarioUsageReport.html");
        assertEquals("file", url.getProtocol());
        String path = url.getPath();
        assertEndsWith("path", "/test-classes/Expected.ScenarioUsageReport.html", path);
    }

    @Test
    public void resolveParamToURLClasspathInJar() {
        URL url = symbol.resolveParamToURL("fitnesseMain/logging.properties");
        String path = url.getPath();
        assertEndsWith("path", "/fitnesseMain/logging.properties", path);
    }

    private void expectIllegalArgument(Supplier<Object> supplier, String expectedMsgEnd) {
        try {
            Object result = supplier.get();
            fail("Expected exception, got: " + result);
        } catch (IllegalArgumentException e) {
            String msg = e.getMessage();
            assertEndsWith("message", expectedMsgEnd, msg);
        }
    }

    private static void assertEndsWith(String descr, String expectedEnd, String actual) {
        String msg = String.format("Expected %s ends with %s, got: %s", descr, expectedEnd, actual);
        assertTrue(msg, actual.endsWith(expectedEnd));
    }
}