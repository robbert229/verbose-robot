package w16cs350.controller.cli.parser.patterns.behavioral.brake;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralBrake;

import java.util.ListIterator;

/**
 * Utility methods to match and handle "BRAKE" pattern commands
 *
 * @author Josh Cotes
 * @version 1.1
 */
public class BrakePatternMatcher extends A_SubPatternMatcher {

    /**
     * Constructor initializes the pattern matcher using the parent class
     *
     * @param parent - The parent class
     */
    public BrakePatternMatcher(A_PatternMatcher parent) {
        super(parent, "BRAKE");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        return peekNextToken("matching token").equals("BRAKE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        String engine_id = getLastToken("engine id string");
        return new CommandBehavioralBrake(engine_id);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
