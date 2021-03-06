package w16cs350.controller.cli.parser.patterns.behavioral;

import w16cs350.controller.cli.parser.EmptyCommand;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.cli.parser.patterns.behavioral.brake.BrakePatternMatcher;
import w16cs350.controller.cli.parser.patterns.behavioral.select.SelectPatternMatcher;
import w16cs350.controller.cli.parser.patterns.behavioral.set.SetPatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Utility methods to recognize and hand off the "DO" commands
 *
 * @author Josh Cotes
 * @version 1.1
 */
public class DoPatternMatcher extends A_SubPatternMatcher {

    /**
     * Constructor initializes the pattern matcher using the parent class
     *
     * @param parent - The parent class
     */
    public DoPatternMatcher(A_PatternMatcher parent) {
        super(parent, "DO");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        return peekNextToken("matching tokens").equals("DO");
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new BrakePatternMatcher(this));
        getPatternMatchers().add(new SelectPatternMatcher(this));
        getPatternMatchers().add(new SetPatternMatcher(this));

    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        nextToken("confirming next token exists");
        return new EmptyCommand();
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
