package w16cs350.controller.cli.parser.patterns.meta;

import org.junit.Test;
import w16cs350.controller.cli.parser.A_ParserHelper;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.MyParserHelper;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaViewGenerate;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.datatype.Latitude;
import w16cs350.datatype.Longitude;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by RowleyJohn on 2/25/2016.
 */
public class OpenViewPatternMatcherTest {
    @Test
    public void test(){
        MyParserHelper helper = ParserFactory.buildHelper();
        CommandParser parser = new CommandParser(helper, "OPEN VIEW MAIN ORIGIN 1*2'4\" / 10*20'40\" WORLD WIDTH 100 SCREEN WIDTH 640 HEIGHT 480");
        A_Command c = parser.parseCommand();
        assert(c instanceof CommandMetaViewGenerate);
        CommandMetaViewGenerate command = (CommandMetaViewGenerate)c;
        assertEquals(command.getScreenSize().getX(), 640);
        assertEquals(command.getScreenSize().getY(), 480);
        assertTrue(command.getOrigin().calculateDistanceMeters(
            new CoordinatesWorld(new Latitude(1,2,4), new Longitude(10,20,40))) < 0.0001);
        assertEquals(command.getID(), "MAIN");
        assertEquals(command.getWorldWidth(), 100);
    }

    @Test
    public void test2(){
        MyParserHelper helper = ParserFactory.buildHelper();
        CommandParser parserSetReference = new CommandParser(helper, "USE origin AS REFERENCE 1*2'4\" / 10*20'40\"");
        parserSetReference.parse();

        CommandParser parser = new CommandParser(helper, "OPEN VIEW MAIN ORIGIN origin WORLD WIDTH 100 SCREEN WIDTH 640 HEIGHT 480");
        A_Command c = parser.parseCommand();
        assert(c instanceof CommandMetaViewGenerate);
        CommandMetaViewGenerate command = (CommandMetaViewGenerate)c;
        assertEquals(command.getScreenSize().getX(), 640);
        assertEquals(command.getScreenSize().getY(), 480);
        assertTrue(command.getOrigin().calculateDistanceMeters(
                new CoordinatesWorld(new Latitude(1,2,4), new Longitude(10,20,40))) < 0.0001);
        assertEquals(command.getID(), "MAIN");
        assertEquals(command.getWorldWidth(), 100);

    }
}