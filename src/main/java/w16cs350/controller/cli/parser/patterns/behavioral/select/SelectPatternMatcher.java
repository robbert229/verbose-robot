package w16cs350.controller.cli.parser.patterns.behavioral.select;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Utility methods to recognize and hand off the "SELECT" commands
 *
 * @author Josh Cotes
 * @version 1.1
 */
public class SelectPatternMatcher extends A_SubPatternMatcher {

    /**
     * Constructor initializes the pattern matcher using the parent class
     *
     * @param parent - The parent class
     */
    public SelectPatternMatcher(A_PatternMatcher parent) {
        super(parent, "SELECT");
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new DrawbridgePatternMatcher(this));
        getPatternMatchers().add(new RoundhousePatternMatcher(this));
        getPatternMatchers().add(new SwitchPatternMatcher(this));
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        return peekNextToken("matching token").equals("SELECT");
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
