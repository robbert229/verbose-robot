package w16cs350.datatypes;

import org.junit.Test;
import w16cs350.datatype.*;
import static org.junit.Assert.*;

/**
 * Test methods junit for ShapeLine.java methods
 *
 * @author Josh Cotes
 */
public class ShapeLineTest {

    ShapeLine line1;
    final CoordinatesWorld KSFF = new CoordinatesWorld(new Latitude(47, 40, 58), new Longitude(117, 19, 21));

    @Test
    public void testShapeLineConstructor() {
        line1 = new ShapeLine(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400));
    }

    @Test
    public void testGetLength() throws Exception {
        line1 = new ShapeLine(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400));
        assertEquals("line getLength", 282.842712474619, line1.getLength(), .001);
    }

    @Test
    public void testInterpolateDelta() throws Exception {
        line1 = new ShapeLine(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400));
        assertTrue("line interpolateDelta", CDEquals(new CoordinatesDelta(100.0, 200.0), line1.interpolateDelta(0, true), .001));
        assertTrue("line interpolateDelta", CDEquals(new CoordinatesDelta(184.8528137423857, 284.8528137423857), line1.interpolateDelta(120, true), .001));
        assertTrue("line interpolateDelta", CDEquals(new CoordinatesDelta(299.4041122946064, 399.4041122946064), line1.interpolateDelta(282, true), .001));
        assertTrue("line interpolateDelta", CDEquals(new CoordinatesDelta(300.0, 400.0), line1.interpolateDelta(0, false), .001));
        assertTrue("line interpolateDelta", CDEquals(new CoordinatesDelta(215.1471862576143, 315.1471862576143), line1.interpolateDelta(120, false), .001));
        assertTrue("line interpolateDelta", CDEquals(new CoordinatesDelta(100.59588770539361, 200.5958877053936), line1.interpolateDelta(282, false), .001));
    }

    @Test
    public void testIsOnPath() throws Exception {
        line1 = new ShapeLine(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400));
        assertTrue("line isOnPath", (line1.isOnPath(0)));
        assertTrue("line isOnPath", (line1.isOnPath(100)));
        assertTrue("line isOnPath", (line1.isOnPath(282)));
        assertFalse("line isOnPath", (line1.isOnPath(283)));
    }

    private boolean CDEquals(CoordinatesDelta a, CoordinatesDelta b, double range) {
        return (a.getX() - b.getX() < range || b.getX() - a.getX() < range) &&
                (a.getY() - b.getY() < range || b.getY() - a.getY() < range);
    }

}