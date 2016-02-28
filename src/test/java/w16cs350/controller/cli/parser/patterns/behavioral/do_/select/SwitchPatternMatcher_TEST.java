package w16cs350.controller.cli.parser.patterns.behavioral.do_.select;


import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectSwitch;

import static org.junit.Assert.assertTrue;

/**
 * Tester for Drawbridge pattern matcher
 */
public class SwitchPatternMatcher_TEST {

    @Test
    public void test_PatternMatch() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SELECT SWITCH testID PATH PRIMARY");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralSelectSwitch);
    }

    @Test
    public void test_PatternMatch2() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SELECT SWITCH testID PATH SECONDARY");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralSelectSwitch);
    }

    @Test(expected = Exception.class)
    public void testException() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SELECT SWITCH testID PATH nOtRiGhT");
        A_Command command = commandParser.parseCommand();

    }
}