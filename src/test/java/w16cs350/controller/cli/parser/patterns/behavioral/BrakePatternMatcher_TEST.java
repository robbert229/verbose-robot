package w16cs350.controller.cli.parser.patterns.behavioral;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralBrake;

import static org.junit.Assert.assertTrue;

public class BrakePatternMatcher_TEST {

    @Test
    public void test_PatternMatch() {
        CommandParser commandParser = new CommandParser(ParserFactory.buildHelper(), "BRAKE locomotiveOne");
        A_Command command = commandParser.parseCommand();
        assertTrue(command instanceof CommandBehavioralBrake);
    }
}
