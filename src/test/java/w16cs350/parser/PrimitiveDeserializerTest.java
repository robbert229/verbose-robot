package w16cs350.parser;

import org.junit.Assert;
import org.junit.Test;
import w16cs350.datatype.*;

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
    public void testParseLatitudeFail() throws Exception {
        try {
            PrimitiveDeserializer.parseLatitude(Parser.getIteratorFromString("FOO"));
            Assert.fail("Failed to throw exception");
        } catch(RuntimeException e) { }
    }

    @Test
    public void testParseLongitude() throws Exception {
        Longitude target = new Longitude(2,4,8);
        Longitude attempt = PrimitiveDeserializer.parseLongitude(Parser.getIteratorFromString("2*4'8\""));
        Assert.assertEquals(target, attempt);
    }

    @Test
    public void testParseLongitudeFail() throws Exception {
        try {
            PrimitiveDeserializer.parseLatitude(Parser.getIteratorFromString("Foo"));
            Assert.fail("Failed to throw exception");
        } catch (RuntimeException e) { }
    }

    @Test
    public void testParseCoordinatesWorld() throws Exception {
        CoordinatesWorld target = new CoordinatesWorld(new Latitude(1,2,4), new Longitude(3,5,7));
        CoordinatesWorld attempt = PrimitiveDeserializer.parseCoordinatesWorld(Parser.getIteratorFromString("1*2'4\" / 3*5'7\""));
        double delta = .1;
        double distance = target.calculateDistanceMeters(attempt);
        Assert.assertTrue("Delta: " + delta + ", is greater than Distance: " + distance, delta > distance);
    }

    @Test
    public void testParseAngle() throws Exception {
        Angle target = new Angle(120);
        Angle attempt = PrimitiveDeserializer.parseAngle(Parser.getIteratorFromString("120"));
        Assert.assertEquals("Target != Attempt", target.getValue(), attempt.getValue(), 0.001);
    }

    @Test
    public void testParseCoordinatesDelta() throws Exception {
        CoordinatesDelta target = new CoordinatesDelta(102.39,390.01);
        CoordinatesDelta attempt = PrimitiveDeserializer.parseCoordinatesDelta(Parser.getIteratorFromString("102.39 : 390.01"));
        double delta = 0.001;
        double distance = target.calculateDistance(attempt);
        Assert.assertTrue("delta: " + delta + ", is greater than distance: " + distance, distance < delta);

    }
}