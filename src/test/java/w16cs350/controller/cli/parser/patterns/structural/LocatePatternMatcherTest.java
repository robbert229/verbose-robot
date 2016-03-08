package w16cs350.controller.cli.parser.patterns.structural;

import org.junit.Test;
import w16cs350.controller.cli.TrackLocator;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.structural.CommandStructuralLocate;

import static org.junit.Assert.*;

/**
 * Created by RowleyJohn on 3/4/2016.
 */
public class LocatePatternMatcherTest {
    @Test
    public void testLocatePAtternMatcher(){
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "LOCATE STOCK stock1 ON TRACK track1 DISTANCE 10 FROM START");
        A_Command c = p.parseCommand();
        assertTrue("Locate test fail", c instanceof CommandStructuralLocate);
        CommandStructuralLocate csl = (CommandStructuralLocate) c;
        assertTrue("Locate id test fail", csl.getIDStock().equals("stock1"));
        TrackLocator tl = csl.getLocator();
        assertTrue("Locate track id fail", tl.getTrackID().equals("track1"));
        assertTrue("Locate track distance fail", tl.getDistance() == 10);
        assertTrue("Locate track isFromAElseB fail", tl.isFromAElseB());
    }
}