package w16cs350.controller.cli.parser.patterns.behavioral.do_.set;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSetDirection;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to recognize and hand off the "id DIRECTION" commands
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class DirectionPatternMatcher extends A_IteratingPatternMatcher {
    private static String errorString = "user input error \"DIRECTION\" pattern matcher";

    /**
     * Constructor builds from the parent class
     *
     * @param parent - The parent class
     */
    public DirectionPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasNext(), errorString);
        tokens.next();
        Assert.isTrue(tokens.hasNext(), errorString);
        String token = tokens.next();
        tokens.previous();
        tokens.previous();
        return token.equals("DIRECTION");
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasPrevious(), errorString);
        String reference_id = tokens.previous();
        Assert.isID(reference_id, errorString);
        Assert.isTrue(tokens.hasNext(), errorString);
        tokens.next();
        Assert.isTrue(tokens.hasNext(), errorString);
        Assert.isTrue(tokens.next().equals("DIRECTION"), errorString);
        Assert.isTrue(tokens.hasNext(), errorString);
        String direction = tokens.next();
        Assert.isTrue(direction.equals("FORWARD") ||
                direction.equals("BACKWARD"), errorString);

        return new CommandBehavioralSetDirection(reference_id, direction.equals("FORWARD"));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
