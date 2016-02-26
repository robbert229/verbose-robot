package w16cs350.controller.cli.parser.patterns.behavioral.do_.select;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectRoundhouse;
import w16cs350.datatype.Angle;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to match and handle "ROUNDHOUSE" commands
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class RoundhousePatternMatcher extends A_IteratingPatternMatcher {

    private static String errorString = "user input error \"ROUNDHOUSE\" pattern matcher";
    S_SelectMatcherTools SELECT_tools = S_SelectMatcherTools.getInstance();

    /**
     * Constructor builds from the parent class
     *
     * @param parent - The parent class
     */
    public RoundhousePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        String token = tokens.next();
        tokens.previous();
        return token.equals("ROUNDHOUSE");
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasNext(), errorString);
        String roundhouse_ID = tokens.next();

        Assert.isID(roundhouse_ID, errorString);
        Angle rotationAngle = SELECT_tools.extractAngle(tokens, errorString);

        Assert.isTrue(tokens.hasNext(), errorString);
        String rotateDirection = tokens.next();

        Assert.isTrue(rotateDirection.equals("CLOCKWISE") || rotateDirection.equals("COUNTERCLOCKWISE"), errorString);

        return new CommandBehavioralSelectRoundhouse(roundhouse_ID, rotationAngle, rotateDirection.equals("CLOCKWISE"));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
