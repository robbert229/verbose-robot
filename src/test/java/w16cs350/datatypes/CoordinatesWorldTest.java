package w16cs350.datatypes;

import org.junit.Test;
import w16cs350.datatype.*;
import static org.junit.Assert.assertEquals;

/**
 * Test methods junit standard for CoordinatesWorld.java methods
 *
 * @author Josh Cotes
 */
public class CoordinatesWorldTest {


    final CoordinatesWorld KSFF = new CoordinatesWorld(new Latitude(47, 40, 58), new Longitude(117, 19, 21));
    final CoordinatesWorld DELTA = CoordinatesWorld.build(1, 2, 3, 4, 5, 6);
    final CoordinatesWorld KGEG = new CoordinatesWorld(new Latitude(47, 37, 8), new Longitude(117, 32, 14));
    CoordinatesWorld cw1;
    CoordinatesWorld cw2;

    @Test
    public void testBuild() throws Exception {
        cw1 = new CoordinatesWorld(new Latitude(75, 0, 0), new Longitude(75, 0, 0));
        cw2 = new CoordinatesWorld(new Latitude(0, 0, 0), new Longitude(0, 0, 0));
    }

    @Test
    public void testConvertMetersToNauticalMiles() throws Exception {
        assertEquals("test CoordinatesWorld.convertMetersToNauticalMiles", 6.665766738660907, CoordinatesWorld.convertMetersToNauticalMiles(12345), .001);
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals("test CoordinatesWorld.addLat", 4843.016666666666, KSFF.add(DELTA).getLatitude().convertToNMEA(), .001);
        assertEquals("test CoordinatesWorld.addLon", 12124.45, KSFF.add(DELTA).getLongitude().convertToNMEA(), .001);
    }

    @Test
    public void testCalculateBearings() throws Exception {

        cw1 = new CoordinatesWorld(new Latitude(75, 0, 0), new Longitude(75, 0, 0));
        cw2 = new CoordinatesWorld(new Latitude(0, 0, 0), new Longitude(0, 0, 0));

        assertEquals(315, cw2.calculateBearing(cw1).getValue(), .0001);
        assertEquals(135, cw1.calculateBearing(cw2).getValue(), .0001);

        cw2 = new CoordinatesWorld(new Latitude(75, 0, 0), new Longitude(0, 0, 0));
        cw1 = new CoordinatesWorld(new Latitude(0, 0, 0), new Longitude(150, 0, 0));
        assertEquals(243.4, cw2.calculateBearing(cw1).getValue(), .1);

        cw2 = new CoordinatesWorld(new Latitude(0, 0, 0), new Longitude(0, 0, 0));
        assertEquals(90, cw1.calculateBearing(cw2).getValue(), .1);
    }

    @Test
    public void testCalculateDistanceMeters() throws Exception {
        assertEquals("test CoordinatesWorld.calculateDistanceMeters", 24893.713110921606, KSFF.calculateDistanceMeters(KGEG), .001);
        assertEquals("test CoordinatesWorld.calculateDistanceMeters", 24893.713110921606, KGEG.calculateDistanceMeters(KSFF), .001);
    }

    @Test
    public void testCalculateDistanceNauticalMiles() throws Exception {
        assertEquals("test CoordinatesWorld.calculateDistanceNauticalMiles", 13.441529757517065, KSFF.calculateDistanceNauticalMiles(KGEG), .001);
        assertEquals("test CoordinatesWorld.calculateDistanceNauticalMiles", 13.441529757517065, KGEG.calculateDistanceNauticalMiles(KSFF), .001);
    }

    @Test
    public void testCalculateTarget() throws Exception {

        assertEquals("test CoordinatesWorld.calculateTargetLat", 4737.133333333333, KSFF.calculateTarget(new Angle(253.43004531030988), 24893.713110921606)
                .getLatitude().convertToNMEA(), .001);
        assertEquals("test CoordinatesWorld.calculateTargetLon", 11732.233333333334, KSFF.calculateTarget(new Angle(253.43004531030988), 24893.713110921606)
                .getLongitude().convertToNMEA(), .001);
        assertEquals("test CoordinatesWorld.calculateTargetLat", 4744.799999999999, KSFF.calculateTarget(new Angle(253.43004531030988), -24893.713110921606)
                .getLatitude().convertToNMEA(), .001);
        assertEquals("test CoordinatesWorld.calculateTargetLon", 11706.466666666667, KSFF.calculateTarget(new Angle(253.43004531030988), -24893.713110921606)
                .getLongitude().convertToNMEA(), .001);
    }

    @Test
    public void testCalculateTarget1() throws Exception {
        assertEquals("test CoordinatesWorld.calculateTargetLat", 4742.046580273578, KSFF.calculateTarget(new CoordinatesDelta(1000, 2000))
                .getLatitude().convertToNMEA(), .001);

        assertEquals("test CoordinatesWorld.calculateTargetLon", 11718.810043196545, KSFF.calculateTarget(new CoordinatesDelta(1000, 2000)).getLongitude()
                .convertToNMEA(), .001);

        assertEquals("test CoordinatesWorld.calculateTargetLat", 4739.8867530597545, KSFF.calculateTarget(new CoordinatesDelta(-1000, -2000)).getLatitude()
                .convertToNMEA(), .001);
        assertEquals("test CoordinatesWorld.calculateTargetLon", 11719.889956803456, KSFF.calculateTarget(new CoordinatesDelta(-1000, -2000)).getLongitude()
                .convertToNMEA(), .001);
    }


    @Test
    public void testSubtract() throws Exception {
        assertEquals("test CoordinatesWorld.subtractLat", 4638.916666666666, KSFF.subtract(DELTA).getLatitude().convertToNMEA(), .001);
        assertEquals("test CoordinatesWorld.subtractLon", 11314.25, KSFF.subtract(DELTA).getLongitude().convertToNMEA(), .001);
    }
}