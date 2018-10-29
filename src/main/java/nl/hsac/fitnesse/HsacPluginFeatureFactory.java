package nl.hsac.fitnesse;

import fitnesse.plugins.PluginException;
import fitnesse.plugins.PluginFeatureFactoryBase;
import fitnesse.testrunner.TestSystemFactoryRegistry;
import fitnesse.testsystems.slim.CustomComparatorRegistry;
import fitnesse.testsystems.slim.tables.SlimTable;
import fitnesse.testsystems.slim.tables.SlimTableFactory;
import fitnesse.wikitext.parser.SymbolProvider;
import fitnesse.wikitext.parser.SymbolType;
import nl.hsac.fitnesse.slim.AutoArgScenarioTable;
import nl.hsac.fitnesse.slim.StoryboardTable;
import nl.hsac.fitnesse.slimcoverage.CoverageSlimTestSystemFactory;
import nl.hsac.fitnesse.symbols.*;

public class HsacPluginFeatureFactory extends PluginFeatureFactoryBase {
    private SlimTableFactory slimTableFactory;
    private CustomComparatorRegistry customComparatorRegistry;
    private TestSystemFactoryRegistry testSystemFactoryRegistry;

    @Override
    public void registerSlimTables(SlimTableFactory slimTableFactory) throws PluginException {
        super.registerSlimTables(slimTableFactory);
        add(slimTableFactory, "table template", AutoArgScenarioTable.class);
        add(slimTableFactory, "storyboard", StoryboardTable.class);

        this.slimTableFactory = slimTableFactory;
        registerSlimCoverageIfPossible();
    }

    private void add(SlimTableFactory factory, String prefix, Class<? extends SlimTable> tableType) {
        factory.addTableType(prefix, tableType);
        LOG.info("Added Slim table type: " + prefix + ": " + tableType.getName());
    }

    @Override
    public void registerSymbolTypes(SymbolProvider symbolProvider) throws PluginException {
        super.registerSymbolTypes(symbolProvider);
        add(symbolProvider, new MonthsFromToday());
        add(symbolProvider, new YearsFromToday());
        add(symbolProvider, new WeekDaysFromToday());
        add(symbolProvider, new DayOfWeek.Monday());
        add(symbolProvider, new DayOfWeek.Tuesday());
        add(symbolProvider, new DayOfWeek.Wednesday());
        add(symbolProvider, new DayOfWeek.Thursday());
        add(symbolProvider, new DayOfWeek.Friday());
        add(symbolProvider, new DayOfWeek.Saturday());
        add(symbolProvider, new DayOfWeek.Sunday());
        add(symbolProvider, new LastDayOfMonth());
        add(symbolProvider, new RandomInt());
        add(symbolProvider, new RandomString());
        add(symbolProvider, new RandomBsn());
        add(symbolProvider, new RandomEmail());
        add(symbolProvider, new RandomIban());
        add(symbolProvider, new RandomPostalCode());
        add(symbolProvider, new RandomDutchLicensePlate());
        add(symbolProvider, new DefineDefault());
        add(symbolProvider, new DefineFromProperties());
        add(symbolProvider, new DefineDefaultFromProperties());
    }

    private void add(SymbolProvider provider, SymbolType symbolType) {
        provider.add(symbolType);
        LOG.info("Added symbol " + symbolType.getClass());
    }

    @Override
    public void registerCustomComparators(CustomComparatorRegistry customComparatorRegistry) throws PluginException {
        this.customComparatorRegistry = customComparatorRegistry;
        registerSlimCoverageIfPossible();
    }

    @Override
    public void registerTestSystemFactories(TestSystemFactoryRegistry testSystemFactoryRegistry) throws PluginException {
        this.testSystemFactoryRegistry = testSystemFactoryRegistry;
        registerSlimCoverageIfPossible();
    }

    protected void registerSlimCoverageIfPossible() {
        if (slimTableFactory != null
                && customComparatorRegistry != null
                && testSystemFactoryRegistry != null) {

            testSystemFactoryRegistry
                    .registerTestSystemFactory("slimcoverage",
                            new CoverageSlimTestSystemFactory(slimTableFactory, customComparatorRegistry));
            LOG.info("Registered test system slimcoverage");
        }
    }
}
