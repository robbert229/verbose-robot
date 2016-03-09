package w16cs350.datatypes;

import org.junit.Test;
import w16cs350.datatype.*;
import static org.junit.Assert.*;

/**
 * Test methods junit for ShapeArc.java methods
 *
 * @author Josh Cotes
 */
public class ShapeArcTest {

    final CoordinatesWorld KSFF = new CoordinatesWorld(new Latitude(47, 40, 58), new Longitude(117, 19, 21));
    ShapeArc arc1;

    @Test
    public void createShapeArc() {
        arc1 = new ShapeArc(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400), new CoordinatesDelta(100, 400));
    }

    @Test
    public void testGetAngleEnd() throws Exception {
        arc1 = new ShapeArc(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400), new CoordinatesDelta(100, 400));
        assertEquals("arc getAngleEnd", 90.0, arc1.getAngleEnd().getValue(), .001);
    }

    @Test
    public void testGetAngleStart() throws Exception {
        arc1 = new ShapeArc(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400), new CoordinatesDelta(100, 400));
        assertEquals("arc getAngleStart", 180.0, arc1.getAngleStart().getValue(), .001);
    }

    @Test
    public void testGetDeltaOrigin() throws Exception {
        arc1 = new ShapeArc(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400), new CoordinatesDelta(100, 400));
        assertTrue("arc getDeltaOrigin", CDEquals(new CoordinatesDelta(100, 400), arc1.getDeltaOrigin(), .001));
    }

    @Test
    public void testGetLength() throws Exception {
        arc1 = new ShapeArc(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400), new CoordinatesDelta(100, 400));
        assertEquals("arc getLength", 942.4777960769379, arc1.getLength(), .001);
    }

    @Test
    public void testInterpolateDelta() throws Exception {
        arc1 = new ShapeArc(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400), new CoordinatesDelta(100, 400));
        assertTrue("arc interpolateDelta", CDEquals(new CoordinatesDelta(100.0, 200.0), arc1.interpolateDelta(0, true), .001));
        assertTrue("arc interpolateDelta", CDEquals(new CoordinatesDelta(-12.928494679007073, 234.93287701806435), arc1.interpolateDelta(120, true), .001));
        assertTrue("arc interpolateDelta", CDEquals(new CoordinatesDelta(299.9994292775436, 400.47779562245626), arc1.interpolateDelta(942, true), .001));
        assertTrue("arc interpolateDelta", CDEquals(new CoordinatesDelta(300.0, 400.0), arc1.interpolateDelta(0, false), .001));
        assertTrue("arc interpolateDelta", CDEquals(new CoordinatesDelta(265.06712298193565, 512.928494679007), arc1.interpolateDelta(120, false), .001));
        assertTrue("arc interpolateDelta", CDEquals(new CoordinatesDelta(99.52220437754379, 200.00057072245642), arc1.interpolateDelta(942, false), .001));
    }

    @Test
    public void testInterpolateWorld() throws Exception {
        arc1 = new ShapeArc(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400), new CoordinatesDelta(100, 400));
        assertEquals("arc interpolateWorld", 4741.074658027357, arc1.interpolateWorld(0, true).getLatitude().convertToNMEA(), .001);
        assertEquals("arc interpolateWorld", 4741.0935202719675, arc1.interpolateWorld(120, true).getLatitude().convertToNMEA(), .001);
        assertEquals("arc interpolateWorld", 4741.182907377046, arc1.interpolateWorld(942, true).getLatitude().convertToNMEA(), .001);
        assertEquals("arc interpolateWorld", 4741.182649388049, arc1.interpolateWorld(0, false).getLatitude().convertToNMEA(), .001);
        assertEquals("arc interpolateWorld", 4741.243625897055, arc1.interpolateWorld(120, false).getLatitude().convertToNMEA(), .001);
        assertEquals("arc interpolateWorld", 4741.074658335523, arc1.interpolateWorld(942, false).getLatitude().convertToNMEA(), .001);
    }

    @Test
    public void testIsOnPath() throws Exception {
        arc1 = new ShapeArc(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400), new CoordinatesDelta(100, 400));
        assertTrue("arc isOnPath", (arc1.isOnPath(0)));
        assertTrue("arc isOnPath", (arc1.isOnPath(100)));
        assertTrue("arc isOnPath", (arc1.isOnPath(942)));
        assertFalse("arc isOnPath", (arc1.isOnPath(943)));
    }

    private boolean CDEquals(CoordinatesDelta a, CoordinatesDelta b, double range) {
        return (a.getX() - b.getX() < range || b.getX() - a.getX() < range) &&
                (a.getY() - b.getY() < range || b.getY() - a.getY() < range);
    }
}