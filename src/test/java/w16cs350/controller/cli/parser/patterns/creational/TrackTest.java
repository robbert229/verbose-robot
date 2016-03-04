package w16cs350.controller.cli.parser.patterns.creational;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.PointLocator;
import w16cs350.controller.command.creational.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by michael on 2/28/16.
 */
public class TrackTest {
    @Test
    public void drawBridgeTest() {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE TRACK BRIDGE DRAW bridge1 REFERENCE 10*20'30\" / 2*50'10\" DELTA START 320 : 420 END 100 : 200 ANGLE 7");
        A_Command c = p.parseCommand();
        assertTrue("DrawBridge test fail", c instanceof CommandCreateTrackBridgeDraw);
        CommandCreateTrackBridgeDraw cmd = (CommandCreateTrackBridgeDraw) c;
        assertTrue("DrawBridge id test fail", cmd.getID().equals("bridge1"));
        assertTrue("DrawBridge angle test fail", cmd.getAngle().getValue() == 7);
        PointLocator ps = cmd.getLocator();
        //System.out.println(ps.getReference().getPrettyForm());
        //System.out.println(ps.getDeltaStart().getX() + ":" + ps.getDeltaStart().getY());
        //System.out.println(ps.getDeltaEnd().getX() + ":" + ps.getDeltaEnd().getY());
    }

    @Test
    public void fixedBridgeTest() {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE TRACK BRIDGE bridge2 REFERENCE 55*44'33\" / 22*11'00\" DELTA START 123 : 456 END 789 : 987");
        A_Command c = p.parseCommand();
        assertTrue("FixedBridge test fail", c instanceof CommandCreateTrackBridgeFixed);
        CommandCreateTrackBridgeFixed cmd = (CommandCreateTrackBridgeFixed) c;
        assertTrue("FixedBridge id test fail", cmd.getID().equals("bridge2"));
        PointLocator ps = cmd.getLocator();
        //System.out.println(ps.getReference().getPrettyForm());
        //System.out.println(ps.getDeltaStart().getX() + ":" + ps.getDeltaStart().getY());
        //System.out.println(ps.getDeltaEnd().getX() + ":" + ps.getDeltaEnd().getY());
    }

    @Test
    public void crossingTest() {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE TRACK CROSSING crossing1 REFERENCE 10*20'30\" / 2*50'10\" DELTA START 320 : 420 END 100 : 200");
        A_Command c = p.parseCommand();
        assertTrue("Crossing test fail", c instanceof CommandCreateTrackCrossing);
        CommandCreateTrackCrossing cmd = (CommandCreateTrackCrossing) c;
        assertTrue("Crossing id test fail", cmd.getID().equals("crossing1"));
    }

    @Test
    public void crossoverTest() {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE TRACK CROSSOVER crossover1 REFERENCE 10*20'30\" / 2*50'10\" DELTA START 123 : 456 END 789 : 987 START 654 : 456 END 321 : 123");
        A_Command c = p.parseCommand();
        assertTrue("Crossover test fail", c instanceof CommandCreateTrackCrossover);
        CommandCreateTrackCrossover cmd = (CommandCreateTrackCrossover) c;
        assertTrue("Crossover id test fail", cmd.getID().equals("crossover1"));
    }

    @Test
    public void curveTest() {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE TRACK CURVE curve1 REFERENCE 10*20'30\" / 2*50'10\" DELTA START 123 : 456 END 789 : 987 DISTANCE ORIGIN 30");
        A_Command c = p.parseCommand();
        assertTrue("curve test fail", c instanceof CommandCreateTrackCurve);
        CommandCreateTrackCurve cmd = (CommandCreateTrackCurve) c;
        assertTrue("curve id test fail", cmd.getID().equals("curve1"));
    }

    @Test
    public void endTest() {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE TRACK END end1 REFERENCE 10*20'30\" / 2*50'10\" DELTA START 123 : 456 END 456 : 789");
        A_Command c = p.parseCommand();
        assertTrue("end test fail", c instanceof CommandCreateTrackEnd);
        CommandCreateTrackEnd cmd = (CommandCreateTrackEnd) c;
        assertTrue("end id test fail", cmd.getID().equals("end1"));
    }

    @Test
    public void layoutTest() {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE TRACK LAYOUT layout1 WITH TRACKS track1 track2 track3");
        A_Command c = p.parseCommand();
        assertTrue("layout test fail", c instanceof CommandCreateTrackLayout);
        CommandCreateTrackLayout cmd = (CommandCreateTrackLayout) c;
        assertTrue("layout id test fail", cmd.getID().equals("layout1"));
    }

    @Test
    public void roundhouseTest() {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE TRACK ROUNDHOUSE roundhouse1 REFERENCE 10*20'30\" / 2*50'10\" DELTA ORIGIN 123 : 456 ANGLE ENTRY 90 START 60 END 30 WITH 5 SPURS LENGTH 32 TURNTABLE LENGTH 52");
        A_Command c = p.parseCommand();
        assertTrue("roundhouse test fail", c instanceof CommandCreateTrackRoundhouse);
        CommandCreateTrackRoundhouse cmd = (CommandCreateTrackRoundhouse) c;
        assertTrue("roundhouse id test fail", cmd.getID().equals("roundhouse1"));
    }

    @Test
    public void straightTest() {
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE TRACK STRAIGHT straight1 REFERENCE 10*20'30\" / 2*50'10\" DELTA START 123 : 456 END 456 : 789");
        A_Command c = p.parseCommand();
        assertTrue("straight test fail", c instanceof CommandCreateTrackStraight);
        CommandCreateTrackStraight cmd = (CommandCreateTrackStraight) c;
        assertTrue("straight id test fail", cmd.getID().equals("straight1"));
    }
}