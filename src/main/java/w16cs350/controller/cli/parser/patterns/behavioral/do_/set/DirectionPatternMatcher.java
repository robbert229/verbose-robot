package w16cs350.controller.cli.parser.patterns.behavioral.do_.set;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSetDirection;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to recognize and hand off the "id DIRECTION" commands
 *
 * @author Josh Cotes
 * @version 1.1
 */
public class DirectionPatternMatcher extends A_SubPatternMatcher {

    /**
     * Constructor initializes the pattern matcher using the parent class
     *
     * @param parent - The parent class
     */
    public DirectionPatternMatcher(A_PatternMatcher parent) {
        super(parent, "DIRECTION");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        nextToken("advance token");
        return peekNextToken("matching token").equals("DIRECTION");
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        previousToken("previous token");
        String reference_id = getPreviousToken("reference idea (previous token)");
        nextTokenIs("DIRECTION", "DIRECTION command");
        String direction = getNextToken("direction");
        Assert.isTrue(direction.equals("FORWARD") ||
                direction.equals("BACKWARD"), buildError("expecting FORWARD or BACKWARD"));

        return new CommandBehavioralSetDirection(reference_id, direction.equals("FORWARD"));
    }
}
