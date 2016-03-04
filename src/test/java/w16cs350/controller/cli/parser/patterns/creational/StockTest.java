package w16cs350.controller.cli.parser.patterns.creational;

import org.junit.Test;
import w16cs350.controller.cli.TrackLocator;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by michael on 2/26/16.
 */
public class StockTest {
    @Test
    public void testStockCarBox() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS BOX");
        A_Command c = p.parseCommand();
        assertTrue("StockCarBox test fail", c instanceof CommandCreateStockCarBox);
        CommandCreateStockCarBox cmd = (CommandCreateStockCarBox) c;
        assertTrue("StockCarBox test fail", cmd.getID().equals("car1"));
    }

    @Test
    public void testStockCarCaboose() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS CABOOSE");
        A_Command c = p.parseCommand();
        assertTrue("StockCarCaboose test fail", c instanceof CommandCreateStockCarCaboose);
        CommandCreateStockCarCaboose cmd = (CommandCreateStockCarCaboose) c;
        assertTrue("StockCarCaboose test fail", cmd.getID().equals("car1"));
    }

    @Test
    public void testStockCarFlatbed() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS FLATBED");
        A_Command c = p.parseCommand();
        assertTrue("StockCarFlatbed test fail", c instanceof CommandCreateStockCarFlatbed);
        CommandCreateStockCarFlatbed cmd = (CommandCreateStockCarFlatbed) c;
        assertTrue("StockCarFlatbed test fail", cmd.getID().equals("car1"));
    }

    @Test
    public void testStockCarPassenger() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS PASSENGER");
        A_Command c = p.parseCommand();
        assertTrue("StockCarPassenger test fail", c instanceof CommandCreateStockCarPassenger);
        CommandCreateStockCarPassenger cmd = (CommandCreateStockCarPassenger) c;
        assertTrue("StockCarPassenger test fail", cmd.getID().equals("car1"));
    }

    @Test
    public void testStockCarTank() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS TANK");
        A_Command c = p.parseCommand();
        assertTrue("StockCarTank test fail", c instanceof CommandCreateStockCarTank);
        CommandCreateStockCarTank cmd = (CommandCreateStockCarTank) c;
        assertTrue("StockCarTank test fail", cmd.getID().equals("car1"));
    }

    @Test
    public void testStockCarTender() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS TENDER");
        A_Command c = p.parseCommand();
        assertTrue("StockCarTender test fail", c instanceof CommandCreateStockCarTender);
        CommandCreateStockCarTender cmd = (CommandCreateStockCarTender) c;
        assertTrue("StockCarTender test fail", cmd.getID().equals("car1"));
    }

    @Test
    public void testStockEngineDiesel() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK ENGINE car1 AS DIESEL ON TRACK track1 DISTANCE 100 FROM START FACING START");
        A_Command c = p.parseCommand();
        assertTrue("StockEngineDiesel class type test fail", c instanceof CommandCreateStockEngineDiesel);
        CommandCreateStockEngineDiesel cmd = (CommandCreateStockEngineDiesel) c;
        assertTrue("StockEngineDiesel id test fail", cmd.getID().equals("car1"));
        assertTrue("StockEngineDiesel isFacingStartElseEnd test fail", cmd.isFacingStartElseEnd());
        TrackLocator tl = cmd.getLocator();
        assertTrue("StockEngineDiesel track id test fail", tl.getTrackID().equals("track1"));
        assertTrue("StockEngineDiesel track distance test fail", tl.getDistance() == 100);
        assertTrue("StockEngineDiesel track fromAElseB test fail", tl.isFromAElseB());
    }
}
