package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AreaManualTest {
    @Test
    void testSurfaceAreaTrapezium() {
        final double maxValue = Double.MAX_VALUE;

        // keep base1 and base2 nominal; change height
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaTrapezium(10, 10, 0));
        assertEquals(10, Area.surfaceAreaTrapezium(10, 10, 1), 1e-6);
        assertEquals(20, Area.surfaceAreaTrapezium(10, 10, 2), 1e-6);
        assertEquals(100, Area.surfaceAreaTrapezium(10, 10, 10), 1e-6);
        assertEquals(((10+10)*(maxValue-1)/2), Area.surfaceAreaTrapezium(10, 10, maxValue-1), 1e-6);
        assertEquals((((10+10)*maxValue)/2), Area.surfaceAreaTrapezium(10, 10, maxValue), 1e-6);
        assertEquals(((10+10)*(maxValue+1)/2), Area.surfaceAreaTrapezium(10, 10, maxValue+1), 1e-6);


        // keep base1 and height nominal; change base2
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaTrapezium(10, 0, 10));
        assertEquals(55, Area.surfaceAreaTrapezium(10, 1, 10), 1e-6);
        assertEquals(60, Area.surfaceAreaTrapezium(10, 2, 10), 1e-6);
        assertEquals(((10+maxValue-1)*10/2), Area.surfaceAreaTrapezium(10, maxValue-1, 10), 1e-6);
        assertEquals(((10+maxValue)*10/2), Area.surfaceAreaTrapezium(10, maxValue, 10), 1e-6);
        assertEquals(((10+maxValue+1)*10/2), Area.surfaceAreaTrapezium(10, maxValue+1, 10), 1e-6);


        // change base1; keep base2 and height nominal
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaTrapezium(0, 10, 10));
        assertEquals(55, Area.surfaceAreaTrapezium(1, 10, 10), 1e-6);
        assertEquals(60, Area.surfaceAreaTrapezium(2, 10, 10), 1e-6);
        assertEquals(((maxValue-1+10)*10)/2, Area.surfaceAreaTrapezium(maxValue-1, 10, 10), 1e-6);
        assertEquals(((maxValue+10)*10)/2, Area.surfaceAreaTrapezium(maxValue, 10, 10), 1e-6);
        assertEquals(((maxValue+1+10)*10)/2, Area.surfaceAreaTrapezium(maxValue+1, 10, 10), 1e-6);
    }


    @Test
    void testSurfaceAreaParallelogram() {
        final double base = Double.MAX_VALUE;

        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaParallelogram(0, 10));
        assertEquals(10.0, Area.surfaceAreaParallelogram(1, 10), 1e-6);
        assertEquals(20.0, Area.surfaceAreaParallelogram(2, 10), 1e-6);
        assertEquals(100.0, Area.surfaceAreaParallelogram(10, 10), 1e-6);
        assertEquals(((base-1)*10), Area.surfaceAreaParallelogram(base-1, 10), 1e-6);
        assertEquals((base*10), Area.surfaceAreaParallelogram(base, 10), 1e-6);
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaParallelogram(2147483647+1, 10));
    }


    @Test
    void testSurfaceAreaCube() {
        // this cannot be tested because we can't input a double that is larger than a double
        // assertThrows(Exception.class, () -> Area.surfaceAreaCube(0), "Throws an exception because the output is too big");
        assertThrows(Exception.class, () -> Area.surfaceAreaCube(1.7976931348623157E+308), "Throws an exception because the output is too big");
        assertThrows(Exception.class, () -> Area.surfaceAreaCube(1.7976931348623157E+308), "Throws an exception because the output is too big");
        assertThrows(Exception.class, () -> Area.surfaceAreaCube(1.7976931348623157E+308/2), "Throws an exception because the output is too big");
        assertEquals(54.0, Area.surfaceAreaCube(3), 1e-6);
        assertEquals(6.0, Area.surfaceAreaCube(1), 1e-6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCube(0));
        assertEquals("Must be a positive sideLength", exception.getMessage());

    }


    /*
     * Area/surfaceAreaSphere
     * To calculate the hard-coded values, I used the built in calculator in macOS
     */
    @Test
    void testArea01_surfaceAreaSphere_maxPlus() {
        // this cannot be tested because we can't input a double that is larger than a double
        //double sideLength = 0;
        //assertThrows(Exception.class, () -> Area.surfaceAreaSphere(sideLength), "Throws an exception because the output is too big");
    }

    @Test
    void testArea02_surfaceAreaSphere_max() {
        double radius = 1.7976931348623157E+308; // largest double that can be represented
        //System.out.println(Area.surfaceAreaCube(radius));
        assertThrows(Exception.class, () -> Area.surfaceAreaSphere(radius), "Throws an exception because the output is too big");
    }

    @Test
    void testArea03_surfaceAreaSphere_maxMinus() {
        double radius = 1.7976931348623157E+308;
        assertThrows(Exception.class, () -> Area.surfaceAreaSphere(radius), "Throws an exception because the output is too big");
    }

    @Test
    void testArea04_surfaceAreaSphere_nom() {
        double radius = 1.7976931348623157E+308/2;
        //System.out.println(Area.surfaceAreaCube(radius));
        assertThrows(Exception.class, () -> Area.surfaceAreaSphere(radius), "Throws an exception because the output is too big");
    }

    @Test
    void testArea05_surfaceAreaSphere_minPlus() {
        double radius = 3;
        assertEquals(113.09733553, Area.surfaceAreaSphere(radius), 1e-6);
    }

    @Test
    void testArea06_surfaceAreaSphere_min() {
        double radius = 1;
        assertEquals(12.56637061, Area.surfaceAreaSphere(radius), 1e-6);
    }

    @Test
    void testArea07_surfaceAreaSphere_minMinus() {
        double radius = -9;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaSphere(radius));
        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaSphere(0));
        assertEquals("Must be a positive radius", exception.getMessage());
    }

    /*
     * Area/area of a square
     *
     */
    @Test
    void testArea01_areaOfASquare_maxPlus() {
        // this cannot be tested because we can't input a double that is larger than a double
        //double sideLength = 0;
        //assertThrows(Exception.class, () -> Area.surfaceAreaSquare(sideLength), "Throws an exception because the output is too big");
    }

    @Test
    void testArea02_areaOfASquare_max() {
        double sideLength = 1.7976931348623157E+308; // largest double that can be represented
        //System.out.println(Area.surfaceAreaCube(sideLength));
        assertThrows(Exception.class, () -> Area.surfaceAreaSquare(sideLength), "Throws an exception because the output is too big");
    }

    @Test
    void testArea03_areaOfASquare_maxMinus() {
        double sideLength = 1.7976931348623157E+308;
        assertThrows(Exception.class, () -> Area.surfaceAreaSquare(sideLength), "Throws an exception because the output is too big");
    }

    @Test
    void testArea04_areaOfASquare_nom() {
        double sideLength = 1.7976931348623157E+308/2;
        //System.out.println(Area.surfaceAreaCube(sideLength));
        assertThrows(Exception.class, () -> Area.surfaceAreaSquare(sideLength), "Throws an exception because the output is too big");
    }

    @Test
    void testArea05_areaOfASquare_minPlus() {
        double sideLength = 3;
        assertEquals(9.0, Area.surfaceAreaSquare(sideLength), 1e-6);
    }

    @Test
    void testArea06_areaOfASquare_min() {
        double sideLength = 1;
        assertEquals(1.0, Area.surfaceAreaSquare(sideLength), 1e-6);
    }

    @Test
    void testArea07_areaOfASquare_minMinus() {
        double sideLength = -9;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaSquare(sideLength));
        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaSquare(0));
        assertEquals("Must be a positive sideLength", exception.getMessage());
    }

    /*
     * Area/surfaceAreaCircle
     * To calculate the hard-coded values, I used the built in calculator in macOS
     */
    @Test
    void testArea01_surfaceAreaCircle_maxPlus() {
        // this cannot be tested because we can't input a double that is larger than a double
        //double sideLength = 0;
        //assertThrows(Exception.class, () -> Area.surfaceAreaCircle(sideLength), "Throws an exception because the output is too big");
    }

    @Test
    void testArea02_surfaceAreaCircle_max() {
        double radius = 1.7976931348623157E+308; // largest double that can be represented
        //System.out.println(Area.surfaceAreaCube(radius));
        assertThrows(Exception.class, () -> Area.surfaceAreaCircle(radius), "Throws an exception because the output is too big");
    }

    @Test
    void testArea03_surfaceAreaCircle_maxMinus() {
        double radius = 1.7976931348623157E+308;
        assertThrows(Exception.class, () -> Area.surfaceAreaCircle(radius), "Throws an exception because the output is too big");
    }

    @Test
    void testArea04_surfaceAreaCircle_nom() {
        double radius = 1.7976931348623157E+308/2;
        //System.out.println(Area.surfaceAreaCube(radius));
        assertThrows(Exception.class, () -> Area.surfaceAreaCircle(radius), "Throws an exception because the output is too big");
    }

    @Test
    void testArea05_surfaceAreaCircle_minPlus() {
        double radius = 3;
        assertEquals(28.27433388, Area.surfaceAreaCircle(radius), 1e-6);
    }

    @Test
    void testArea06_surfaceAreaCircle_min() {
        double radius = 1;
        assertEquals(3.14159265, Area.surfaceAreaCircle(radius), 1e-6);
    }

    @Test
    void testArea07_surfaceAreaCircle_minMinus() {
        double radius = -9;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCircle(radius));
        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCircle(0));
        assertEquals("Must be a positive radius", exception.getMessage());
    }

    /*
     * Area/surfaceAreaHemisphere
     * To calculate the hard-coded values, I used the built in calculator in macOS
     */
    @Test
    void testArea01_surfaceAreaHemisphere_maxPlus() {
        // this cannot be tested because we can't input a double that is larger than a double
        //double sideLength = 0;
        //assertThrows(Exception.class, () -> Area.surfaceAreaHemisphere(sideLength), "Throws an exception because the output is too big");
    }

    @Test
    void testArea02_surfaceAreaHemisphere_max() {
        double radius = 1.7976931348623157E+308; // largest double that can be represented
        //System.out.println(Area.surfaceAreaCube(radius));
        assertThrows(Exception.class, () -> Area.surfaceAreaHemisphere(radius), "Throws an exception because the output is too big");
    }

    @Test
    void testArea03_surfaceAreaHemisphere_maxMinus() {
        double radius = 1.7976931348623157E+308;
        assertThrows(Exception.class, () -> Area.surfaceAreaHemisphere(radius), "Throws an exception because the output is too big");
    }

    @Test
    void testArea04_surfaceAreaHemisphere_nom() {
        double radius = 1.7976931348623157E+308/2;
        //System.out.println(Area.surfaceAreaCube(radius));
        assertThrows(Exception.class, () -> Area.surfaceAreaHemisphere(radius), "Throws an exception because the output is too big");
    }

    @Test
    void testArea05_surfaceAreaHemisphere_minPlus() {
        double radius = 3;
        assertEquals(84.82300165, Area.surfaceAreaHemisphere(radius), 1e-6);
    }

    @Test
    void testArea06_surfaceAreaHemisphere_min() {
        double radius = 1;
        assertEquals(9.42477796, Area.surfaceAreaHemisphere(radius), 1e-6);
    }

    @Test
    void testArea07_surfaceAreaHemisphere_minMinus() {
        double radius = -9;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaHemisphere(radius));
        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaHemisphere(0));
        assertEquals("Must be a positive radius", exception.getMessage());
    }



}
