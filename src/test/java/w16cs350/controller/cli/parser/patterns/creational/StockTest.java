package w16cs350.controller.cli.parser.patterns.creational;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.*;
import w16cs350.support.Assert;

/**
 * Created by michael on 2/26/16.
 */
public class StockTest {
    @Test
    public void testStockCarBox() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS BOX");
        A_Command c = p.parseCommand();
        Assert.isTrue(c instanceof CommandCreateStockCarBox, "StockCarBox test fail");
        CommandCreateStockCarBox cmd = (CommandCreateStockCarBox) c;
        Assert.isTrue(cmd.getID().equals("car1"), "StockCarBox test fail");
    }

    @Test
    public void testStockCarCaboose() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS CABOOSE");
        A_Command c = p.parseCommand();
        Assert.isTrue(c instanceof CommandCreateStockCarCaboose, "StockCarCaboose test fail");
        CommandCreateStockCarCaboose cmd = (CommandCreateStockCarCaboose) c;
        Assert.isTrue(cmd.getID().equals("car1"), "StockCarCaboose test fail");
    }

    @Test
    public void testStockCarFlatbed() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS FLATBED");
        A_Command c = p.parseCommand();
        Assert.isTrue(c instanceof CommandCreateStockCarFlatbed, "StockCarFlatbed test fail");
        CommandCreateStockCarFlatbed cmd = (CommandCreateStockCarFlatbed) c;
        Assert.isTrue(cmd.getID().equals("car1"), "StockCarFlatbed test fail");
    }

    @Test
    public void testStockCarPassenger() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS PASSENGER");
        A_Command c = p.parseCommand();
        Assert.isTrue(c instanceof CommandCreateStockCarPassenger, "StockCarPassenger test fail");
        CommandCreateStockCarPassenger cmd = (CommandCreateStockCarPassenger) c;
        Assert.isTrue(cmd.getID().equals("car1"), "StockCarPassenger test fail");
    }

    @Test
    public void testStockCarTank() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS TANK");
        A_Command c = p.parseCommand();
        Assert.isTrue(c instanceof CommandCreateStockCarTank, "StockCarTank test fail");
        CommandCreateStockCarTank cmd = (CommandCreateStockCarTank) c;
        Assert.isTrue(cmd.getID().equals("car1"), "StockCarTank test fail");
    }

    @Test
    public void testStockCarTender() throws Exception{
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "CREATE STOCK CAR car1 AS TENDER");
        A_Command c = p.parseCommand();
        Assert.isTrue(c instanceof CommandCreateStockCarTender, "StockCarTender test fail");
        CommandCreateStockCarTender cmd = (CommandCreateStockCarTender) c;
        Assert.isTrue(cmd.getID().equals("car1"), "StockCarTender test fail");
    }
}
