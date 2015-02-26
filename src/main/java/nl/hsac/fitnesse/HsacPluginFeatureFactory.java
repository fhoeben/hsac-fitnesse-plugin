package nl.hsac.fitnesse;

import fitnesse.plugins.PluginException;
import fitnesse.plugins.PluginFeatureFactoryBase;
import fitnesse.testsystems.slim.tables.SlimTable;
import fitnesse.testsystems.slim.tables.SlimTableFactory;
import fitnesse.wikitext.parser.SymbolProvider;
import fitnesse.wikitext.parser.SymbolType;
import nl.hsac.fitnesse.slim.AutoArgScenarioTable;
import nl.hsac.fitnesse.slim.StoryboardTable;
import nl.hsac.fitnesse.symbols.MonthsFromToday;
import nl.hsac.fitnesse.symbols.RandomBsn;
import nl.hsac.fitnesse.symbols.RandomInt;
import nl.hsac.fitnesse.symbols.RandomString;
import nl.hsac.fitnesse.symbols.WeekDaysFromToday;

public class HsacPluginFeatureFactory extends PluginFeatureFactoryBase {
    @Override
    public void registerSlimTables(SlimTableFactory slimTableFactory) throws PluginException {
        super.registerSlimTables(slimTableFactory);
        add(slimTableFactory, "table template", AutoArgScenarioTable.class);
        add(slimTableFactory, "storyboard", StoryboardTable.class);
    }

    private void add(SlimTableFactory factory, String prefix, Class<? extends SlimTable> tableType) {
        factory.addTableType(prefix, tableType);
        LOG.info("Added Slim table type: " + prefix + ": " + tableType.getName());
    }

    @Override
    public void registerSymbolTypes(SymbolProvider symbolProvider) throws PluginException {
        super.registerSymbolTypes(symbolProvider);
        add(symbolProvider, new MonthsFromToday());
        add(symbolProvider, new WeekDaysFromToday());
        add(symbolProvider, new RandomInt());
        add(symbolProvider, new RandomString());
        add(symbolProvider, new RandomBsn());
    }

    private void add(SymbolProvider provider, SymbolType symbolType) {
        provider.add(symbolType);
        LOG.info("Added symbol " + symbolType.getClass());
    }
}
