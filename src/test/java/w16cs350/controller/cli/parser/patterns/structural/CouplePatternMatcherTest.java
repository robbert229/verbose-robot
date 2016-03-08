package w16cs350.controller.cli.parser.patterns.structural;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.structural.CommandStructuralCouple;

import static org.junit.Assert.assertTrue;

/**
 * Created by michael on 3/7/16.
 */
public class CouplePatternMatcherTest {
    @Test
    public void couplePatternMatcherTest(){
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "COUPLE STOCK stock1 AND stock2");
        A_Command c = p.parseCommand();
        assertTrue("Couple test fail", c instanceof CommandStructuralCouple);
        CommandStructuralCouple csc = (CommandStructuralCouple) c;
        assertTrue("Couple id1 test fail", csc.getIDStock1().equals("stock1"));
        assertTrue("Couple id2 test fail", csc.getIDStock2().equals("stock2"));
    }
}
