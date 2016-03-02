package w16cs350.controller.cli.parser.patterns.behavioral.do_.set;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSetDirection;

import static org.junit.Assert.assertTrue;


/**
 * Tester for Brake pattern matcher
 */
public class DirectionPatternMatcher_TEST {

    @Test
    public void test_PatternMatch() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SET testid DIRECTION FORWARD");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralSetDirection);
    }

    @Test
    public void test_PatternMatch2() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SET tesssst DIRECTION BACKWARD");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralSetDirection);
    }

    @Test(expected = Exception.class)
    public void testException() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SET tesssst DIRECTION bword");
        A_Command command = commandParser.parseCommand();
    }

}