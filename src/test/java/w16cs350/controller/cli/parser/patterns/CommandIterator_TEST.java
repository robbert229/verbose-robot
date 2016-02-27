package w16cs350.controller.cli.parser.patterns;

import org.junit.*;
import w16cs350.controller.cli.parser.CommandsIterator;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectBridge;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectRoundhouse;
import w16cs350.controller.command.behavioral.CommandBehavioralSelectSwitch;

import static org.junit.Assert.*;

/**
 * Tester for the command iterator for ";" split rules
 */
public class CommandIterator_TEST {

    @Test
    public void testCommands(){
        CommandsIterator commands = new CommandsIterator("DO SELECT DRAWBRIDGE testID POSITION DOWN ;" +
                "DO SELECT ROUNDHOUSE idTest POSITION 212 CLOCKWISE ;" +
                "DO SELECT SWITCH testID PATH PRIMARY");

        assertEquals(commands.remaining(), 3);
        assertTrue(commands.next() instanceof CommandBehavioralSelectBridge);
        assertTrue(commands.next() instanceof CommandBehavioralSelectRoundhouse);
        assertTrue(commands.next() instanceof CommandBehavioralSelectSwitch);
    }

    @Test
    public void testCommands1(){
        CommandsIterator commands = new CommandsIterator("DO SELECT DRAWBRIDGE testID POSITION DOWN");

        assertEquals(commands.remaining(), 1);
        assertTrue(commands.next() instanceof CommandBehavioralSelectBridge);
    }
    @Test
    public void testCommands2(){
        CommandsIterator commands = new CommandsIterator("DO SELECT DRAWBRIDGE testID POSITION DOWN");
        assertEquals(commands.remaining(), 1);
        assertTrue(commands.next() instanceof CommandBehavioralSelectBridge);
    }

    @Test (expected = Exception.class)
    public void testException(){
        CommandsIterator commands = new CommandsIterator("DO SELECT DRAWBRIDGE testID POSITION DOWN; ");
        assertEquals(commands.remaining(), 1);
        assertTrue(commands.next() instanceof CommandBehavioralSelectBridge);
    }
}