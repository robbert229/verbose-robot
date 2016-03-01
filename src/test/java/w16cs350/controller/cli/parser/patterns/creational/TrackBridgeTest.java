package w16cs350.controller.cli.parser.patterns.creational;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.PointLocator;
import w16cs350.controller.command.creational.CommandCreateTrackBridgeDraw;
import w16cs350.controller.command.creational.CommandCreateTrackBridgeFixed;
import w16cs350.support.Assert;

/**
 * Created by michael on 2/28/16.
 */
public class TrackBridgeTest {
    @Test
    public void drawBridgeTest() throws Exception {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE TRACK BRIDGE DRAW bridge1 REFERENCE 10*20'30\" / 2*50'10\" DELTA START 320 : 420 END 100 : 200 ANGLE 7\n");
        A_Command c = p.parseCommand();
        Assert.isTrue(c instanceof CommandCreateTrackBridgeDraw, "DrawBridge test fail");
        CommandCreateTrackBridgeDraw cmd = (CommandCreateTrackBridgeDraw) c;
        Assert.isTrue(cmd.getID().equals("bridge1"), "DrawBridge id test fail");
        Assert.isTrue(cmd.getAngle().getValue() == 7, "DrawBridge angle test fail");
        PointLocator ps = cmd.getLocator();
        //System.out.println(ps.getReference().getPrettyForm());
        //System.out.println(ps.getDeltaStart().getX() + ":" + ps.getDeltaStart().getY());
        //System.out.println(ps.getDeltaEnd().getX() + ":" + ps.getDeltaEnd().getY());
    }

    @Test
    public void fixedBridgeTest() throws Exception {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE TRACK BRIDGE bridge2 REFERENCE 55*44'33\" / 22*11'00\" DELTA START 123 : 456 END 789 : 987\n");
        A_Command c = p.parseCommand();
        Assert.isTrue(c instanceof CommandCreateTrackBridgeFixed, "FixedBridge test fail");
        CommandCreateTrackBridgeFixed cmd = (CommandCreateTrackBridgeFixed) c;
        Assert.isTrue(cmd.getID().equals("bridge2"), "FixedBridge id test fail");
        PointLocator ps = cmd.getLocator();
        //System.out.println(ps.getReference().getPrettyForm());
        //System.out.println(ps.getDeltaStart().getX() + ":" + ps.getDeltaStart().getY());
        //System.out.println(ps.getDeltaEnd().getX() + ":" + ps.getDeltaEnd().getY());
    }
}
