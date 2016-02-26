package w16cs350.controller.cli.parser.patterns.behavioral.do_.brake;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralBrake;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to match and handle "BRAKE" pattern commands
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class BrakePatternMatcher extends A_IteratingPatternMatcher {

    /**
     * Constructor builds from the parent class
     *
     * @param parent - The parent class
     */
    public BrakePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        String token = tokens.next();
        tokens.previous();
        return token.equals("BRAKE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasNext(), "user input error - BRAKE pattern matcher");
        String engine_id = tokens.next();
        Assert.isFalse(tokens.hasNext(), "user input too long - BRAKE pattern matcher");
        return new CommandBehavioralBrake(engine_id);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
