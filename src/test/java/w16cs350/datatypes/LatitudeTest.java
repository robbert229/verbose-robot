package w16cs350.datatypes;

import org.junit.Test;
import w16cs350.datatype.Latitude;
import static org.junit.Assert.assertEquals;

/**
 * Test methods junit for Latitude.java methods
 *
 * @author Josh Cotes
 */
public class LatitudeTest {

    Latitude lat1;
    Latitude lat2;

    @Test
    public void buildLongitude() {
        lat1 = new Latitude(1, 2, 3);
        lat2 = new Latitude(1, 2, 3);
    }

    @Test
    public void testconvertToNMEA() {
        lat1 = new Latitude(1, 2, 3);
        lat2 = new Latitude(1, 2, 3);
        assertEquals("test Latitude.convertToNMEA", 4740.966666666666, lat1.convertToNMEA(), .001);
        assertEquals("test Latitude.convertToNMEA", 102.05, lat2.convertToNMEA(), .001);
    }

    @Test
    public void testAdd() throws Exception {
        lat1 = new Latitude(1, 2, 3);
        lat2 = new Latitude(1, 2, 3);
        assertEquals("test Latitude.add", 4843.016666666666, lat1.add(lat2).convertToNMEA(), .001);
    }

    @Test(expected = Exception.class)
    public void addError() throws Exception {
        lat1 = new Latitude(1, 2, 3);
        lat2 = new Latitude(1, 2, 3);
        assertEquals("test Latitude.add", 4843.016666666666, lat2.add(lat1).convertToNMEA(), .001);
        assertEquals("test Latitude.subtract", 4638.916666666666, lat2.subtract(lat1).convertToNMEA(), .001);
    }

    @Test(expected = Exception.class)
    public void subtractError() throws Exception {
        lat1 = new Latitude(1, 2, 3);
        lat2 = new Latitude(1, 2, 3);
        assertEquals("test Latitude.subtract", 4638.916666666666, lat2.subtract(lat1).convertToNMEA(), .001);
    }

    @Test
    public void testSubtract() throws Exception {
        lat1 = new Latitude(1, 2, 3);
        lat2 = new Latitude(1, 2, 3);
        assertEquals("test Latitude.subtract", 4638.916666666666, lat1.subtract(lat2).convertToNMEA(), .001);
    }
}