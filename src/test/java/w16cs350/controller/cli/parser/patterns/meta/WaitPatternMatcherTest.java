package w16cs350.controller.cli.parser.patterns.meta;

import org.junit.Test;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaDoWait;
import w16cs350.controller.timing.Time;
import w16cs350.controller.cli.parser.CommandParser;

import static org.junit.Assert.*;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class WaitPatternMatcherTest {
    @Test
    public void test(){
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "@WAIT 10");
        A_Command c = p.parseCommand();
        assert(c instanceof CommandMetaDoWait);
        CommandMetaDoWait command = (CommandMetaDoWait)c;
        assertTrue("Time does not equal 10", command.getDeltaTime().equals(new Time(10)));
    }

}