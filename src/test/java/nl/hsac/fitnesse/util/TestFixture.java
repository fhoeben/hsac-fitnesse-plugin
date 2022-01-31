package nl.hsac.fitnesse.util;

import fitnesse.slim.StopTestSlimException;

import java.util.HashMap;

import static nl.hsac.fitnesse.util.AllArgScenarioUtils.parseFitNesseArgsList;

/**
 * Example fixture for all arg scenario table usage.
 */
public class TestFixture {

    HashMap<String,String> args;

    public TestFixture(String[] args) throws StopTestSlimException {
        this.args = parseFitNesseArgsList(args);
    }

    public String getValue(String key){
        return args.get(key);
    }

}
