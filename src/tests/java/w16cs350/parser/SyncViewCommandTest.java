package w16cs350.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.A_CommandMetaView;
import w16cs350.controller.command.meta.CommandMetaViewSync;

import static org.junit.Assert.*;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class SyncViewCommandTest {

    @Test
    public void test() throws Exception {
        Parser p = new Parser();
        A_Command c = p.parse("SYNC VIEW VIEWID NORTH ON STOCKID");
        assertTrue(c instanceof CommandMetaViewSync);
        CommandMetaViewSync command = (CommandMetaViewSync)c;
        assertEquals("STOCKID", command.getIDStock());
        assertEquals("VIEWID", command.getID());
        assertTrue("Track is not NORTH", command.isNorthElseTrack());
    }

    @Test
    public void test2() throws Exception {
        Parser p = new Parser();
        A_Command c = p.parse("SYNC VIEW VIEWID TRACK ON STOCKID");
        assertTrue(c instanceof CommandMetaViewSync);
        CommandMetaViewSync command = (CommandMetaViewSync)c;
        assertEquals("STOCKID", command.getIDStock());
        assertEquals("VIEWID", command.getID());
        assertFalse("Track is NORTH", command.isNorthElseTrack());
    }

}