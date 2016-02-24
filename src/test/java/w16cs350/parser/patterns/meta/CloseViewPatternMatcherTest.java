package w16cs350.parser.patterns.meta;

import org.junit.Test;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaViewDestroy;
import w16cs350.controller.command.meta.CommandMetaViewSync;
import w16cs350.parser.Parser;

import static org.junit.Assert.*;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class CloseViewPatternMatcherTest {

    @Test
    public void test() throws Exception {
        Parser p = new Parser();
        A_Command c = p.parse("CLOSE VIEW VIEWID");
        assertTrue(c instanceof CommandMetaViewDestroy);
        CommandMetaViewDestroy command = (CommandMetaViewDestroy)c;
        assertEquals("VIEWID", command.getID());
    }

}