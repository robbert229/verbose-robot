package w16cs350.parser;

/**
 * Created by johnrowleyster on 2/23/16.
 */

public class Parser extends A_PatternMatcher {

    @Override
    public void initializeMatchers() {

    }

    @Override
    public void operate(String[] tokens) {

    }

    /**
     * Parses a string, and executes the related command.
     * @param  string the string to be parsed.
     */
    public void operate(String string){
        operate(string.split(" "));
    }
}
