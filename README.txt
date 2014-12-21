Plugin to add some additional features to a FitNesse (http://fitnesse.org) wiki.

Wiki symbols:
- Relative dates: months or weekdays from today (extension on standard !today)
- Random values: strings, numbers and Burger Service Numbers (Dutch social security numbers)

Slim tables:
- table template: scenario without need to define all parameters in first line
- storyboard: script which takes a 'screenshot' after each row
- template storyboard: 'table template' scenario where a 'screenshot' is taken for each row


This plugin is included in the FitNesse baseline installation of https://github.com/fhoeben/hsac-fitnesse-fixtures.
After starting that installation Wiki pages demonstrating the use of this plugin can be opened:
- HsacExamples.SymbolSamples,
- HsacExamples.SlimTests.BrowserTests.TableTemplateTest
- HsacExamples.SlimTests.BrowserTests.StoryboardTest and
- HsacExamples.SlimTests.BrowserTests.TemplateStoryboardTest).


To use this plugin in a 'plain vanilla' FitNesse installation:
- copy .jar it to $FITNESSE_HOME/plugins
- if there already is a $FITNESSE_HOME/plugins.properties and it contains a line starting with SymbolTypes
    - add ", nl.hsac.fitnesse.symbols.MonthsFromToday, nl.hsac.fitnesse.symbols.WeekDaysFromToday, nl.hsac.fitnesse.symbols.RandomBsn, nl.hsac.fitnesse.symbols.RandomInt, nl.hsac.fitnesse.symbols.RandomString" to that line
- otherwise (create that file and) add the line: "SymbolTypes = nl.hsac.fitnesse.symbols.MonthsFromToday, nl.hsac.fitnesse.symbols.WeekDaysFromToday, nl.hsac.fitnesse.symbols.RandomBsn, nl.hsac.fitnesse.symbols.RandomInt, nl.hsac.fitnesse.symbols.RandomString"
- if there already is a line starting with SlimTables
    - add ", table template:nl.hsac.fitnesse.slim.AutoArgScenarioTable, screenplay:nl.hsac.fitnesse.slim.ScreenplayTable, template screenplay:nl.hsac.fitnesse.slim.ScreenplayAutoArgScenarioTable"
- otherwise add the line: "SlimTables = table template:nl.hsac.fitnesse.slim.AutoArgScenarioTable, storyboard:nl.hsac.fitnesse.slim.StoryboardTable, template storyboard:nl.hsac.fitnesse.slim.StoryboardAutoArgScenarioTable"
