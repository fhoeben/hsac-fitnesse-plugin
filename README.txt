Plugin to add some additional features to a FitNesse (http://fitnesse.org) wiki.

Wiki symbols:
- Relative dates: months or weekdays from today (extension on standard !today)
- Random values: strings, numbers, International Bank Account Numbers and Burger Service Numbers (Dutch social security numbers)
- Define default, allows a wiki variable whose value can be overridden using a system property.

Slim tables:
- table template: scenario without need to define all parameters in first line
- storyboard: script which takes a 'screenshot' after each row

Tool to determine usage of scenarios in Slim suite:
- Change test system used from 'slim' to 'slimCoverage'
- Run suite (the test will not actually call any fixtures)
- An extra result (Scenario Usage Report) is added listing the scenarios which are never used, and some statistics on those that are used.

Duration based test suite partitioner:
Uses the test times recorded during a previous run to split a test suite in partitions.
It tries to make partitions that all take the same amount of time, as opposed to the default FitNesse partitioner that aims for partitions with the same number of tests.
To activate this places a file called 'test-results.csv' in the 'files' section of the wiki.
It expects the file to be in the format created by hsac-fitnesse-fixtures' HtmlReportIndexGenerator, a sample can be found at https://github.com/fhoeben/hsac-fitnesse-plugin/blob/master/src/test/resources/test-results.csv.
- Ensure FitNesseRoot/files/test-results.csv exists
- Run each partition by adding 'partitionIndex=${INDEX}' and 'partitionCount=${COUNT}' parameters (where ${INDEX} is between 0 and ${COUNT}-1)


This plugin is included in the FitNesse baseline installation of https://github.com/fhoeben/hsac-fitnesse-fixtures.
After starting that installation Wiki pages demonstrating the use of this plugin can be opened:
- HsacExamples.SymbolSamples,
- HsacExamples.SlimTests.BrowserTests.TableTemplateTest
- HsacExamples.SlimTests.BrowserTests.StoryboardTest and
- HsacExamples.SlimTests.BrowserTests.TemplateStoryboardTest).


To use this plugin in a 'plain vanilla' FitNesse installation:
- copy .jar it to $FITNESSE_HOME/plugins
