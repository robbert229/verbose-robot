package w16cs350.controller.cli.parser.patterns.meta;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaDoExit;
import w16cs350.controller.command.meta.CommandMetaDoRun;

import static org.junit.Assert.*;

/**
 * Created by RowleyJohn on 2/24/2016.
 */
public class RunPatternMatcherTest {
    @Test
    public void test(){
        CommandParser parser = new CommandParser(ParserFactory.buildHelper(), "@RUN FOOBAR");
        A_Command c = parser.parseCommand();
        assertTrue(c instanceof CommandMetaDoRun);
        CommandMetaDoRun command = (CommandMetaDoRun)c;
        assertTrue("command.getFilename() != FOOBAR : " + command.getFilename(), command.getFilename().equals("FOOBAR"));
    }
}