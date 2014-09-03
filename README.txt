Plugin to add some additional features to a Fitnesse wiki.

To use this plugin:
- copy .jar it to $FITNESSE_HOME/plugins
- if there already is a $FITNESSE_HOME/plugins.properties and it contains a line starting with SymbolTypes
    - add ", nl.hsac.fitnesse.symbols.MonthsFromToday, nl.hsac.fitnesse.symbols.WeekDaysFromToday, nl.hsac.fitnesse.symbols.RandomBsn, nl.hsac.fitnesse.symbols.RandomInt, nl.hsac.fitnesse.symbols.RandomString" to that line
- otherwise (create that file and) add the line: "SymbolTypes = nl.hsac.fitnesse.symbols.MonthsFromToday, nl.hsac.fitnesse.symbols.WeekDaysFromToday, nl.hsac.fitnesse.symbols.RandomBsn, nl.hsac.fitnesse.symbols.RandomInt, nl.hsac.fitnesse.symbols.RandomString"
- if there already is a line starting with SlimTables
    - add ", table template:nl.hsac.fitnesse.slim.AutoArgScenarioTable, screenplay:nl.hsac.fitnesse.slim.ScreenplayTable, template screenplay:nl.hsac.fitnesse.slim.ScreenplayAutoArgScenarioTable"
- otherwise add the line: "SlimTables = table template:nl.hsac.fitnesse.slim.AutoArgScenarioTable, screenplay:nl.hsac.fitnesse.slim.ScreenplayTable, template screenplay:nl.hsac.fitnesse.slim.ScreenplayAutoArgScenarioTable"
