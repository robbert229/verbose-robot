package w16cs350.controller.cli.parser.patterns.behavioral.do_.set;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSetSpeed;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to recognize and handle "SPEED" commands
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class SpeedPatternMatcher extends A_IteratingPatternMatcher {
    private static String errorString = "user input error \"SPEED\" pattern matcher";

    /**
     * Constructor builds from the parent class
     *
     * @param parent - The parent class
     */
    public SpeedPatternMatcher(A_PatternMatcher parent) {
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
        return token.equals("SPEED");
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasPrevious(), errorString);
        String reference_id = tokens.previous();
        Assert.isID(reference_id, errorString);
        Assert.isTrue(tokens.hasNext(), errorString);
        tokens.next();
        Assert.isTrue(tokens.hasNext(), errorString);
        Assert.isTrue(tokens.next().equals("SPEED"), errorString);
        Assert.isTrue(tokens.hasNext(), errorString);
        String speed_token = tokens.next();
        if (!isDouble(speed_token))
            throw new RuntimeException(errorString);
        double speed = Double.parseDouble(speed_token);

        return new CommandBehavioralSetSpeed(reference_id, speed);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }

    /**
     * Simple helper to check if string is a double
     *
     * @param test_string - The string to check
     * @return - true | false
     */
    boolean isDouble(String test_string) {
        try {
            Double d = Double.parseDouble(test_string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
