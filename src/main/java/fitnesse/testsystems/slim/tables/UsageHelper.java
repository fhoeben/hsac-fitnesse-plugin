package fitnesse.testsystems.slim.tables;

/**
 * Helper to ensure a scenario's arguments have been resolved before determine its key in SlimCoverageTestContextImpl.
 */
public class UsageHelper {
    /**
     * Ensures scenario's arguments have been resolved before determine its key in SlimCoverageTestContextImpl.
     * @param scenarioTable scenario to have its arguments resolved.
     */
    public static void resolveArguments(ScenarioTable scenarioTable) {
        scenarioTable.getScenarioArguments();
    }
}
