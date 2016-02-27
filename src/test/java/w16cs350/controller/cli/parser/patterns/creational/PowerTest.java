package w16cs350.controller.cli.parser.patterns.creational;

import org.junit.Test;
import w16cs350.controller.cli.TrackLocator;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreatePowerCatenary;
import w16cs350.controller.command.creational.CommandCreatePowerPole;
import w16cs350.support.Assert;

import java.util.List;

/**
 * Created by michael on 2/26/16.
 */
public class PowerTest {
    @Test
    public void PowerCatenaryTest() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE POWER CATENARY catenary1 WITH POLES pole1 pole2");
        A_Command c = p.parseCommand();
        Assert.isTrue(c instanceof CommandCreatePowerCatenary, "PowerCatenary test fail");
        CommandCreatePowerCatenary cmd = (CommandCreatePowerCatenary) c;
        Assert.isTrue(cmd.getID().equals("catenary1"), "PowerCatenary test fail");
        List<String> ids = cmd.getPoleIDs();
        Assert.isTrue(ids.get(0).equals("pole1") && ids.get(1).equals("pole2"), "PowerCatenary pole ids test fail");
    }

    @Test
    public void PowerPoleTest() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE POWER POLE pole1 ON TRACK track1 DISTANCE 100 FROM START");
        A_Command c = p.parseCommand();
        Assert.isTrue(c instanceof CommandCreatePowerPole, "PowerPole test fail");
        CommandCreatePowerPole cmd = (CommandCreatePowerPole) c;
        Assert.isTrue(cmd.getID().equals("pole1"), "PowerPole test fail");
        TrackLocator tl = cmd.getLocator();
        Assert.isTrue(tl.getTrackID().equals("track1"), "PowerPole track id test fail");
        Assert.isTrue(tl.getDistance() == 100, "PowerPole track distance test fail");
        Assert.isTrue(tl.isFromAElseB(), "PowerPole track fromAElseB test fail");
    }
}
