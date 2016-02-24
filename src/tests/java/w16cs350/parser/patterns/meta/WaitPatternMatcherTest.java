package w16cs350.parser.patterns.meta;

import org.junit.Test;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaDoWait;
import w16cs350.controller.timing.Time;
import w16cs350.parser.Parser;

import static org.junit.Assert.*;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class WaitPatternMatcherTest {
    @Test
    public void test(){
        Parser p = new Parser();
        A_Command c = p.parse("@WAIT 10");
        assert(c instanceof CommandMetaDoWait);
        CommandMetaDoWait command = (CommandMetaDoWait)c;
        assertTrue("Time does not equal 10", command.getDeltaTime().equals(new Time(10)));
    }

}