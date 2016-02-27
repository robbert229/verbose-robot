package w16cs350.controller.cli.parser.patterns.behavioral.do_.set;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSetSpeed;

import java.util.ListIterator;

/**
 * Utility methods to recognize and handle "SPEED" commands
 *
 * @author Josh Cotes
 * @version 1.1
 */
public class SpeedPatternMatcher extends A_SubPatternMatcher {

    /**
     * Constructor initializes the pattern matcher using the parent class
     *
     * @param parent - The parent class
     */
    public SpeedPatternMatcher(A_PatternMatcher parent) {
        super(parent, "SPEED");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        return peekNextNextToken("matching tokens").equals("SPEED");
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        String reference_id = getPreviousToken("reference id (previous)");
        nextTokenIs("SPEED", "SPEED command");
        double speed = toDouble(getNextToken("speed double"));
        return new CommandBehavioralSetSpeed(reference_id, speed);
    }
}
