package w16cs350.controller.cli.parser.patterns.meta;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaViewSync;

import static org.junit.Assert.*;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class SyncViewCommandTest {

    @Test
    public void test() throws Exception {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "SYNC VIEW VIEWID NORTH ON STOCKID");
        A_Command c = p.parseCommand();
        assertTrue(c instanceof CommandMetaViewSync);
        CommandMetaViewSync command = (CommandMetaViewSync)c;
        assertEquals("STOCKID", command.getIDStock());
        assertEquals("VIEWID", command.getID());
        assertTrue("Track is not NORTH", command.isNorthElseTrack());
    }

    @Test
    public void test2() throws Exception {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "SYNC VIEW VIEWID TRACK ON STOCKID");
        A_Command c = p.parseCommand();
        assertTrue(c instanceof CommandMetaViewSync);
        CommandMetaViewSync command = (CommandMetaViewSync)c;
        assertEquals("STOCKID", command.getIDStock());
        assertEquals("VIEWID", command.getID());
        assertFalse("Track is NORTH", command.isNorthElseTrack());
    }

}