// Copyright (C) 2003-2009 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the CPL Common Public License version 1.0.
package nl.hsac.fitnesse.slimcoverage;

import fitnesse.testsystems.TestPage;
import fitnesse.testsystems.slim.SlimTestContextImpl;
import fitnesse.testsystems.slim.tables.ScenarioTable;

public class SlimCoverageTestContextImpl extends SlimTestContextImpl {
    private final SlimScenarioUsagePer usage;

    public SlimCoverageTestContextImpl(TestPage testPage, SlimScenarioUsagePer usageByPage) {
        super(testPage);
        usage = usageByPage;
    }

    @Override
    public void addScenario(String scenarioName, ScenarioTable scenarioTable) {
        if (usage != null) {
            String key = getGroupName(scenarioTable);
            usage.addDefinition(key);
        }
        super.addScenario(scenarioName, scenarioTable);
    }

    public ScenarioTable getScenario(String scenarioName) {
        ScenarioTable scenarioTable = getScenarioNoCount(scenarioName);
        trackUsage(scenarioTable);
        return scenarioTable;
    }

    public ScenarioTable getScenarioNoCount(String scenarioName) {
        return super.getScenario(scenarioName);
    }

    @Override
    public ScenarioTable getScenarioByPattern(String invokingString) {
        ScenarioTable scenarioTable = getScenarioByPatternNoCount(invokingString);
        trackUsage(scenarioTable);
        return scenarioTable;
    }

    public ScenarioTable getScenarioByPatternNoCount(String invokingString) {
        return super.getScenarioByPattern(invokingString);
    }

    protected void trackUsage(ScenarioTable scenarioTable) {
        if (usage != null && scenarioTable != null) {
            String key = getGroupName(scenarioTable);
            usage.addUsage(key);
        }
    }

    protected String getGroupName(ScenarioTable scenarioTable) {
        String name = scenarioTable.getName();
        int inputCount = scenarioTable.getInputs().size();
        int outputCount = scenarioTable.getOutputs().size();
        String keyPattern;
        if (inputCount == 0 && outputCount == 0) {
            keyPattern = "%s";
        } else if (outputCount == 0) {
            keyPattern = "%s[%s]";
        } else {
            keyPattern = "%s[%s,%s]";
        }
        return String.format(keyPattern, name, inputCount, outputCount);
    }
}
