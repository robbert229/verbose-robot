package w16cs350.controller.cli.parser.patterns.meta;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaViewDestroy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class CloseViewPatternMatcherTest {

    @Test
    public void test() throws Exception {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CLOSE VIEW VIEWID");
        A_Command c = p.parseCommand();
        assertTrue(c instanceof CommandMetaViewDestroy);
        CommandMetaViewDestroy command = (CommandMetaViewDestroy)c;
        assertEquals("VIEWID", command.getID());
    }

}