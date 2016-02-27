package w16cs350.controller.cli.parser.patterns.behavioral.do_.brake;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralBrake;

import static org.junit.Assert.assertTrue;

/**
 * Tester for Brake pattern matcher
 */
public class BrakePatternMatcher_TEST {

    @Test
    public void test_PatternMatch() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO BRAKE shab");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralBrake);
    }

    @Test(expected = Exception.class)
    public void testException() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO BRAKE");
        A_Command command = commandParser.parseCommand();
    }
}