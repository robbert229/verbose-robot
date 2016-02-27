package w16cs350.controller.cli.parser.patterns.behavioral.do_.select;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectBridge;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to match and handle "DRAWBRIDGE" commands
 *
 * @author Josh Cotes
 * @version 1.1
 */
public class DrawbridgePatternMatcher extends A_SubPatternMatcher {

    /**
     * Constructor initializes the pattern matcher using the parent class
     *
     * @param parent - The parent class
     */
    public DrawbridgePatternMatcher(A_PatternMatcher parent) {
        super(parent, "DRAWBRIDGE");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        return peekNextToken("matching token").equals("DRAWBRIDGE");
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        String drawbridge_id = getNextToken("drawbridge id");
        nextTokenIs("POSITION", "POSITION command");
        String position = getLastToken("position id");
        Assert.isTrue(position.equals("UP") || position.equals("DOWN"), buildError("parseCommand", "wrong format"));
        return new CommandBehavioralSelectBridge(drawbridge_id, position.equals("UP"));
    }
}