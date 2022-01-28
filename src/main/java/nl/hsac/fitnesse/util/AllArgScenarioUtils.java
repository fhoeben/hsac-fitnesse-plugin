package nl.hsac.fitnesse.util;

import fitnesse.slim.StopTestSlimException;
import fitnesse.testsystems.TestExecutionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AllArgScenarioUtils {
    /**
     * Method allows to parse argument list provided with @{*} symbol in all arg table
     * @param args list of variables and their values
     * @return parsed map of input arguments which can be used to easily map values in fixture
     * @throws StopTestSlimException when number of parameters don't match expected value
     */
    public static HashMap<String,String> parseFitNesseArgsList(String[] args) throws StopTestSlimException {
        HashMap<String,String> argsParsed = new HashMap<>();
        ArrayList<String> tmpList = (ArrayList<String>) Arrays.stream(args).collect(Collectors.toList());
        if(Math.floorMod(tmpList.size(),2) != 0) {
            throw new StopTestSlimException("Incorrect number of arguments in class constructor. Please check your test syntax. The only attribute that is allowed in this constructor is @{*}");
        }
        for(int i = 0;i<= tmpList.size()-2;i+=2){
            String key = tmpList.get(i);
            String value = tmpList.get(i+1);
            argsParsed.put(key,value);
        }
        return argsParsed;
    }
}
