package w16cs350.controller.cli.parser.patterns.structural;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.structural.CommandStructuralUncouple;

import static org.junit.Assert.assertTrue;

/**
 * Created by michael on 3/7/16.
 */
public class UncouplePatternMatcherTest {
    @Test
    public void uncouplePatternMatcherTest(){
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "UNCOUPLE STOCK stock1 AND stock2");
        A_Command c = p.parseCommand();
        assertTrue("Uncouple test fail", c instanceof CommandStructuralUncouple);
        CommandStructuralUncouple csu = (CommandStructuralUncouple) c;
        assertTrue("Uncouple id1 test fail", csu.getIDStock1().equals("stock1"));
        assertTrue("Uncouple id2 test fail", csu.getIDStock2().equals("stock2"));
    }
}
