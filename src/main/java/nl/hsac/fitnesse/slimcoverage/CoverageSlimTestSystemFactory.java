package nl.hsac.fitnesse.slimcoverage;

import fitnesse.testsystems.Descriptor;
import fitnesse.testsystems.TestSystem;
import fitnesse.testsystems.TestSystemFactory;
import fitnesse.testsystems.slim.CustomComparatorRegistry;
import fitnesse.testsystems.slim.tables.SlimTableFactory;

import java.io.IOException;

/**
 * Factory to create SlimCoverageTestSystem.
 */
public class CoverageSlimTestSystemFactory implements TestSystemFactory {
    private final SlimTableFactory slimTableFactory;
    private final CustomComparatorRegistry customComparatorRegistry;

    public CoverageSlimTestSystemFactory(SlimTableFactory slimTableFactory,
                                         CustomComparatorRegistry customComparatorRegistry) {
        this.slimTableFactory = slimTableFactory;
        this.customComparatorRegistry = customComparatorRegistry;
    }

    @Override
    public final TestSystem create(Descriptor descriptor) {
        SlimCoverageTestSystem testSystem = new SlimCoverageTestSystem("slimCoverage",
                slimTableFactory.copy(), customComparatorRegistry);

        return testSystem;
    }
}
