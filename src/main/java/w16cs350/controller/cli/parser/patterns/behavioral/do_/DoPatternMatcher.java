package w16cs350.controller.cli.parser.patterns.behavioral.do_;

import w16cs350.controller.cli.parser.EmptyCommand;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.brake.BrakePatternMatcher;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.select.SelectPatternMatcher;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.set.SetPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to recognize and hand off the "DO" commands
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class DoPatternMatcher extends A_IteratingPatternMatcher {

    /**
     * Constructor builds from the parent class
     *
     * @param parent - The parent class
     */
    public DoPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        String token = tokens.next();
        tokens.previous();
        return token.equals("DO");
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new BrakePatternMatcher(this));
        getPatternMatchers().add(new SelectPatternMatcher(this));
        getPatternMatchers().add(new SetPatternMatcher(this));

    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasNext(), "user input error - DO pattern matcher");
        return new EmptyCommand();
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
