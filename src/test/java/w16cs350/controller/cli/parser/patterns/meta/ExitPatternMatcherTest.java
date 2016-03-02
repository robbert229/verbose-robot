package w16cs350.controller.cli.parser.patterns.meta;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaDoExit;

import javax.swing.text.html.parser.Parser;

import static org.junit.Assert.*;

/**
 * Created by RowleyJohn on 2/24/2016.
 */
public class ExitPatternMatcherTest {
    @Test
    public void test(){
        CommandParser parser = new CommandParser(ParserFactory.buildHelper(), "@EXIT");
        A_Command c = parser.parseCommand();
        assertTrue(c instanceof CommandMetaDoExit);
    }

}