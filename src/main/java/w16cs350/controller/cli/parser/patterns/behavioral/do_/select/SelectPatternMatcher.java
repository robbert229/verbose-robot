package w16cs350.controller.cli.parser.patterns.behavioral.do_.select;

import w16cs350.controller.cli.parser.EmptyCommand;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to recognize and hand off the "SELECT" commands
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class SelectPatternMatcher extends A_IteratingPatternMatcher {

    /**
     * Constructor builds from the parent class
     *
     * @param parent - The parent class
     */
    public SelectPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new DrawbridgePatternMatcher(this));
        getPatternMatchers().add(new RoundhousePatternMatcher(this));
        getPatternMatchers().add(new SwitchPatternMatcher(this));
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        String token = tokens.next();
        tokens.previous();
        return token.equals("SELECT");
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasNext(), "user input error \"SELECT\" pattern matcher");
        return new EmptyCommand();
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
