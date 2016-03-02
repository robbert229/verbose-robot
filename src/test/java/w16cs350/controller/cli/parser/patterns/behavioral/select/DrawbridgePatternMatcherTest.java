package w16cs350.controller.cli.parser.patterns.behavioral.select;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectBridge;

import static org.junit.Assert.assertTrue;

/**
 * Tester for Drawbridge pattern matcher
 */
public class DrawbridgePatternMatcherTest {

    @Test
    public void test_PatternMatch() throws Exception {

        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SELECT DRAWBRIDGE testID POSITION DOWN");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralSelectBridge);
    }

    @Test
    public void test_PatternMatch2() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SELECT DRAWBRIDGE testID POSITION UP");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralSelectBridge);
    }

    @Test(expected = Exception.class)
    public void testException() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SELECT DRAWBRIDGE testID POSITION derp");
        A_Command command = commandParser.parseCommand();
    }
}
