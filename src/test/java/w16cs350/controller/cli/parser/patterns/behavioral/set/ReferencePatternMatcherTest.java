package w16cs350.controller.cli.parser.patterns.behavioral.set;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSetReference;

import static org.junit.Assert.assertTrue;

/**
 * Tester for Reference pattern matcher
 */
public class ReferencePatternMatcherTest {

    @Test
    public void test_PatternMatch() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SET REFERENCE ENGINE butt");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralSetReference);
    }

    @Test(expected = Exception.class)
    public void testException() throws Exception {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "DO SET REFERENCE ENGINE");
        A_Command command = commandParser.parseCommand();

    }

}