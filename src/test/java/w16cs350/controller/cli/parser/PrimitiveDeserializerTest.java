package w16cs350.controller.cli.parser;

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
        Latitude attempt = PrimitiveDeserializer.parseLatitude(CommandParser.getIteratorFromString("2*4'8\""));
        Assert.assertEquals(target, attempt);
    }

    @Test
    public void testParseLatitudeFail() throws Exception {
        try {
            PrimitiveDeserializer.parseLatitude(CommandParser.getIteratorFromString("FOO"));
            Assert.fail("Failed to throw exception");
        } catch(RuntimeException e) { }
    }

    @Test
    public void testParseLongitude() throws Exception {
        Longitude target = new Longitude(2,4,8);
        Longitude attempt = PrimitiveDeserializer.parseLongitude(CommandParser.getIteratorFromString("2*4'8\""));
        Assert.assertEquals(target, attempt);
    }

    @Test
    public void testParseLongitudeFail() throws Exception {
        try {
            PrimitiveDeserializer.parseLatitude(CommandParser.getIteratorFromString("Foo"));
            Assert.fail("Failed to throw exception");
        } catch (RuntimeException e) { }
    }

    @Test
    public void testParseCoordinatesWorld() throws Exception {
        CoordinatesWorld target = new CoordinatesWorld(new Latitude(1,2,4), new Longitude(3,5,7));
        CoordinatesWorld attempt = PrimitiveDeserializer.parseCoordinatesWorld(CommandParser.getIteratorFromString("1*2'4\" / 3*5'7\""));
        double delta = .1;
        double distance = target.calculateDistanceMeters(attempt);
        Assert.assertTrue("Delta: " + delta + ", is greater than Distance: " + distance, delta > distance);
    }

    @Test
    public void testParseCoordinatesWorldWhiteSpace() throws Exception {
        CoordinatesWorld target = new CoordinatesWorld(new Latitude(1,2,4), new Longitude(3,5,7));
        CoordinatesWorld attempt = PrimitiveDeserializer.parseCoordinatesWorld(CommandParser.getIteratorFromString("1* 2' 4\" / 3*5'7\""));
        double delta = .1;
        double distance = target.calculateDistanceMeters(attempt);
        Assert.assertTrue("Delta: " + delta + ", is greater than Distance: " + distance, delta > distance);
    }

    @Test
    public void testParseCoordinatesWorldWhiteSpace2() throws Exception {
        CoordinatesWorld target = new CoordinatesWorld(new Latitude(1,2,4), new Longitude(3,5,7));
        CoordinatesWorld attempt = PrimitiveDeserializer.parseCoordinatesWorld(CommandParser.getIteratorFromString("1* 2' 4\" / 3* 5' 7\""));
        double delta = .1;
        double distance = target.calculateDistanceMeters(attempt);
        Assert.assertTrue("Delta: " + delta + ", is greater than Distance: " + distance, delta > distance);
    }

    @Test
    public void testParseCoordinatesWorldWhiteSpace3() throws Exception {
        CoordinatesWorld target = new CoordinatesWorld(new Latitude(1,2,4), new Longitude(3,5,7));
        CoordinatesWorld attempt = PrimitiveDeserializer.parseCoordinatesWorld(CommandParser.getIteratorFromString("1* 2' 4\" / 3* 5' 7\""));
        double delta = .1;
        double distance = target.calculateDistanceMeters(attempt);
        Assert.assertTrue("Delta: " + delta + ", is greater than Distance: " + distance, delta > distance);
    }

    @Test
    public void testParseAngle() throws Exception {
        Angle target = new Angle(120);
        Angle attempt = PrimitiveDeserializer.parseAngle(CommandParser.getIteratorFromString("120"));
        Assert.assertEquals("Target != Attempt", target.getValue(), attempt.getValue(), 0.001);
    }

    @Test
    public void testParseCoordinatesDelta() throws Exception {
        CoordinatesDelta target = new CoordinatesDelta(102.39,390.01);
        CoordinatesDelta attempt = PrimitiveDeserializer.parseCoordinatesDelta(CommandParser.getIteratorFromString("102.39:390.01"));
        double delta = 0.001;
        double distance = target.calculateDistance(attempt);
        Assert.assertTrue("delta: " + delta + ", is greater than distance: " + distance, distance < delta);
    }

    @Test
    public void testParseCoordinatesDeltaWhiteSpace() throws Exception {
        CoordinatesDelta target = new CoordinatesDelta(102.39,390.01);
        CoordinatesDelta attempt = PrimitiveDeserializer.parseCoordinatesDelta(CommandParser.getIteratorFromString("102.39 : 390.01"));
        double delta = 0.001;
        double distance = target.calculateDistance(attempt);
        Assert.assertTrue("delta: " + delta + ", is greater than distance: " + distance, distance < delta);
    }

    @Test
    public void testIsNextLatitudeLongitude() throws Exception {
        String latitude = "10*20'10\"";
        Assert.assertTrue(latitude + " isn't a valid latitude",
                PrimitiveDeserializer.isNextLatitudeLongitude(CommandParser.getIteratorFromString(latitude)));
    }

    @Test
    public void testIsNextLatitudeLongitudeFalse() throws Exception {
        String latitude = "10*20'10\"s";
        Assert.assertFalse(latitude + " isn't a valid latitude",
                PrimitiveDeserializer.isNextLatitudeLongitude(CommandParser.getIteratorFromString(latitude)));
    }

    @Test
    public void testIsNextLatitudeLongitudeWhiteSpace() throws Exception {
        String latitude = "10* 20' 10\"";
        Assert.assertTrue(latitude + " isn't a valid latitude",
                PrimitiveDeserializer.isNextLatitudeLongitude(CommandParser.getIteratorFromString(latitude)));
    }

    @Test
    public void testIsNextLatitudeLongitudeWhiteSpaceFalse() throws Exception {
        String latitude = "10* 20' 10false\"";
        Assert.assertFalse(latitude + " isn't a valid latitude",
                PrimitiveDeserializer.isNextLatitudeLongitude(CommandParser.getIteratorFromString(latitude)));
    }

    @Test
    public void testIsNextCoordinatesWorld() throws Exception {
        String latitude = "10*20'10\"";
        String coordinates = latitude + " / " + latitude;
        Assert.assertTrue(coordinates + " isn't a valid CoordinatesWorld",
                PrimitiveDeserializer.isNextCoordinatesWorld(CommandParser.getIteratorFromString(coordinates)));
    }

    @Test
    public void testIsNextAngle() throws Exception {
        String angle = "234.0";
        Assert.assertTrue(PrimitiveDeserializer.isNextAngle(CommandParser.getIteratorFromString(angle)));
    }

    @Test
    public void testIsNextAngleException() throws Exception {
        Assert.assertFalse(PrimitiveDeserializer.isNextAngle(CommandParser.getIteratorFromString("124.0fo")));

    }
}