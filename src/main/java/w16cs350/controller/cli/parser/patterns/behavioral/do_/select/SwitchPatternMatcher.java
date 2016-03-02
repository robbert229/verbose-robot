package w16cs350.controller.cli.parser.patterns.behavioral.do_.select;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectSwitch;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to recognize and handle the SWITCH command
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class SwitchPatternMatcher extends A_IteratingPatternMatcher {
    private static String errorString = "user input error \"SWITCH\" pattern matcher";
    private S_SelectMatcherTools helper = S_SelectMatcherTools.getInstance();

    /**
     * Constructor builds from the parent class
     *
     * @param parent - The parent class
     */
    public SwitchPatternMatcher(A_PatternMatcher parent) {
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
        return token.equals("SWITCH");
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasNext(), errorString);
        String switch_ID = tokens.next();
        Assert.isID(switch_ID, errorString);
        Assert.isTrue(tokens.hasNext(), errorString);
        Assert.isTrue(tokens.next().equals("PATH"), errorString);
        Assert.isTrue(tokens.hasNext(), errorString);
        String path = tokens.next();
        Assert.isTrue(path.equals("PRIMARY") ||
                path.equals("SECONDARY"), errorString);

        return new CommandBehavioralSelectSwitch(switch_ID, path.equals("PRIMARY"));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
