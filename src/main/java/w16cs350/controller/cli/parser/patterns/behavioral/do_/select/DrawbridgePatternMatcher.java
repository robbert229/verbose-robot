package w16cs350.controller.cli.parser.patterns.behavioral.do_.select;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectBridge;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to match and handle "DRAWBRIDGE" commands
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class DrawbridgePatternMatcher extends A_IteratingPatternMatcher {

    private static String errorString = "user input error \"DRAWBRIDGE\" pattern matcher";
    private S_SelectMatcherTools helper = S_SelectMatcherTools.getInstance();

    /**
     * Constructor builds from the parent class
     *
     * @param parent - The parent class
     */
    public DrawbridgePatternMatcher(A_PatternMatcher parent) {
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
        return token.equals("DRAWBRIDGE");
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasNext(), errorString);
        String drawbridge_ID = tokens.next();
        Assert.isID(drawbridge_ID, errorString);
        String position = helper.getPosition(tokens, errorString);
        return new CommandBehavioralSelectBridge(drawbridge_ID, position.equals("UP"));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}