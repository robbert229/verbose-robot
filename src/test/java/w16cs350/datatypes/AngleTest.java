package w16cs350.datatypes;

import org.junit.Test;
import w16cs350.datatype.Angle;
import static org.junit.Assert.assertEquals;

/**
 * Test methods junit for Angle.java methods
 *
 * @author Josh Cotes
 */
public class AngleTest {

    Angle a_neg5;

    @Test(expected = Exception.class)
    public void testAngleOutOfBoundsException() {
        System.out.println("test new Angle(-5): ");
        a_neg5 = new Angle(-5);

    }

    @Test(expected = Exception.class)
    public void testAngleOutOfBoundsException2() {
        System.out.println("test new Angle(365): ");
        a_neg5 = new Angle(365);
    }

    @Test(expected = Exception.class)
    public void testAngleAddNull() {
        System.out.println("test new Angle.add(null): ");
        Angle.ANGLE_000.add(null);
    }

    @Test(expected = Exception.class)
    public void testAngleSubtractNull() {
        System.out.println("test new Angle.subtract(null): ");
        Angle.ANGLE_000.subtract(null);
    }

    @Test
    public void testAngleAdd() throws Exception {
        System.out.println("test Angle.add");
        assertEquals("add 0+0", 0, Angle.ANGLE_000.add(Angle.ANGLE_000).getValue(), .001);
        assertEquals("add 45+90", 135, Angle.ANGLE_045.add(Angle.ANGLE_090).getValue(), .001);
        assertEquals("add 180+225", 45, Angle.ANGLE_180.add(Angle.ANGLE_225).getValue(), .001);
        assertEquals("add 180+180", 0, Angle.ANGLE_180.add(Angle.ANGLE_180).getValue(), .001);
    }

    @Test
    public void testAngleGetValue() throws Exception {
        System.out.println("test Constant Angle Values  / getValue()");

        assertEquals(Angle.ANGLE_000.getValue(), 0, .001);
        assertEquals(Angle.ANGLE_045.getValue(), 45, .001);
        assertEquals(Angle.ANGLE_090.getValue(), 90, .001);
        assertEquals(Angle.ANGLE_135.getValue(), 135, .001);
        assertEquals(Angle.ANGLE_180.getValue(), 180, .001);
        assertEquals(Angle.ANGLE_225.getValue(), 225, .001);
        assertEquals(Angle.ANGLE_270.getValue(), 270, .001);
        assertEquals(Angle.ANGLE_315.getValue(), 315, .001);
    }

    @Test
    public void testAngleNormalize() throws Exception {
        System.out.println("test Angle Normalize");
        assertEquals("normalize 45", 45, Angle.normalize(45), .001);
        assertEquals("normalize -45", 315, Angle.normalize(-45), .001);
        assertEquals("normalize 370", 10, Angle.normalize(370), .001);
        assertEquals("normalize 720", 0, Angle.normalize(720), .001);
        assertEquals("normalize 1450", 10, Angle.normalize(1450), .001);
    }

    @Test
    public void testAngleReciprocate() throws Exception {
        assertEquals("reciprocate 45", 225, new Angle(45).reciprocate().getValue(), .001);
        assertEquals("reciprocate 315", 135, new Angle(315).reciprocate().getValue(), .001);
        assertEquals("reciprocate 0", 180, new Angle(0).reciprocate().getValue(), .001);
        assertEquals("reciprocate 180", 0, new Angle(180).reciprocate().getValue(), .001);
    }

    @Test
    public void testAngleSubtract() throws Exception {
        assertEquals("subtract 0-0", 0, Angle.ANGLE_000.subtract(Angle.ANGLE_000).getValue(), .001);
        assertEquals("subtract 45-90", 315, Angle.ANGLE_045.subtract(Angle.ANGLE_090).getValue(), .001);
        assertEquals("subtract 90-45", 45, Angle.ANGLE_090.subtract(Angle.ANGLE_045).getValue(), .001);
        assertEquals("subtract 180-225", 315, Angle.ANGLE_180.subtract(Angle.ANGLE_225).getValue(), .001);
        assertEquals("subtract 180-180", 0, Angle.ANGLE_180.subtract(Angle.ANGLE_180).getValue(), .001);
    }
}