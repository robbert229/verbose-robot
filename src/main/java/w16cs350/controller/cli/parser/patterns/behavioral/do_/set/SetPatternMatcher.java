package w16cs350.controller.cli.parser.patterns.behavioral.do_.set;

import w16cs350.controller.cli.parser.EmptyCommand;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to recognize and hand off the "SET" commands
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class SetPatternMatcher extends A_IteratingPatternMatcher {

    /**
     * Constructor builds from the parent class
     *
     * @param parent - The parent class
     */
    public SetPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new DirectionPatternMatcher(this));
        getPatternMatchers().add(new ReferencePatternMatcher(this));
        getPatternMatchers().add(new SpeedPatternMatcher(this));
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        String token = tokens.next();
        tokens.previous();
        return token.equals("SET");
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasNext(), "user input error \"SET\" pattern matcher");
        return new EmptyCommand();
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
