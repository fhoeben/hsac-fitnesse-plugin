package nl.hsac.fitnesse.slimcoverage;

import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;

public class SlimCoverageReportWriter {
    private static final String COPY_TO_CLIPBOARD_JS =
            "function elementContentsToClipboard(el) {" +
                    "var selected = document.getSelection().rangeCount > 0? document.getSelection().getRangeAt(0):false;" +
                    "var body = document.body, range, sel;" +
                    "if (document.createRange && window.getSelection) {" +
                    "range = document.createRange();" +
                    "sel = window.getSelection();" +
                    "sel.removeAllRanges();" +
                    "try {" +
                    "range.selectNodeContents(el);" +
                    "sel.addRange(range);" +
                    "} catch (e) {" +
                    "range.selectNode(el);" +
                    "sel.addRange(range);" +
                    "}" +
                    "document.execCommand('copy');" +
                    "} else if (body.createTextRange) {" +
                    "range = body.createTextRange();" +
                    "range.moveToElementText(el);" +
                    "range.select();" +
                    "range.execCommand('copy');" +
                    "}" +
                    "document.getSelection().removeAllRanges();" +
                    "if (selected) document.getSelection().addRange(selected);" +
                    "}";

    private final SlimScenarioUsage usage;
    private final Consumer<String> outputWriter;

    public SlimCoverageReportWriter(SlimScenarioUsage usage, Consumer<String> outputWriter) {
        this.usage = usage;
        this.outputWriter = outputWriter;
    }

    public void reportScenarioUsage() {
        Map<String, Integer> totalUsage = usage.getScenarioUsage().getUsage();
        if (totalUsage.isEmpty()) {
            write("No scenarios in run");
        } else {
            Collection<String> unused = usage.getUnusedScenarios();
            if (!unused.isEmpty()) {
                reportScenarioUsageHeader("Unused scenarios:");
                write("<ul>");
                for (String scenarioName : unused) {
                    write("<li>" + scenarioName + "</li>");
                }
                write("</ul>");
                reportScenarioUsageNewline();
            }

            writeJavaScript();
            reportScenarioUsageHeader("Total usage count per scenario:");
            writeCopyButton("totalUsageCountPerScenario");
            write("<table id='totalUsageCountPerScenario'>");
            write("<tr><th>Scenario</th><th>Count</th></tr>");
            outputTableRows(totalUsage);
            write("</table>");
            reportScenarioUsageNewline();

            reportScenarioUsageHeader("Scenarios grouped by usage scope:");
            Map<String, Collection<String>> scenariosBySmallestScope = usage.getScenariosBySmallestScope();
            outputNestedList(scenariosBySmallestScope);
            reportScenarioUsageNewline();

            reportScenarioUsageHeader("Usage count per scenario per page:");
            writeCopyButton("usageCountPerScenarioPerPage");
            write("<table id='usageCountPerScenarioPerPage'>");
            write("<tr><th>Page</th><th>Scenario</th><th>Count</th></tr>");
            for (SlimScenarioUsagePer usagePerPage : usage.getUsage()) {
                String pageName = usagePerPage.getGroupName();
                String pageLink = String.format("<a href=\"/%1$s\">%1$s</a>", pageName);
                outputTableRows(usagePerPage.getUsage(), pageLink);
            }
            write("</table>");

            Map<String, Collection<String>> overriddenPerPage = usage.getOverriddenScenariosPerPage();
            if (!overriddenPerPage.isEmpty()) {
                reportScenarioUsageNewline();
                reportScenarioUsageHeader("Overridden scenario(s) per page:");
                outputNestedList(overriddenPerPage);
            }
        }
    }

    protected void writeJavaScript() {
        StringBuilder builder = new StringBuilder();
        builder.append("<script type='text/javascript'>");
        builder.append(COPY_TO_CLIPBOARD_JS);
        builder.append("</script>");
        write(builder.toString());
    }

    protected void writeCopyButton(String idToCopy) {
        StringBuilder output = new StringBuilder();
        output.append("<input type='button' value='to clipboard' onclick=\"elementContentsToClipboard(document.getElementById('");
        output.append(idToCopy);
        output.append("'));\">");
        write(output.toString());
    }

    protected void outputTableRows(Map<String, Integer> tableRows, String... prefixes) {
        for (Map.Entry<String, Integer> usagePerScenario : tableRows.entrySet()) {
            write("<tr>");
            write("<td>");
            for (String prefix : prefixes) {
                write(prefix + "</td><td>");
            }
            write(usagePerScenario.getKey()
                    + "</td><td>"
                    + usagePerScenario.getValue());
            write("</td>");
            write("</tr>");
        }
    }

    protected void outputNestedList(Map<String, Collection<String>> nestedList) {
        write("<ul>");
        for (Map.Entry<String, Collection<String>> item : nestedList.entrySet()) {
            String itemName = item.getKey();
            write("<li>");
            write(itemName);
            write("<ul>");
            for (String nestedName : item.getValue()) {
                write("<li>" + nestedName + "</li>");
            }
            write("</ul>");
            write("</li>");
        }
        write("</ul>");
    }

    protected void reportScenarioUsageHeader(String header) {
        write("<h4>" + header + "</h4>");
    }

    protected void reportScenarioUsageNewline() {
        write("<br/>");
    }

    protected void write(String output) {
        outputWriter.accept(output);
    }
}
