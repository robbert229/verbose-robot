package w16cs350.controller.cli.parser.behavioral;

import w16cs350.controller.cli.parser.A_ParserHelper;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralBrake;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility to recognize a token as a BRAKE command
 */
public class BrakePatternMatcher extends A_IteratingPatternMatcher {

    public BrakePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        String token = tokens.next();
        tokens.previous();
        return token.equals("BRAKE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {

        CommandParser root = (CommandParser) getRoot();
        A_ParserHelper action_queue = root.getHelper();
        CommandBehavioralBrake new_brakeCommand;

        Assert.isTrue(tokens.hasNext(), "user input error - BRAKE pattern matcher");
        String engine_id = tokens.next();
        Assert.isFalse(tokens.hasNext(), "user input too long - BRAKE pattern matcher");
        return new CommandBehavioralBrake(engine_id);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
