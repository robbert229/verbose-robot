package w16cs350.parser;

import org.junit.Assert;
import org.junit.Test;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.datatype.Latitude;
import w16cs350.datatype.Longitude;

/**
 * Created by johnrowleyster on 2/24/16.
 */
public class PrimitiveDeserializerTest {

    @Test
    public void testParseLatitude() throws Exception {
        Latitude target = new Latitude(2,4,8);
        Latitude attempt = PrimitiveDeserializer.parseLatitude(Parser.getIteratorFromString("2*4'8\""));
        Assert.assertEquals(target, attempt);
    }

    @Test
    public void testParseLongitude() throws Exception {
        Longitude target = new Longitude(2,4,8);
        Longitude attempt = PrimitiveDeserializer.parseLongitude(Parser.getIteratorFromString("2*4'8\""));
        Assert.assertEquals(target, attempt);
    }

    @Test
    public void testParseWorldCoordinates() throws Exception {
        CoordinatesWorld target = new CoordinatesWorld(new Latitude(1,2,4), new Longitude(3,5,7));
        CoordinatesWorld attempt = PrimitiveDeserializer.parseWorldCoordinates(Parser.getIteratorFromString("1*2'4\" / 3*5'7\""));
        double delta = .1;
        double distance = target.calculateDistanceMeters(attempt);
        Assert.assertTrue("Delta: " + delta + ", is greater than Distance: " + distance, delta > distance);
    }
}