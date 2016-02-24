package w16cs350.parser.patterns.meta;

import org.junit.Assert;
import org.junit.Test;
import w16cs350.controller.command.A_Command;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.datatype.Latitude;
import w16cs350.datatype.Longitude;
import w16cs350.parser.Parser;

/**
 * Created by RowleyJohn on 2/24/2016.
 */
public class UsePatternMatcherTest {
    @Test
    public void test(){
        Parser p = new Parser();
        A_Command c = p.parse("USE HOME_COORDINATES AS 1*10'20\" / 2*20'40\"");
        CoordinatesWorld target = new CoordinatesWorld(new Latitude(1,10,20), new Longitude(2,20,40));
        CoordinatesWorld attempt = p.getVariableStore().get("HOME_COORDINATES");

        double delta = .1;
        double distance = target.calculateDistanceMeters(attempt);
        Assert.assertTrue("Delta: " + delta + ", is greater than Distance: " + distance, delta > distance);
    }
}