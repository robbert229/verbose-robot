package w16cs350.controller.cli.parser.patterns.behavioral.select;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectSwitch;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to recognize and handle the SWITCH command
 *
 * @author Josh Cotes
 * @version 1.1
 */
public class SwitchPatternMatcher extends A_SubPatternMatcher {

    /**
     * Constructor initializes the pattern matcher using the parent class
     *
     * @param parent - The parent class
     */
    public SwitchPatternMatcher(A_PatternMatcher parent) {
        super(parent, "SWITCH");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        return peekNextToken("matching token").equals("SWITCH");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        String switch_ID = getNextToken("switch id");
        nextTokenIs("PATH", "PATH token");
        String path = getNextToken("path value");
        Assert.isTrue(path.equals("PRIMARY") ||
                path.equals("SECONDARY"), buildError("parseCommand", "expected PRIMARY or SECONDARY"));
        return new CommandBehavioralSelectSwitch(switch_ID, path.equals("PRIMARY"));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
