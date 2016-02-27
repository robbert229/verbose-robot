package w16cs350.controller.cli.parser.patterns.behavioral.do_.set;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;

import java.util.ListIterator;

/**
 * Utility methods to recognize and hand off the "SET" commands
 *
 * @author Josh Cotes
 * @version 1.1
 */
public class SetPatternMatcher extends A_SubPatternMatcher {

    /**
     * Constructor initializes the pattern matcher using the parent class
     *
     * @param parent - The parent class
     */
    public SetPatternMatcher(A_PatternMatcher parent) {
        super(parent, "SET");
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new DirectionPatternMatcher(this));
        getPatternMatchers().add(new ReferencePatternMatcher(this));
        getPatternMatchers().add(new SpeedPatternMatcher(this));
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        return peekNextToken("matching token").equals("SET");
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
