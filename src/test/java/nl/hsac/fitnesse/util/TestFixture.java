package nl.hsac.fitnesse.util;

import fitnesse.slim.StopTestSlimException;

import java.util.LinkedHashMap;

/**
 * Example fixture for all arg scenario table usage.
 */
public class TestFixture {

    LinkedHashMap<String,String> argsMap;

    public TestFixture(){
        argsMap = new LinkedHashMap<>();
    }

    public TestFixture(String[] args) throws StopTestSlimException {
        argsMap = new LinkedHashMap<>();
        parseFitNesseArgsList(args);
    }

    public String getValue(String key){
        return argsMap.get(key);
    }

    /**
     * Method allows to parse argument list provided with @{*} symbol in all arg table. This method is just an example
     * for possible implementation for attribute parsing.
     * @param args list of variables and their values
     * @return parsed map of input arguments which can be used to easily map values in fixture
     * @throws StopTestSlimException when number of parameters don't match expected value
     */
    private void parseFitNesseArgsList(String[] args) throws StopTestSlimException {
        if(Math.floorMod(args.length,2) != 0) {
            throw new StopTestSlimException("Incorrect number of arguments in class constructor. Please check your test syntax. The only attribute that is allowed in this constructor is @{*}");
        }
        for(int i = 0;i<= args.length-2;i+=2){
            String key = args[i];
            String value = args[i+1];
            argsMap.put(key,value);
        }
    }

    public void setValue(String key, String value){
        argsMap.put(key,value);
    }
}
