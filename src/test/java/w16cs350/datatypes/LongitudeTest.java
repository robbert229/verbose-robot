package w16cs350.datatypes;

import org.junit.Test;
import w16cs350.datatype.Longitude;
import static org.junit.Assert.assertEquals;

/**
 * Test methods junit for Longitude.java methods
 *
 * @author Josh Cotes
 */
public class LongitudeTest {

    Longitude lon1;
    Longitude lon2;

    @Test
    public void buildLongitude() {
        lon2 = new Longitude(1, 2, 3);
    }

    @Test
    public void testconvertToNMEA() {
        lon1 = new Longitude(47, 40, 58);
        lon2 = new Longitude(1, 2, 3);
        assertEquals("test Latitude.convertToNMEA", 4740.966666666666, lon1.convertToNMEA(), .001);
        assertEquals("test Latitude.convertToNMEA", 102.05, lon2.convertToNMEA(), .001);
    }

    @Test
    public void testAdd() throws Exception {
        lon1 = new Longitude(47, 40, 58);
        lon2 = new Longitude(1, 2, 3);
        assertEquals("test Latitude.add", 4843.016666666666, lon1.add(lon2).convertToNMEA(), .001);
    }

    @Test(expected = Exception.class)
    public void addError() throws Exception {
        lon1 = new Longitude(47, 40, 58);
        lon2 = new Longitude(1, 2, 3);
        assertEquals("test Latitude.add", 4843.016666666666, lon2.add(lon1).convertToNMEA(), .001);
        assertEquals("test Latitude.subtract", 4638.916666666666, lon2.subtract(lon1).convertToNMEA(), .001);
    }

    @Test(expected = Exception.class)
    public void subtractError() throws Exception {
        lon1 = new Longitude(47, 40, 58);
        lon2 = new Longitude(1, 2, 3);
        assertEquals("test Latitude.subtract", 4638.916666666666, lon2.subtract(lon1).convertToNMEA(), .001);
    }

    @Test
    public void testSubtract() throws Exception {
        lon1 = new Longitude(47, 40, 58);
        lon2 = new Longitude(1, 2, 3);
        assertEquals("test Latitude.subtract", 4638.916666666666, lon1.subtract(lon2).convertToNMEA(), .001);
    }
}