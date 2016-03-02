package w16cs350.controller.cli.parser.patterns.meta;

import org.junit.Assert;
import org.junit.Test;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.datatype.Latitude;
import w16cs350.datatype.Longitude;
import w16cs350.controller.cli.parser.CommandParser;

/**
 * Created by RowleyJohn on 2/24/2016.
 */
public class UsePatternMatcherTest {
    @Test
    public void test(){
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "USE HOME_COORDINATES AS REFERENCE 1*10'20\" / 2*20'40\"");
        A_Command c = p.parseCommand();
        CoordinatesWorld target = new CoordinatesWorld(new Latitude(1,10,20), new Longitude(2,20,40));
        CoordinatesWorld attempt = p.getHelper().getReference("HOME_COORDINATES");

        double delta = .1;
        double distance = target.calculateDistanceMeters(attempt);
        Assert.assertTrue("Delta: " + delta + ", is greater than Distance: " + distance, delta > distance);
    }
}