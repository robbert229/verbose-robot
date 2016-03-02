package w16cs350.controller.cli.parser.patterns.behavioral.do_.select;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectRoundhouse;

import static org.junit.Assert.assertTrue;

/**
 * Tester for Drawbridge pattern matcher
 */
public class RoundhousePatternMatcher_TEST {

    @Test
    public void test_PatternMatch() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SELECT ROUNDHOUSE idTest POSITION 212 CLOCKWISE");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralSelectRoundhouse);
    }

    @Test
    public void test_PatternMatch2() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SELECT ROUNDHOUSE idTest POSITION 212 COUNTERCLOCKWISE");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralSelectRoundhouse);
    }

    @Test(expected = Exception.class)
    public void testException() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SELECT ROUNDHOUSE idTest POSITION 212 nay");
        A_Command command = commandParser.parseCommand();
    }

    @Test(expected = Exception.class)
    public void testException2() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SELECT ROUNDHOUSE idTest POSITION 900 COUNTERCLOCKWISE");
        A_Command command = commandParser.parseCommand();
    }


}

