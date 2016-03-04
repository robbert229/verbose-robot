package w16cs350.controller.cli.parser.patterns.creational;

import org.junit.Test;
import w16cs350.controller.cli.TrackLocator;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreatePowerCatenary;
import w16cs350.controller.command.creational.CommandCreatePowerPole;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by michael on 2/26/16.
 */
public class PowerTest {
    @Test
    public void PowerCatenaryTest() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE POWER CATENARY catenary1 WITH POLES pole1 pole2");
        A_Command c = p.parseCommand();
        assertTrue("PowerCatenary test fail", c instanceof CommandCreatePowerCatenary);
        CommandCreatePowerCatenary cmd = (CommandCreatePowerCatenary) c;
        assertTrue("PowerCatenary test fail", cmd.getID().equals("catenary1"));
        List<String> ids = cmd.getPoleIDs();
        assertTrue("PowerCatenary pole ids test fail", ids.get(0).equals("pole1") && ids.get(1).equals("pole2"));
    }

    @Test
    public void PowerPoleTest() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE POWER POLE pole1 ON TRACK track1 DISTANCE 100 FROM START");
        A_Command c = p.parseCommand();
        assertTrue("PowerPole test fail", c instanceof CommandCreatePowerPole);
        CommandCreatePowerPole cmd = (CommandCreatePowerPole) c;
        assertTrue("PowerPole test fail", cmd.getID().equals("pole1"));
        TrackLocator tl = cmd.getLocator();
        assertTrue("PowerPole track id test fail", tl.getTrackID().equals("track1"));
        assertTrue("PowerPole track distance test fail", tl.getDistance() == 100);
        assertTrue("PowerPole track fromAElseB test fail", tl.isFromAElseB());
    }
}
