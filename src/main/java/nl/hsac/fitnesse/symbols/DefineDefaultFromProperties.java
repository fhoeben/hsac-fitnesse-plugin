package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.Parser;

import java.util.Properties;

/**
 * DefineFromProperties which only takes those properties from .properties that define variables not aready set via
 * a system property.
 */
public class DefineDefaultFromProperties extends DefineFromProperties {
    public DefineDefaultFromProperties() {
        super("DefineDefaultFromProperties", "!defineDefaultFromProperties");
    }

    @Override
    protected String handleProperty(Parser parser, Properties props, String propertyName) {
        String variableValue;
        String propValue = System.getProperty(propertyName);
        if (propValue == null) {
            variableValue = super.handleProperty(parser, props, propertyName);
        } else {
            variableValue = propValue;
        }
        return variableValue;
    }
}
