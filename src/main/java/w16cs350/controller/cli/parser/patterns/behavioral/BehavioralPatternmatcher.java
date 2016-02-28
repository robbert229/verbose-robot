package w16cs350.controller.cli.parser.patterns.behavioral;

import w16cs350.controller.cli.parser.patterns.A_NonIteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.DoPatternMatcher;

/**
 * Utility methods to initialize Behavioral pattern
 * recognizing classes
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class BehavioralPatternmatcher extends A_NonIteratingPatternMatcher {

    public BehavioralPatternmatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new DoPatternMatcher(this));
    }
}
