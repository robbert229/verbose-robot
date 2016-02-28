package w16cs350.controller.cli.parser.patterns.behavioral.do_.set;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSetSpeed;

import static org.junit.Assert.assertTrue;

/**
 * Tester for Speed pattern matcher
 */
public class SpeedPatternMatcher_TEST {

    @Test
    public void test_PatternMatch() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SET boblablaw SPEED 55");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralSetSpeed);
    }

    @Test(expected = Exception.class)
    public void testException() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SET boo SPEED One");
        A_Command command = commandParser.parseCommand();
    }

}