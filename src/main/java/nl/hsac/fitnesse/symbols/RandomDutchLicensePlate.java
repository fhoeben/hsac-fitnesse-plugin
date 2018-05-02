package nl.hsac.fitnesse.symbols;

import fitnesse.wikitext.parser.*;
import nl.hsac.fitnesse.util.RandomUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Generates random Dutch license plates.
 * Usage: !randomDutchLicensePlate (Category) (Sidecode)
 * Sidecodes 4-10 are supported (see: https://nl.wikipedia.org/wiki/Nederlands_kenteken)
 * Sidecode 7 is used by default.
 * Category expects a single letter that is used as the first letter in the license plate
 * (f.e. D for mopeds, M for Motorcycle, V for light company cars, B for heavy company cars (>3500KG))
 */
public class RandomDutchLicensePlate extends SymbolBase implements Rule, Translation {

    private static final RandomUtil RANDOM_UTIL = new RandomUtil();
    private static final String CATEGORY = "Category";
    private static final String SIDECODE = "Sidecode";

    public RandomDutchLicensePlate() {
        super("RandomDutchLicensePlate");
        wikiMatcher(new Matcher().string("!randomDutchLicensePlate"));
        wikiRule(this);
        htmlTranslation(this);
    }

    public Maybe<Symbol> parse(Symbol current, Parser parser) {
        Maybe<Symbol> result = storeParenthesisContent(current, parser, CATEGORY);
        if (!result.isNothing()) {
            result = storeParenthesisContent(current, parser, SIDECODE);
        }
        return result;
    }

    public String toTarget(Translator translator, Symbol symbol) {
        String category = symbol.getProperty(CATEGORY, "");
        String sideCode = symbol.getProperty(SIDECODE, "7");
        return randomLicensePlate(sideCode, category.toUpperCase());
    }

    private String randomLicensePlate(String sideCode, String category) {

        int sideCodeToUse = Integer.parseInt(sideCode);
        if (sideCodeToUse > 14) {
            throw new IllegalArgumentException("Sidecodes > 14 are unsupported!");
        }
        String pattern = sidecodePatterns().get(sideCodeToUse);
        String permitted = "BDFGHJKLMNPRSTVXZ";

        if (category.length() == 1) {
            pattern = pattern.replaceFirst("@", category);
        }
        while (pattern.contains("@")) {
            pattern = pattern.replaceFirst("@", RANDOM_UTIL.randomString(permitted, 1));
        }
        while (pattern.contains("#")) {
            pattern = pattern.replaceFirst("#", RANDOM_UTIL.randomString("1234567890", 1));
        }
        return pattern;

    }

    private Map<Integer, String> sidecodePatterns() {
        Map<Integer, String> patterns = new HashMap<>();

        patterns.put(1, "@@-##-##"); //SideCode 1
        patterns.put(2, "##-##-XX"); //SideCode 2
        patterns.put(3, "##-@@-##"); //SideCode 3
        patterns.put(4, "@@-##-@@"); //SideCode 4
        patterns.put(5, "@@-@@-##"); //SideCode 5
        patterns.put(6, "##-@@-@@"); //SideCode 6
        patterns.put(7, "##-@@@-#"); //SideCode 7
        patterns.put(8, "#-@@@-##");  //SideCode 8
        patterns.put(9, "@@-###-@");  //SideCode 9
        patterns.put(10, "@-###-@@"); //SideCode 10
        patterns.put(11, "@@@-##-@"); //SideCode 11
        patterns.put(12, "@-##-@@@");  //SideCode 12
        patterns.put(13, "#-@@-###");  //SideCode 13
        patterns.put(14, "###-@@-#"); //SideCode 14
        return patterns;
    }

}
