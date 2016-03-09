package w16cs350.datatypes;

import org.junit.Test;
import w16cs350.datatype.Angle;
import w16cs350.datatype.CoordinatesDelta;
import static org.junit.Assert.assertEquals;

/**
 * Test methods junit standard for CoordinatesDelta.java methods
 *
 * @author Josh Cotes
 */
public class CoordinatesDeltaTest {

    @Test
    public void testAdd() throws Exception {
        assertEquals("add (1,2)+(3,4)", new CoordinatesDelta(4, 6).getX(), new CoordinatesDelta(1, 2).add(new CoordinatesDelta(3, 4)).getX(), .001);
        assertEquals("add (1,2)+(3,4)", new CoordinatesDelta(4, 6).getY(), new CoordinatesDelta(1, 2).add(new CoordinatesDelta(3, 4)).getY(), .001);
        assertEquals("add (-1,-2)+(3,5)", new CoordinatesDelta(2, 3).getX(), new CoordinatesDelta(-1, -2).add(new CoordinatesDelta(3, 5)).getX(), .001);
        assertEquals("add (-1,-2)+(3,5)", new CoordinatesDelta(2, 3).getY(), new CoordinatesDelta(-1, -2).add(new CoordinatesDelta(3, 5)).getY(), .001);
        assertEquals("add (-1,-2)+(-3,-5)", new CoordinatesDelta(-4, -7).getX(), new CoordinatesDelta(-1, -2).add(new CoordinatesDelta(-3, -5)).getX(), .001);
        assertEquals("add (-1,-2)+(-3,-5)", new CoordinatesDelta(-4, -7).getY(), new CoordinatesDelta(-1, -2).add(new CoordinatesDelta(-3, -5)).getY(), .001);
    }

    @Test
    public void testCalculateBearing() throws Exception {
        assertEquals("bearing (10,20)&(30,40)", 45, new CoordinatesDelta(10, 20).calculateBearing(new CoordinatesDelta(30, 40)).getValue(), .001);
        assertEquals("bearing (30,40)&(10,20)", 225, new CoordinatesDelta(30, 40).calculateBearing(new CoordinatesDelta(10, 20)).getValue(), .001);
        assertEquals("bearing (-30,40)&(-10,20)", 135, new CoordinatesDelta(-30, 40).calculateBearing(new CoordinatesDelta(-10, 20)).getValue(), .001);
    }

    @Test
    public void testCalculateDistance() throws Exception {
        System.out.println("test CoordinatesDelta CalculateDistance");
        assertEquals("distance (10,20)&(30,40)", 28.284271247461902, new CoordinatesDelta(10, 20).calculateDistance(new CoordinatesDelta(30, 40)), .001);
        assertEquals("distance (30,40)&(10,20)", 28.284271247461902, new CoordinatesDelta(30, 40).calculateDistance(new CoordinatesDelta(10, 20)), .001);
        assertEquals("distance (-30,40)&(-10,20)", 28.284271247461902, new CoordinatesDelta(-30, 40).calculateDistance(new CoordinatesDelta(-10, 20)), .001);
    }

    @Test
    public void testCalculateTarget() throws Exception {
        double distance = 28.284271247461902;
        assertEquals("target (10,20)@45,28.284271247461902", new CoordinatesDelta(30, 40).getX(), new CoordinatesDelta(10, 20).calculateTarget(Angle.ANGLE_045, distance).getX(), .001);
        assertEquals("target (10,20)@45,28.284271247461902", new CoordinatesDelta(30, 40).getY(), new CoordinatesDelta(10, 20).calculateTarget(Angle.ANGLE_045, distance).getY(), .001);

        assertEquals("target (30,40)@225,28.284271247461902", new CoordinatesDelta(10, 20).getX(), new CoordinatesDelta(30, 40).calculateTarget(Angle.ANGLE_225, distance).getX(), .001);
        assertEquals("target (30,40)@225,28.284271247461902", new CoordinatesDelta(10, 20).getY(), new CoordinatesDelta(30, 40).calculateTarget(Angle.ANGLE_225, distance).getY(), .001);

        assertEquals("target (-30,40)@135,28.284271247461902", new CoordinatesDelta(-10, 20).getX(), new CoordinatesDelta(-30, 40).calculateTarget(Angle.ANGLE_135, distance).getX(), .001);
        assertEquals("target (-30,40)@135,28.284271247461902", new CoordinatesDelta(-10, 20).getY(), new CoordinatesDelta(-30, 40).calculateTarget(Angle.ANGLE_135, distance).getY(), .001);

    }

    @Test(expected = Exception.class)
    public void testError1() {
        new CoordinatesDelta(0, 0).add(null);
    }

    @Test(expected = Exception.class)
    public void testError2() {
        new CoordinatesDelta(0, 0).subtract(null);
    }

    @Test(expected = Exception.class)
    public void testError3() {
        new CoordinatesDelta(0, 0).calculateTarget(null, 1);
    }

    @Test(expected = Exception.class)
    public void testError4() {
        new CoordinatesDelta(0, 0).calculateTarget(Angle.ANGLE_000, -1);
    }

    @Test(expected = Exception.class)
    public void testError5() {
        new CoordinatesDelta(0, 0).calculateDistance(null);
    }

    @Test(expected = Exception.class)
    public void testError6() {
        new CoordinatesDelta(0, 0).calculateBearing(null);
    }

    @Test
    public void testSubtract() throws Exception {
        assertEquals("subtract (1,5)-(3,4)", new CoordinatesDelta(-2, 1).getX(), new CoordinatesDelta(1, 5).subtract(new CoordinatesDelta(3, 4)).getX(), .001);
        assertEquals("subtract (1,5)-(3,4)", new CoordinatesDelta(-2, 1).getY(), new CoordinatesDelta(1, 5).subtract(new CoordinatesDelta(3, 4)).getY(), .001);
        assertEquals("subtract (-1,-2)-(3,5)", new CoordinatesDelta(-4, -7).getX(), new CoordinatesDelta(-1, -2).subtract(new CoordinatesDelta(3, 5)).getX(), .001);
        assertEquals("subtract (-1,-2)-(3,5)", new CoordinatesDelta(-4, -7).getY(), new CoordinatesDelta(-1, -2).subtract(new CoordinatesDelta(3, 5)).getY(), .001);
        assertEquals("subtract (-1,-2)-(-3,-5)", new CoordinatesDelta(2, 3).getX(), new CoordinatesDelta(-1, -2).subtract(new CoordinatesDelta(-3, -5)).getX(), .001);
        assertEquals("subtract (-1,-2)-(-3,-5)", new CoordinatesDelta(2, 3).getY(), new CoordinatesDelta(-1, -2).subtract(new CoordinatesDelta(-3, -5)).getY(), .001);

    }
}