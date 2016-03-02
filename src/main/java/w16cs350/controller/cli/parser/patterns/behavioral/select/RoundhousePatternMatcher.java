package w16cs350.controller.cli.parser.patterns.behavioral.select;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectRoundhouse;
import w16cs350.datatype.Angle;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to match and handle "ROUNDHOUSE" commands
 *
 * @author Josh Cotes
 * @version 1.1
 */
public class RoundhousePatternMatcher extends A_SubPatternMatcher {

    /**
     * Constructor builds from the parent class
     *
     * @param parent - The parent class
     */
    public RoundhousePatternMatcher(A_PatternMatcher parent) {
        super(parent, "ROUNDHOUSE");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        return peekNextToken("matching token").equals("ROUNDHOUSE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        String roundhouse_ID = getNextToken("roundhouse ID");
        nextTokenIs("POSITION", "position angle");
        Angle rotationAngle = new Angle(toDouble(getNextToken("angle number convert from string")));
        String rotateDirection = getNextToken("rotateDirection");
        Assert.isTrue(rotateDirection.equals("CLOCKWISE") || rotateDirection.equals("COUNTERCLOCKWISE"), buildError("parseCommand"));
        return new CommandBehavioralSelectRoundhouse(roundhouse_ID, rotationAngle, rotateDirection.equals("CLOCKWISE"));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
