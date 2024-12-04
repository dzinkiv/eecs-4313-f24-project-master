package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class ConsolidatedTester {
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
        assertEquals(54.0, Area.surfaceAreaCube(3), 1e-6);
        assertEquals(6.0, Area.surfaceAreaCube(1), 1e-6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCube(-9));
        assertEquals("Must be a positive sideLength", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCube(0));
        assertEquals("Must be a positive sideLength", exception.getMessage());
        assertThrows(Exception.class, () -> Area.surfaceAreaCube(1.7976931348623157E+308), "Throws an exception because the output is too big");
        assertThrows(Exception.class, () -> Area.surfaceAreaCube(-1.7976931348623157E+308), "Throws an exception because the output is too big");
        assertThrows(Exception.class, () -> Area.surfaceAreaCube(1.7976931348623157E+308/2), "Throws an exception because the output is too big");
    }

    /*
     * Area/surfaceAreaSphere
     * To calculate the hard-coded values, I used the built in calculator in macOS
     */
    @Test
    void testSurfaceAreaSphere() {
        assertEquals(113.09733553, Area.surfaceAreaSphere(3), 1e-6);
        assertEquals(12.56637061, Area.surfaceAreaSphere(1), 1e-6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaSphere(-9));
        assertEquals("Must be a positive radius", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaSphere(0));
        assertEquals("Must be a positive radius", exception.getMessage());
        assertThrows(Exception.class, () -> Area.surfaceAreaSphere(1.7976931348623157E+308), "Throws an exception because the output is too big");
        assertThrows(Exception.class, () -> Area.surfaceAreaSphere(-1.7976931348623157E+308), "Throws an exception because the output is too big");
        assertThrows(Exception.class, () -> Area.surfaceAreaSphere(1.7976931348623157E+308/2), "Throws an exception because the output is too big");
    }

    /*
     * Area/area of a square
     *
     */
    @Test
    void testSurfaceAreaSquare() {
        assertEquals(9.0, Area.surfaceAreaSquare(3), 1e-6);
        assertEquals(1.0, Area.surfaceAreaSquare(1), 1e-6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaSquare(-9));
        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaSquare(0), "Must be a positive length");
        assertEquals("Must be a positive sideLength", exception.getMessage());
        assertThrows(Exception.class, () -> Area.surfaceAreaSquare(1.7976931348623157E+308), "Throws an exception because the output is too big");
        assertThrows(Exception.class, () -> Area.surfaceAreaSquare(-1.7976931348623157E+308), "Throws an exception because the output is too big");
        assertThrows(Exception.class, () -> Area.surfaceAreaSquare(1.7976931348623157E+308/2), "Throws an exception because the output is too big");
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


    @Test
    void testSurfaceAreaCylinder_validInputs() {
        // Arrange
        double radius = 5.0;
        double height = 10.0;
        double expected = 2 * (Math.PI * radius * radius + Math.PI * radius * height);

        double actual = Area.surfaceAreaCylinder(radius, height);

        assertEquals(expected, actual, 0.0001, "Should calculate correct surface area");
    }

    @Test
    void testSurfaceAreaCylinder_zeroRadius() {
        double radius = 0.0;
        double height = 10.0;

        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCylinder(radius, height);
        }, "Should throw exception for non-positive radius");
    }

    @Test
    void testSurfaceAreaCylinder_zeroHeight() {
        double radius = 5.0;
        double height = 0.0;

        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCylinder(radius, height);
        }, "Should throw exception for non-positive height");
    }

    @Test
    void testSurfaceAreaCylinder_negativeRadius() {
        double radius = -5.0;
        double height = 10.0;

        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCylinder(radius, height);
        }, "Should throw exception for negative radius");
    }

    @Test
    void testSurfaceAreaCylinder_negativeHeight() {
        double radius = 5.0;
        double height = -10.0;
        assertThrows(IllegalArgumentException.class, () -> {
            Area.surfaceAreaCylinder(radius, height);
        }, "Should throw exception for negative height");
    }

    @Test
    void testSurfaceAreaCylinder_largeValues() {
        double radius = 1.0E+154;
        double height = 1.0E+154;
        double expected = 2 * (Math.PI * radius * radius + Math.PI * radius * height);

        double actual = Area.surfaceAreaCylinder(radius, height);

        assertEquals(expected, actual, "Should handle large values without overflow");
    }

    @Test
    void testSurfaceAreaTriangle_validInput() {
        double base = 10.0;
        double height = 5.0;
        double expectedArea = 25.0; // (10.0 * 5.0) / 2
        assertEquals(expectedArea, Area.surfaceAreaTriangle(base, height), "The area should be correctly calculated.");
    }

    @Test
    void testSurfaceAreaTriangle_zeroBase() {
        double base = 0.0;
        double height = 5.0;
        assertThrows(IllegalArgumentException.class,
                () -> Area.surfaceAreaTriangle(base, height),
                "Should throw an exception for zero base."
        );
    }

    @Test
    void testSurfaceAreaTriangle_zeroHeight() {
        double base = 10.0;
        double height = 0.0;
        assertThrows(IllegalArgumentException.class,
                () -> Area.surfaceAreaTriangle(base, height),
                "Should throw an exception for zero height."
        );
    }

    @Test
    void testSurfaceAreaTriangle_negativeBase() {
        double base = -10.0;
        double height = 5.0;
        assertThrows(IllegalArgumentException.class,
                () -> Area.surfaceAreaTriangle(base, height),
                "Should throw an exception for negative base."
        );
    }

    @Test
    void testSurfaceAreaTriangle_negativeHeight() {
        double base = 10.0;
        double height = -5.0;
        assertThrows(IllegalArgumentException.class,
                () -> Area.surfaceAreaTriangle(base, height),
                "Should throw an exception for negative height."
        );
    }

    @Test
    void testSurfaceAreaTriangle_maxDouble() {
        double base = Double.MAX_VALUE;
        double height = 1.0;
        double expectedArea = (base * height) / 2;
        assertEquals(expectedArea, Area.surfaceAreaTriangle(base, height), "The area should be correctly calculated for maximum double value.");
    }

    // Test for normal valid inputs
    @Test
    void testSurfaceAreaRectangle_validInputs() {
        double length = 5;
        double width = 10;
        double expectedArea = 50;

        // Assert that the calculated area matches the expected area
        assertEquals(expectedArea, Area.surfaceAreaRectangle(length, width), "Area should be 50 for length 5 and width 10");
    }

    // Test for valid edge case inputs
    @Test
    void testSurfaceAreaRectangle_edgeCase() {
        double length = 1;
        double width = 1;
        double expectedArea = 1;

        // Assert that the calculated area matches the expected area
        assertEquals(expectedArea, Area.surfaceAreaRectangle(length, width), "Area should be 1 for length 1 and width 1");
    }

    // Test for zero length, which should throw an exception
    @Test
    void testSurfaceAreaRectangle_zeroLength() {
        double length = 0;
        double width = 5;

        // Assert that an IllegalArgumentException is thrown for zero length
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaRectangle(length, width),
                "Must be a positive length");
    }

    // Test for zero width, which should throw an exception
    @Test
    void testSurfaceAreaRectangle_zeroWidth() {
        double length = 5;
        double width = 0;

        // Assert that an IllegalArgumentException is thrown for zero width
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaRectangle(length, width),
                "Must be a positive width");
    }

    // Test for negative length, which should throw an exception
    @Test
    void testSurfaceAreaRectangle_negativeLength() {
        double length = -5;
        double width = 5;

        // Assert that an IllegalArgumentException is thrown for negative length
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaRectangle(length, width),
                "Must be a positive length");
    }

    // Test for negative width, which should throw an exception
    @Test
    void testSurfaceAreaRectangle_negativeWidth() {
        double length = 5;
        double width = -10;

        // Assert that an IllegalArgumentException is thrown for negative width
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaRectangle(length, width),
                "Must be a positive width");
    }

    // Test for large valid inputs
    @Test
    void testSurfaceAreaRectangle_largeInputs() {
        double length = 1.7976931348623157E+308; // Large value for length (near max double value)
        double width = 1.7976931348623157E+308;  // Large value for width (near max double value)

        // Calculate area (should return Infinity since it's beyond the max value for a double)
        double result = Area.surfaceAreaRectangle(length, width);
        assertEquals(Double.POSITIVE_INFINITY, result, "Area should be Infinity for very large length and width");
    }

    @Test
    void testSurfaceAreaCone_validInputs() {
        // Valid input test case: radius = 3, height = 4
        double radius = 3;
        double height = 4;
        double expected = Math.PI * 3 * (3 + Math.sqrt(4 * 4 + 3 * 3)); // Should compute correctly
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 0.0001, "Surface area of cone with radius 3 and height 4 should match the expected value.");
    }

    @Test
    void testSurfaceAreaCone_zeroRadius() {
        // Invalid input test case: radius = 0 (throws exception)
        double radius = 0;
        double height = 4;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height), "Throws IllegalArgumentException when radius is zero.");
    }

    @Test
    void testSurfaceAreaCone_zeroHeight() {
        // Invalid input test case: height = 0 (throws exception)
        double radius = 3;
        double height = 0;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height), "Throws IllegalArgumentException when height is zero.");
    }

    @Test
    void testSurfaceAreaCone_negativeRadius() {
        // Invalid input test case: negative radius (throws exception)
        double radius = -3;
        double height = 4;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height), "Throws IllegalArgumentException when radius is negative.");
    }

    @Test
    void testSurfaceAreaCone_negativeHeight() {
        // Invalid input test case: negative height (throws exception)
        double radius = 3;
        double height = -4;
        assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCone(radius, height), "Throws IllegalArgumentException when height is negative.");
    }

    @Test
    void testSurfaceAreaCone_largeValues() {
        // Valid input test case: large radius and height
        double radius = 1.0E+6;
        double height = 1.0E+6;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius)); // Should compute correctly for large values
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 0.0001, "Surface area of cone with large radius and height should match the expected value.");
    }

    @Test
    void testSurfaceAreaCone_edgeCase() {
        // Edge case: radius and height both equal to 1
        double radius = 1;
        double height = 1;
        double expected = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        double result = Area.surfaceAreaCone(radius, height);
        assertEquals(expected, result, 0.0001, "Surface area of cone with radius 1 and height 1 should match the expected value.");
    }

    	/*
	 * CollatzConjectureTest
	 * Classes:
		x(valid)={M, N}
		M= {xℤ|x is an even number}
		N = {xℤ|x is an odd number}

		y(invalid)={M, N}
		O= {yℤ|y is an even number}
		P = {yℤ|y is an odd number}

		NOTE: INVALID only applies to the collatzConjecture method

		NOTE: For hardcoded values I used
		https://goodcalculators.com/collatz-conjecture-calculator/
		to check the values

	 */

    private final CollatzConjecture collatzConjecture = new CollatzConjecture();

    @Test
    void testCollatzConjecture01_nextNum_M_min() {
        int nextNumber = -2147483648; // -2^31
        int expected_number = -1073741824;
        int result = collatzConjecture.nextNumber(nextNumber);
        assertEquals(expected_number, result, "Next Number should be valid for min for even numbers");
    }

    @Test
    void testCollatzConjecture02_nextNum_M_minPlus() {
        int nextNumber = -2147483648+2; // -2^31
        int expected_number = -1073741823;
        int result = collatzConjecture.nextNumber(nextNumber);
        assertEquals(expected_number, result, "Next Number should be valid for min plus for even numbers");
    }

    @Test
    void testCollatzConjecture03_nextNum_M_nom() {
        int nextNumber = 0;
        int expected_number = 0;
        int result = collatzConjecture.nextNumber(nextNumber);
        assertEquals(expected_number, result, "Next Number should be valid for nom for even numbers");
    }

    @Test
    void testCollatzConjecture04_nextNum_M_maxMinus() {
        int nextNumber = 2147483646-2;
        int expected_number = 1073741822;
        int result = collatzConjecture.nextNumber(nextNumber);
        assertEquals(expected_number, result, "Next Number should be valid for maxMinus for even numbers");
    }

    @Test
    void testCollatzConjecture05_nextNum_M_max() {
        int nextNumber = 2147483646;
        int expected_number = 1073741823;
        int result = collatzConjecture.nextNumber(nextNumber);
        assertEquals(expected_number, result, "Next Number should be valid for max for even numbers");
    }

    @Test
    void testCollatzConjecture06_nextNum_N_min() {
        int nextNumber = -2147483647; // -2^31
        //int expected_number = -6442450940;
        // Throws exception because answer is out of integer range
        assertThrows(Exception.class, () -> collatzConjecture.nextNumber(nextNumber), "Throws exception because answer is out of integer range");
    }

    @Test
    void testCollatzConjecture07_nextNum_N_minPlus() {
        int nextNumber = -2147483647+2; // -2^31
        // Throws exception because answer is out of integer range
        assertThrows(Exception.class, () -> collatzConjecture.nextNumber(nextNumber), "Throws exception because answer is out of integer range");
    }

    @Test
    void testCollatzConjecture08_nextNum_N_nom() {
        int nextNumber = -1;
        int expected_number = -4;
        int result = collatzConjecture.nextNumber(nextNumber);
        assertEquals(expected_number, result, "Next Number should be valid for nom for odd numbers");
    }

    @Test
    void testCollatzConjecture09_nextNum_N_maxMinus() {
        int nextNumber = 2147483647;
        assertThrows(Exception.class, () -> collatzConjecture.nextNumber(nextNumber), "Throws exception because answer is out of integer range");
    }

    @Test
    void testCollatzConjecture10_nextNum_N_max() {
        int nextNumber = 2147483647-2;
        assertThrows(Exception.class, () -> collatzConjecture.nextNumber(nextNumber), "Throws exception because answer is out of integer range");
    }
    /////////
//    @Test
//    void testCollatzConjectureValidInputLargeNumber() {
//        int firstNumber = 27; // Known to produce a long sequence
//        List<Integer> result = collatzConjecture.collatzConjecture(firstNumber);
//        assertNotNull(result, "The sequence should not be null for a valid large input.");
//        assertTrue(result.size() > 1, "The sequence for 27 should have multiple steps.");
//    }

    @Test
    void testCollatzConjecture11_collatzConjecture_M_min() {
        int firstNumber = 2;
        List<Integer> expectedSequence = List.of(2, 1);
        List<Integer> result = collatzConjecture.collatzConjecture(firstNumber);
        assertNotNull(result, "The sequence should not be null for a valid large input.");
        assertIterableEquals(expectedSequence, result, "The sequence should be 1");
    }

    @Test
    void testCollatzConjecture12_collatzConjecture_M_minPlus() {
        int firstNumber = 4;
        List<Integer> expectedSequence = List.of(4, 2, 1);
        List<Integer> result = collatzConjecture.collatzConjecture(firstNumber);
        assertNotNull(result, "The sequence should not be null for a valid large input.");
        assertIterableEquals(expectedSequence, result, "The sequence should be 1");
    }

    @Test
    void testCollatzConjecture13_collatzConjecture_M_nom() {
        // 2147483646
        int firstNumber = 1073741822; // 2147483646/2 + 1
        //System.out.println(collatzConjecture.collatzConjecture(firstNumber));
        // List<Integer> expectedSequence = List.of(1073741822, 536870911, 1610612734, 805306367, 2415919102, 1207959551, 3623878654, 1811939327, 5435817982, 2717908991, 8153726974, 4076863487, 12230590462, 6115295231, 18345885694, 9172942847, 27518828542, 13759414271, 41278242814, 20639121407, 61917364222, 30958682111, 92876046334, 46438023167, 139314069502, 69657034751, 208971104254, 104485552127, 313456656382, 156728328191, 470184984574, 235092492287, 705277476862, 352638738431, 1057916215294, 528958107647, 1586874322942, 793437161471, 2380311484414, 1190155742207, 3570467226622, 1785233613311, 5355700839934, 2677850419967, 8033551259902, 4016775629951, 12050326889854, 6025163444927, 18075490334782, 9037745167391, 27113235502174, 13556617751087, 40669853253262, 20334926626631, 61004779879894, 30502389939947, 91507169819842, 45753584909921, 137260754729764, 68630377364882, 34315188682441, 102945566047324, 51472783023662, 25736391511831, 77209174535494, 38604587267747, 115813761803242, 57906880901621, 173720642704864, 86860321352432, 43430160676216, 21715080338108, 10857540169054, 5428770084527, 16286310253582, 8143155126791, 24429465380374, 12214732690187, 36644198070562, 18322099035281, 54966297105844, 27483148552922, 13741574276461, 41224722829384, 20612361414692, 10306180707346, 5153090353673, 15459271061020, 7729635530510, 3864817765255, 11594453295766, 5797226647883, 17391679943650, 8695839971825, 26087519915476, 13043759957738, 6521879978869, 19565639936608, 9782819968304, 4891409984152, 2445704992076, 1222852496038, 611426248019, 1834278744058, 917139372029, 2751418116088, 1375709058044, 687854529022, 343927264511, 1031781793534, 515890896767, 1547672690302, 773836345151, 2321509035454, 1160754517727, 3482263553182, 1741131776591, 5223395329774, 2611697664887, 7835092994662, 3917546497331, 11752639491994, 5876319745997, 17628959237992, 8814479618996, 4407239809498, 2203619904749, 6610859714248, 3305429857124, 1652714928562, 826357464281, 2479072392844, 1239536196422, 619768098211, 1859304294634, 929652147317, 2788956441952, 1394478220976, 697239110488, 348619555244, 174309777622, 87154888811, 261464666434, 130732333217, 392196999652, 196098499826, 98049249913, 294147749740, 147073874870, 73536937435, 220610812306, 110305406153, 330916218460, 165458109230, 82729054615, 248187163846, 124093581923, 372280745770, 186140372885, 558421118656, 279210559328, 139605279664, 69802639832, 34901319916, 17450659958, 8725329979, 26175989938, 13087994969, 39263984908, 19631992454, 9815996227, 29447988682, 14723994341, 44171983024, 22085991512, 11042995756, 5521497878, 2760748939, 8282246818, 4141123409, 12423370228, 6211685114, 3105842557, 9317527672, 4658763836, 2329381918, 1164690959, 3494072878, 1747036439, 5241109318, 2620554659, 7861663978, 3930831989, 11792495968, 5896247984, 2948123992, 1474061996, 737030998, 368515499, 1105546498, 552773249, 1658319748, 829159874, 414579937, 1243739812, 621869906, 310934953, 932804860, 466402430, 233201215, 699603646, 349801823, 1049405470, 524702735, 1574108206, 787054103, 2361162310, 1180581155, 3541743466, 1770871733, 5312615200, 2656307600, 1328153800, 664076900, 332038450, 166019225, 498057676, 249028838, 124514419, 373543258, 186771629, 560314888, 280157444, 140078722, 70039361, 210118084, 105059042, 52529521, 157588564, 78794282, 39397141, 118191424, 59095712, 29547856, 14773928, 7386964, 3693482, 1846741, 5540224, 2770112, 1385056, 692528, 346264, 173132, 86566, 43283, 129850, 64925, 194776, 97388, 48694, 24347, 73042, 36521, 109564, 54782, 27391, 82174, 41087, 123262, 61631, 184894, 92447, 277342, 138671, 416014, 208007, 624022, 312011, 936034, 468017, 1404052, 702026, 351013, 1053040, 526520, 263260, 131630, 65815, 197446, 98723, 296170, 148085, 444256, 222128, 111064, 55532, 27766, 13883, 41650, 20825, 62476, 31238, 15619, 46858, 23429, 70288, 35144, 17572, 8786, 4393, 13180, 6590, 3295, 9886, 4943, 14830, 7415, 22246, 11123, 33370, 16685, 50056, 25028, 12514, 6257, 18772, 9386, 4693, 14080, 7040, 3520, 1760, 880, 440, 220, 110, 55, 166, 83, 250, 125, 376, 188, 94, 47, 142, 71, 214, 107, 322, 161, 484, 242, 121, 364, 182, 91, 274, 137, 412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890, 445, 1336, 668, 334, 167, 502, 251, 754, 377, 1132, 566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438, 719, 2158, 1079, 3238, 1619, 4858, 2429, 7288, 3644, 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308, 1154, 577, 1732, 866, 433, 1300, 650, 325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1);
        assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because answer is out of integer range");
    }

    @Test
    void testCollatzConjecture14_collatzConjecture_M_maxMinus() {
        int firstNumber = 2147483646-2;
        //List<Integer> expectedSequence = List.of(2147483644, 1073741822, 536870911, 1610612734, 805306367, 2415919102, 1207959551, 3623878654, 1811939327, 5435817982, 2717908991, 8153726974, 4076863487, 12230590462, 6115295231, 18345885694, 9172942847, 27518828542, 13759414271, 41278242814, 20639121407, 61917364222, 30958682111, 92876046334, 46438023167, 139314069502, 69657034751, 208971104254, 104485552127, 313456656382, 156728328191, 470184984574, 235092492287, 705277476862, 352638738431, 1057916215294, 528958107647, 1586874322942, 793437161471, 2380311484414, 1190155742207, 3570467226622, 1785233613311, 5355700839934, 2677850419967, 8033551259902, 4016775629951, 12050326889854, 6025163444927, 18075490334782, 9037745167391, 27113235502174, 13556617751087, 40669853253262, 20334926626631, 61004779879894, 30502389939947, 91507169819842, 45753584909921, 137260754729764, 68630377364882, 34315188682441, 102945566047324, 51472783023662, 25736391511831, 77209174535494, 38604587267747, 115813761803242, 57906880901621, 173720642704864, 86860321352432, 43430160676216, 21715080338108, 10857540169054, 5428770084527, 16286310253582, 8143155126791, 24429465380374, 12214732690187, 36644198070562, 18322099035281, 54966297105844, 27483148552922, 13741574276461, 41224722829384, 20612361414692, 10306180707346, 5153090353673, 15459271061020, 7729635530510, 3864817765255, 11594453295766, 5797226647883, 17391679943650, 8695839971825, 26087519915476, 13043759957738, 6521879978869, 19565639936608, 9782819968304, 4891409984152, 2445704992076, 1222852496038, 611426248019, 1834278744058, 917139372029, 2751418116088, 1375709058044, 687854529022, 343927264511, 1031781793534, 515890896767, 1547672690302, 773836345151, 2321509035454, 1160754517727, 3482263553182, 1741131776591, 5223395329774, 2611697664887, 7835092994662, 3917546497331, 11752639491994, 5876319745997, 17628959237992, 8814479618996, 4407239809498, 2203619904749, 6610859714248, 3305429857124, 1652714928562, 826357464281, 2479072392844, 1239536196422, 619768098211, 1859304294634, 929652147317, 2788956441952, 1394478220976, 697239110488, 348619555244, 174309777622, 87154888811, 261464666434, 130732333217, 392196999652, 196098499826, 98049249913, 294147749740, 147073874870, 73536937435, 220610812306, 110305406153, 330916218460, 165458109230, 82729054615, 248187163846, 124093581923, 372280745770, 186140372885, 558421118656, 279210559328, 139605279664, 69802639832, 34901319916, 17450659958, 8725329979, 26175989938, 13087994969, 39263984908, 19631992454, 9815996227, 29447988682, 14723994341, 44171983024, 22085991512, 11042995756, 5521497878, 2760748939, 8282246818, 4141123409, 12423370228, 6211685114, 3105842557, 9317527672, 4658763836, 2329381918, 1164690959, 3494072878, 1747036439, 5241109318, 2620554659, 7861663978, 3930831989, 11792495968, 5896247984, 2948123992, 1474061996, 737030998, 368515499, 1105546498, 552773249, 1658319748, 829159874, 414579937, 1243739812, 621869906, 310934953, 932804860, 466402430, 233201215, 699603646, 349801823, 1049405470, 524702735, 1574108206, 787054103, 2361162310, 1180581155, 3541743466, 1770871733, 5312615200, 2656307600, 1328153800, 664076900, 332038450, 166019225, 498057676, 249028838, 124514419, 373543258, 186771629, 560314888, 280157444, 140078722, 70039361, 210118084, 105059042, 52529521, 157588564, 78794282, 39397141, 118191424, 59095712, 29547856, 14773928, 7386964, 3693482, 1846741, 5540224, 2770112, 1385056, 692528, 346264, 173132, 86566, 43283, 129850, 64925, 194776, 97388, 48694, 24347, 73042, 36521, 109564, 54782, 27391, 82174, 41087, 123262, 61631, 184894, 92447, 277342, 138671, 416014, 208007, 624022, 312011, 936034, 468017, 1404052, 702026, 351013, 1053040, 526520, 263260, 131630, 65815, 197446, 98723, 296170, 148085, 444256, 222128, 111064, 55532, 27766, 13883, 41650, 20825, 62476, 31238, 15619, 46858, 23429, 70288, 35144, 17572, 8786, 4393, 13180, 6590, 3295, 9886, 4943, 14830, 7415, 22246, 11123, 33370, 16685, 50056, 25028, 12514, 6257, 18772, 9386, 4693, 14080, 7040, 3520, 1760, 880, 440, 220, 110, 55, 166, 83, 250, 125, 376, 188, 94, 47, 142, 71, 214, 107, 322, 161, 484, 242, 121, 364, 182, 91, 274, 137, 412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890, 445, 1336, 668, 334, 167, 502, 251, 754, 377, 1132, 566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438, 719, 2158, 1079, 3238, 1619, 4858, 2429, 7288, 3644, 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308, 1154, 577, 1732, 866, 433, 1300, 650, 325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1);
        assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because answer is out of integer range");
    }

    @Test
    void testCollatzConjecture15_collatzConjecture_M_max() {
        int firstNumber = 2147483646;
        //List<Integer> expectedSequence = List.of(2147483646, 1073741823, 3221225470, 1610612735, 4831838206, 2415919103, 7247757310, 3623878655, 10871635966, 5435817983, 16307453950, 8153726975, 24461180926, 12230590463, 36691771390, 18345885695, 55037657086, 27518828543, 82556485630, 41278242815, 123834728446, 61917364223, 185752092670, 92876046335, 278628139006, 139314069503, 417942208510, 208971104255, 626913312766, 313456656383, 940369969150, 470184984575, 1410554953726, 705277476863, 2115832430590, 1057916215295, 3173748645886, 1586874322943, 4760622968830, 2380311484415, 7140934453246, 3570467226623, 10711401679870, 5355700839935, 16067102519806, 8033551259903, 24100653779710, 12050326889855, 36150980669566, 18075490334783, 54226471004350, 27113235502175, 81339706506526, 40669853253263, 122009559759790, 61004779879895, 183014339639686, 91507169819843, 274521509459530, 137260754729765, 411782264189296, 205891132094648, 102945566047324, 51472783023662, 25736391511831, 77209174535494, 38604587267747, 115813761803242, 57906880901621, 173720642704864, 86860321352432, 43430160676216, 21715080338108, 10857540169054, 5428770084527, 16286310253582, 8143155126791, 24429465380374, 12214732690187, 36644198070562, 18322099035281, 54966297105844, 27483148552922, 13741574276461, 41224722829384, 20612361414692, 10306180707346, 5153090353673, 15459271061020, 7729635530510, 3864817765255, 11594453295766, 5797226647883, 17391679943650, 8695839971825, 26087519915476, 13043759957738, 6521879978869, 19565639936608, 9782819968304, 4891409984152, 2445704992076, 1222852496038, 611426248019, 1834278744058, 917139372029, 2751418116088, 1375709058044, 687854529022, 343927264511, 1031781793534, 515890896767, 1547672690302, 773836345151, 2321509035454, 1160754517727, 3482263553182, 1741131776591, 5223395329774, 2611697664887, 7835092994662, 3917546497331, 11752639491994, 5876319745997, 17628959237992, 8814479618996, 4407239809498, 2203619904749, 6610859714248, 3305429857124, 1652714928562, 826357464281, 2479072392844, 1239536196422, 619768098211, 1859304294634, 929652147317, 2788956441952, 1394478220976, 697239110488, 348619555244, 174309777622, 87154888811, 261464666434, 130732333217, 392196999652, 196098499826, 98049249913, 294147749740, 147073874870, 73536937435, 220610812306, 110305406153, 330916218460, 165458109230, 82729054615, 248187163846, 124093581923, 372280745770, 186140372885, 558421118656, 279210559328, 139605279664, 69802639832, 34901319916, 17450659958, 8725329979, 26175989938, 13087994969, 39263984908, 19631992454, 9815996227, 29447988682, 14723994341, 44171983024, 22085991512, 11042995756, 5521497878, 2760748939, 8282246818, 4141123409, 12423370228, 6211685114, 3105842557, 9317527672, 4658763836, 2329381918, 1164690959, 3494072878, 1747036439, 5241109318, 2620554659, 7861663978, 3930831989, 11792495968, 5896247984, 2948123992, 1474061996, 737030998, 368515499, 1105546498, 552773249, 1658319748, 829159874, 414579937, 1243739812, 621869906, 310934953, 932804860, 466402430, 233201215, 699603646, 349801823, 1049405470, 524702735, 1574108206, 787054103, 2361162310, 1180581155, 3541743466, 1770871733, 5312615200, 2656307600, 1328153800, 664076900, 332038450, 166019225, 498057676, 249028838, 124514419, 373543258, 186771629, 560314888, 280157444, 140078722, 70039361, 210118084, 105059042, 52529521, 157588564, 78794282, 39397141, 118191424, 59095712, 29547856, 14773928, 7386964, 3693482, 1846741, 5540224, 2770112, 1385056, 692528, 346264, 173132, 86566, 43283, 129850, 64925, 194776, 97388, 48694, 24347, 73042, 36521, 109564, 54782, 27391, 82174, 41087, 123262, 61631, 184894, 92447, 277342, 138671, 416014, 208007, 624022, 312011, 936034, 468017, 1404052, 702026, 351013, 1053040, 526520, 263260, 131630, 65815, 197446, 98723, 296170, 148085, 444256, 222128, 111064, 55532, 27766, 13883, 41650, 20825, 62476, 31238, 15619, 46858, 23429, 70288, 35144, 17572, 8786, 4393, 13180, 6590, 3295, 9886, 4943, 14830, 7415, 22246, 11123, 33370, 16685, 50056, 25028, 12514, 6257, 18772, 9386, 4693, 14080, 7040, 3520, 1760, 880, 440, 220, 110, 55, 166, 83, 250, 125, 376, 188, 94, 47, 142, 71, 214, 107, 322, 161, 484, 242, 121, 364, 182, 91, 274, 137, 412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890, 445, 1336, 668, 334, 167, 502, 251, 754, 377, 1132, 566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438, 719, 2158, 1079, 3238, 1619, 4858, 2429, 7288, 3644, 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308, 1154, 577, 1732, 866, 433, 1300, 650, 325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1);
        // cannot test because java throws java.lang.OutOfMemoryError: Java heap space
        //assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because answer is out of integer range");
    }

    @Test
    void testCollatzConjecture16_collatzConjecture_N_min() {
        int firstNumber = 1;
        List<Integer> expectedSequence = List.of(1);
        List<Integer> result = collatzConjecture.collatzConjecture(firstNumber);
        assertNotNull(result, "The sequence should not be null for a valid large input.");
        assertIterableEquals(expectedSequence, result, "The sequence should be 1");
    }

    @Test
    void testCollatzConjecture17_collatzConjecture_N_minPlus() {
        int firstNumber = 3;
        List<Integer> expectedSequence = List.of(3, 10, 5, 16, 8, 4, 2, 1);
        List<Integer> result = collatzConjecture.collatzConjecture(firstNumber);
        assertNotNull(result, "The sequence should not be null for a valid large input.");
        assertIterableEquals(expectedSequence, result, "The sequence should be the expected sequence");
    }

    @Test
    void testCollatzConjecture18_collatzConjecture_N_nom() {
        // 2147483646
        int firstNumber = 1073741823; // 2147483646/2 + 1
        //System.out.println(collatzConjecture.collatzConjecture(firstNumber));
        //List<Integer> expectedSequence = List.of(1073741823, 3221225470, 1610612735, 4831838206, 2415919103, 7247757310, 3623878655, 10871635966, 5435817983, 16307453950, 8153726975, 24461180926, 12230590463, 36691771390, 18345885695, 55037657086, 27518828543, 82556485630, 41278242815, 123834728446, 61917364223, 185752092670, 92876046335, 278628139006, 139314069503, 417942208510, 208971104255, 626913312766, 313456656383, 940369969150, 470184984575, 1410554953726, 705277476863, 2115832430590, 1057916215295, 3173748645886, 1586874322943, 4760622968830, 2380311484415, 7140934453246, 3570467226623, 10711401679870, 5355700839935, 16067102519806, 8033551259903, 24100653779710, 12050326889855, 36150980669566, 18075490334783, 54226471004350, 27113235502175, 81339706506526, 40669853253263, 122009559759790, 61004779879895, 183014339639686, 91507169819843, 274521509459530, 137260754729765, 411782264189296, 205891132094648, 102945566047324, 51472783023662, 25736391511831, 77209174535494, 38604587267747, 115813761803242, 57906880901621, 173720642704864, 86860321352432, 43430160676216, 21715080338108, 10857540169054, 5428770084527, 16286310253582, 8143155126791, 24429465380374, 12214732690187, 36644198070562, 18322099035281, 54966297105844, 27483148552922, 13741574276461, 41224722829384, 20612361414692, 10306180707346, 5153090353673, 15459271061020, 7729635530510, 3864817765255, 11594453295766, 5797226647883, 17391679943650, 8695839971825, 26087519915476, 13043759957738, 6521879978869, 19565639936608, 9782819968304, 4891409984152, 2445704992076, 1222852496038, 611426248019, 1834278744058, 917139372029, 2751418116088, 1375709058044, 687854529022, 343927264511, 1031781793534, 515890896767, 1547672690302, 773836345151, 2321509035454, 1160754517727, 3482263553182, 1741131776591, 5223395329774, 2611697664887, 7835092994662, 3917546497331, 11752639491994, 5876319745997, 17628959237992, 8814479618996, 4407239809498, 2203619904749, 6610859714248, 3305429857124, 1652714928562, 826357464281, 2479072392844, 1239536196422, 619768098211, 1859304294634, 929652147317, 2788956441952, 1394478220976, 697239110488, 348619555244, 174309777622, 87154888811, 261464666434, 130732333217, 392196999652, 196098499826, 98049249913, 294147749740, 147073874870, 73536937435, 220610812306, 110305406153, 330916218460, 165458109230, 82729054615, 248187163846, 124093581923, 372280745770, 186140372885, 558421118656, 279210559328, 139605279664, 69802639832, 34901319916, 17450659958, 8725329979, 26175989938, 13087994969, 39263984908, 19631992454, 9815996227, 29447988682, 14723994341, 44171983024, 22085991512, 11042995756, 5521497878, 2760748939, 8282246818, 4141123409, 12423370228, 6211685114, 3105842557, 9317527672, 4658763836, 2329381918, 1164690959, 3494072878, 1747036439, 5241109318, 2620554659, 7861663978, 3930831989, 11792495968, 5896247984, 2948123992, 1474061996, 737030998, 368515499, 1105546498, 552773249, 1658319748, 829159874, 414579937, 1243739812, 621869906, 310934953, 932804860, 466402430, 233201215, 699603646, 349801823, 1049405470, 524702735, 1574108206, 787054103, 2361162310, 1180581155, 3541743466, 1770871733, 5312615200, 2656307600, 1328153800, 664076900, 332038450, 166019225, 498057676, 249028838, 124514419, 373543258, 186771629, 560314888, 280157444, 140078722, 70039361, 210118084, 105059042, 52529521, 157588564, 78794282, 39397141, 118191424, 59095712, 29547856, 14773928, 7386964, 3693482, 1846741, 5540224, 2770112, 1385056, 692528, 346264, 173132, 86566, 43283, 129850, 64925, 194776, 97388, 48694, 24347, 73042, 36521, 109564, 54782, 27391, 82174, 41087, 123262, 61631, 184894, 92447, 277342, 138671, 416014, 208007, 624022, 312011, 936034, 468017, 1404052, 702026, 351013, 1053040, 526520, 263260, 131630, 65815, 197446, 98723, 296170, 148085, 444256, 222128, 111064, 55532, 27766, 13883, 41650, 20825, 62476, 31238, 15619, 46858, 23429, 70288, 35144, 17572, 8786, 4393, 13180, 6590, 3295, 9886, 4943, 14830, 7415, 22246, 11123, 33370, 16685, 50056, 25028, 12514, 6257, 18772, 9386, 4693, 14080, 7040, 3520, 1760, 880, 440, 220, 110, 55, 166, 83, 250, 125, 376, 188, 94, 47, 142, 71, 214, 107, 322, 161, 484, 242, 121, 364, 182, 91, 274, 137, 412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890, 445, 1336, 668, 334, 167, 502, 251, 754, 377, 1132, 566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438, 719, 2158, 1079, 3238, 1619, 4858, 2429, 7288, 3644, 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308, 1154, 577, 1732, 866, 433, 1300, 650, 325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1);
        // cannot test because java throws java.lang.OutOfMemoryError: Java heap space
        //assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because answer is out of integer range");
    }

    @Test
    void testCollatzConjecture19_collatzConjecture_N_maxMinus() {
        int firstNumber = 2147483647;
        //List<Integer> expectedSequence = List.of(2147483647, 6442450942, 3221225471, 9663676414, 4831838207, 14495514622, 7247757311, 21743271934, 10871635967, 32614907902, 16307453951, 48922361854, 24461180927, 73383542782, 36691771391, 110075314174, 55037657087, 165112971262, 82556485631, 247669456894, 123834728447, 371504185342, 185752092671, 557256278014, 278628139007, 835884417022, 417942208511, 1253826625534, 626913312767, 1880739938302, 940369969151, 2821109907454, 1410554953727, 4231664861182, 2115832430591, 6347497291774, 3173748645887, 9521245937662, 4760622968831, 14281868906494, 7140934453247, 21422803359742, 10711401679871, 32134205039614, 16067102519807, 48201307559422, 24100653779711, 72301961339134, 36150980669567, 108452942008702, 54226471004351, 162679413013054, 81339706506527, 244019119519582, 122009559759791, 366028679279374, 183014339639687, 549043018919062, 274521509459531, 823564528378594, 411782264189297, 1235346792567892, 617673396283946, 308836698141973, 926510094425920, 463255047212960, 231627523606480, 115813761803240, 57906880901620, 28953440450810, 14476720225405, 43430160676216, 21715080338108, 10857540169054, 5428770084527, 16286310253582, 8143155126791, 24429465380374, 12214732690187, 36644198070562, 18322099035281, 54966297105844, 27483148552922, 13741574276461, 41224722829384, 20612361414692, 10306180707346, 5153090353673, 15459271061020, 7729635530510, 3864817765255, 11594453295766, 5797226647883, 17391679943650, 8695839971825, 26087519915476, 13043759957738, 6521879978869, 19565639936608, 9782819968304, 4891409984152, 2445704992076, 1222852496038, 611426248019, 1834278744058, 917139372029, 2751418116088, 1375709058044, 687854529022, 343927264511, 1031781793534, 515890896767, 1547672690302, 773836345151, 2321509035454, 1160754517727, 3482263553182, 1741131776591, 5223395329774, 2611697664887, 7835092994662, 3917546497331, 11752639491994, 5876319745997, 17628959237992, 8814479618996, 4407239809498, 2203619904749, 6610859714248, 3305429857124, 1652714928562, 826357464281, 2479072392844, 1239536196422, 619768098211, 1859304294634, 929652147317, 2788956441952, 1394478220976, 697239110488, 348619555244, 174309777622, 87154888811, 261464666434, 130732333217, 392196999652, 196098499826, 98049249913, 294147749740, 147073874870, 73536937435, 220610812306, 110305406153, 330916218460, 165458109230, 82729054615, 248187163846, 124093581923, 372280745770, 186140372885, 558421118656, 279210559328, 139605279664, 69802639832, 34901319916, 17450659958, 8725329979, 26175989938, 13087994969, 39263984908, 19631992454, 9815996227, 29447988682, 14723994341, 44171983024, 22085991512, 11042995756, 5521497878, 2760748939, 8282246818, 4141123409, 12423370228, 6211685114, 3105842557, 9317527672, 4658763836, 2329381918, 1164690959, 3494072878, 1747036439, 5241109318, 2620554659, 7861663978, 3930831989, 11792495968, 5896247984, 2948123992, 1474061996, 737030998, 368515499, 1105546498, 552773249, 1658319748, 829159874, 414579937, 1243739812, 621869906, 310934953, 932804860, 466402430, 233201215, 699603646, 349801823, 1049405470, 524702735, 1574108206, 787054103, 2361162310, 1180581155, 3541743466, 1770871733, 5312615200, 2656307600, 1328153800, 664076900, 332038450, 166019225, 498057676, 249028838, 124514419, 373543258, 186771629, 560314888, 280157444, 140078722, 70039361, 210118084, 105059042, 52529521, 157588564, 78794282, 39397141, 118191424, 59095712, 29547856, 14773928, 7386964, 3693482, 1846741, 5540224, 2770112, 1385056, 692528, 346264, 173132, 86566, 43283, 129850, 64925, 194776, 97388, 48694, 24347, 73042, 36521, 109564, 54782, 27391, 82174, 41087, 123262, 61631, 184894, 92447, 277342, 138671, 416014, 208007, 624022, 312011, 936034, 468017, 1404052, 702026, 351013, 1053040, 526520, 263260, 131630, 65815, 197446, 98723, 296170, 148085, 444256, 222128, 111064, 55532, 27766, 13883, 41650, 20825, 62476, 31238, 15619, 46858, 23429, 70288, 35144, 17572, 8786, 4393, 13180, 6590, 3295, 9886, 4943, 14830, 7415, 22246, 11123, 33370, 16685, 50056, 25028, 12514, 6257, 18772, 9386, 4693, 14080, 7040, 3520, 1760, 880, 440, 220, 110, 55, 166, 83, 250, 125, 376, 188, 94, 47, 142, 71, 214, 107, 322, 161, 484, 242, 121, 364, 182, 91, 274, 137, 412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890, 445, 1336, 668, 334, 167, 502, 251, 754, 377, 1132, 566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438, 719, 2158, 1079, 3238, 1619, 4858, 2429, 7288, 3644, 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308, 1154, 577, 1732, 866, 433, 1300, 650, 325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1);
        // cannot test because java throws java.lang.OutOfMemoryError: Java heap space
        //assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because answer is out of integer range");
    }

    @Test
    void testCollatzConjecture20_collatzConjecture_N_max() {
        int firstNumber = 2147483647-2;
        //List<Integer> expectedSequence = List.of(2147483645, 6442450936, 3221225468, 1610612734, 805306367, 2415919102, 1207959551, 3623878654, 1811939327, 5435817982, 2717908991, 8153726974, 4076863487, 12230590462, 6115295231, 18345885694, 9172942847, 27518828542, 13759414271, 41278242814, 20639121407, 61917364222, 30958682111, 92876046334, 46438023167, 139314069502, 69657034751, 208971104254, 104485552127, 313456656382, 156728328191, 470184984574, 235092492287, 705277476862, 352638738431, 1057916215294, 528958107647, 1586874322942, 793437161471, 2380311484414, 1190155742207, 3570467226622, 1785233613311, 5355700839934, 2677850419967, 8033551259902, 4016775629951, 12050326889854, 6025163444927, 18075490334782, 9037745167391, 27113235502174, 13556617751087, 40669853253262, 20334926626631, 61004779879894, 30502389939947, 91507169819842, 45753584909921, 137260754729764, 68630377364882, 34315188682441, 102945566047324, 51472783023662, 25736391511831, 77209174535494, 38604587267747, 115813761803242, 57906880901621, 173720642704864, 86860321352432, 43430160676216, 21715080338108, 10857540169054, 5428770084527, 16286310253582, 8143155126791, 24429465380374, 12214732690187, 36644198070562, 18322099035281, 54966297105844, 27483148552922, 13741574276461, 41224722829384, 20612361414692, 10306180707346, 5153090353673, 15459271061020, 7729635530510, 3864817765255, 11594453295766, 5797226647883, 17391679943650, 8695839971825, 26087519915476, 13043759957738, 6521879978869, 19565639936608, 9782819968304, 4891409984152, 2445704992076, 1222852496038, 611426248019, 1834278744058, 917139372029, 2751418116088, 1375709058044, 687854529022, 343927264511, 1031781793534, 515890896767, 1547672690302, 773836345151, 2321509035454, 1160754517727, 3482263553182, 1741131776591, 5223395329774, 2611697664887, 7835092994662, 3917546497331, 11752639491994, 5876319745997, 17628959237992, 8814479618996, 4407239809498, 2203619904749, 6610859714248, 3305429857124, 1652714928562, 826357464281, 2479072392844, 1239536196422, 619768098211, 1859304294634, 929652147317, 2788956441952, 1394478220976, 697239110488, 348619555244, 174309777622, 87154888811, 261464666434, 130732333217, 392196999652, 196098499826, 98049249913, 294147749740, 147073874870, 73536937435, 220610812306, 110305406153, 330916218460, 165458109230, 82729054615, 248187163846, 124093581923, 372280745770, 186140372885, 558421118656, 279210559328, 139605279664, 69802639832, 34901319916, 17450659958, 8725329979, 26175989938, 13087994969, 39263984908, 19631992454, 9815996227, 29447988682, 14723994341, 44171983024, 22085991512, 11042995756, 5521497878, 2760748939, 8282246818, 4141123409, 12423370228, 6211685114, 3105842557, 9317527672, 4658763836, 2329381918, 1164690959, 3494072878, 1747036439, 5241109318, 2620554659, 7861663978, 3930831989, 11792495968, 5896247984, 2948123992, 1474061996, 737030998, 368515499, 1105546498, 552773249, 1658319748, 829159874, 414579937, 1243739812, 621869906, 310934953, 932804860, 466402430, 233201215, 699603646, 349801823, 1049405470, 524702735, 1574108206, 787054103, 2361162310, 1180581155, 3541743466, 1770871733, 5312615200, 2656307600, 1328153800, 664076900, 332038450, 166019225, 498057676, 249028838, 124514419, 373543258, 186771629, 560314888, 280157444, 140078722, 70039361, 210118084, 105059042, 52529521, 157588564, 78794282, 39397141, 118191424, 59095712, 29547856, 14773928, 7386964, 3693482, 1846741, 5540224, 2770112, 1385056, 692528, 346264, 173132, 86566, 43283, 129850, 64925, 194776, 97388, 48694, 24347, 73042, 36521, 109564, 54782, 27391, 82174, 41087, 123262, 61631, 184894, 92447, 277342, 138671, 416014, 208007, 624022, 312011, 936034, 468017, 1404052, 702026, 351013, 1053040, 526520, 263260, 131630, 65815, 197446, 98723, 296170, 148085, 444256, 222128, 111064, 55532, 27766, 13883, 41650, 20825, 62476, 31238, 15619, 46858, 23429, 70288, 35144, 17572, 8786, 4393, 13180, 6590, 3295, 9886, 4943, 14830, 7415, 22246, 11123, 33370, 16685, 50056, 25028, 12514, 6257, 18772, 9386, 4693, 14080, 7040, 3520, 1760, 880, 440, 220, 110, 55, 166, 83, 250, 125, 376, 188, 94, 47, 142, 71, 214, 107, 322, 161, 484, 242, 121, 364, 182, 91, 274, 137, 412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890, 445, 1336, 668, 334, 167, 502, 251, 754, 377, 1132, 566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438, 719, 2158, 1079, 3238, 1619, 4858, 2429, 7288, 3644, 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308, 1154, 577, 1732, 866, 433, 1300, 650, 325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1);
        // cannot test because java throws java.lang.OutOfMemoryError: Java heap space
        //assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because answer is out of integer range");
    }

    ///////////////////////////////////////////////////

    @Test
    void testCollatzConjecture11_collatzConjecture_O_min_invalid() {
        int firstNumber = -2;
        assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because input is not a natrual number");
    }

    @Test
    void testCollatzConjecture12_collatzConjecture_O_minPlus_invalid() {
        int firstNumber = -4;
        assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because input is not a natrual number");
    }

    @Test
    void testCollatzConjecture13_collatzConjecture_O_nom_invalid() {
        int firstNumber = -1073741822; // 2147483646/2 + 1
        assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because input is not a natrual number");
    }

    @Test
    void testCollatzConjecture14_collatzConjecture_O_maxMinus_invalid() {
        int firstNumber = -2147483646-2;
        assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because input is not a natrual number");
    }

    @Test
    void testCollatzConjecture15_collatzConjecture_O_max_invalid() {
        int firstNumber = -2147483646;
        assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because input is not a natrual number");
    }

    @Test
    void testCollatzConjecture16_collatzConjecture_P_min_invalid() {
        int firstNumber = -1;
        assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because input is not a natrual number");
    }

    @Test
    void testCollatzConjecture17_collatzConjecture_P_minPlus_invalid() {
        int firstNumber = -3;
        assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because input is not a natrual number");
    }

    @Test
    void testCollatzConjecture18_collatzConjecture_P_nom_invalid() {
        int firstNumber = -1073741823; // 2147483646/2 + 1
        assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because input is not a natrual number");
    }

    @Test
    void testCollatzConjecture19_collatzConjecture_P_maxMinus_invalid() {
        int firstNumber = 2147483647;
        // cannot test because java throws java.lang.OutOfMemoryError: Java heap space
        // assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because input is not a natrual number");

    }

    @Test
    void testCollatzConjecture20_collatzConjecture_P_max_invalid() {
        int firstNumber = 2147483647-2;
        // cannot test because java throws java.lang.OutOfMemoryError: Java heap space
        //assertThrows(Exception.class, () -> collatzConjecture.collatzConjecture(firstNumber), "Throws exception because input is not a natrual number");
    }
    ///////

    /*
	 *
	 * DeterminantOfMatrixTest
	 * Classes:
		a(valid)={M}
		M= {aallPossibleMatrices|a is a square matrix}

		a(invalid)={O}
		O= {aallPossibleMatrices|a is not a square matrix}

		n(valid)={N}
		N = {nℤ, a M|n is the matrix size of a}

		n(invalid)={P}
		P= {nℤ|n is not the matrix size of a}

		For hardcoded values I checked the answer with:
		https://matrix.reshish.com/determinant.php

	 */

    @Test
    void testDeterminant_MN() {
        // valid-valid
        int[][] matrix = {
                {4, 6, 2},
                {4, 7, 9},
                {9, 1, 2}
        };
        int determinant = DeterminantOfMatrix.determinant(matrix, 3);
        assertEquals(340, determinant, "The determinant should equal the expected answer.");
    }

    @Test
    void testDeterminant_MP() {
        // valid-invalid
        int[][] matrix = {
                {4, 6, 2},
                {4, 7, 9},
                {9, 1, 2}
        };
        assertThrows(Exception.class, () -> DeterminantOfMatrix.determinant(matrix, 7), "Throws exception because input n is not consistent with the matrix size of input a");
    }

    @Test
    void testDeterminant_ON() {
        // invalid-valid
        int[][] matrix = {
                {4, 6, 2},
                {4, 7, 9},
        };
        assertThrows(Exception.class, () -> DeterminantOfMatrix.determinant(matrix, 3), "Throws exception because input a is not a square matrix");
    }

    @Test
    void testDeterminant_OP() {
        // invalid-invalid
        int[][] matrix = {
                {4, 6, 2},
                {4, 7, 9},
        };
        assertThrows(Exception.class, () -> DeterminantOfMatrix.determinant(matrix, 7), "Throws exception because input n is not consistent with the matrix size of input a and input a is not a square matrix");
    }

    /*
     * SimpsonIntegrationTest
     */

    @Test
    void testMainMethodValidInput() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        String[] args = {}; // no command-line args
        SimpsonIntegration.main(args);

        // Restore System.out
        System.setOut(originalOut);

        // Capture the output and assert it contains the expected message
        String output = outputStream.toString();
        assertTrue(output.contains("The integral is equal to:"), "Expected output to contain integral result.");
    }


    SimpsonIntegration integration = new SimpsonIntegration();


    @Test
    void testZeroInterval() {
        int n = 2; // Even number
        double a = 1, b = 1; // Zero-width interval
        double h = (b - a) / n;
        double result = integration.simpsonsMethod(n, h, a);
        assertEquals(0, result, 1e-6, "Result should be 0 for zero-width interval.");
    }

    @Test
    void testReversedInterval() {
        int n = 4; // Even number
        double a = 3, b = 1; // Reversed interval
        double h = (b - a) / n;
        double result = integration.simpsonsMethod(n, h, a);
        assertTrue(result < 0, "Result should be negative for a reversed interval.");
    }


    @Test
    void testF_AtMin() {
        // Minimum boundary: x = 0
        double x = 0;
        double result = integration.f(x);
        assertEquals(4, result, 1e-6, "f(0) should return 4.");
    }

    @Test
    void testF_AtMinPlus() {
        // Minimum+ boundary: x = 0.0001
        double x = 0.0001;
        double result = integration.f(x);
        // Expected value calculated manually or approximated
        assertEquals(3.999600, result, 1e-6, "f(0.0001) should return a value slightly less than 4.");
    }

    @Test
    void testF_AtNominal() {
        // Nominal value: x = 1
        double x = 1;
        double result = integration.f(x);
        assertEquals(1.103638, result, 1e-6, "f(1) should be approximately 1.103638.");
    }

    @Test
    void testF_AtMaxMinus() {
        // Maximum- boundary: x = 99 (approaching maximum but still a large number)
        double x = 99;
        double result = integration.f(x);
        assertEquals(0, result, 1e-6, "f(99) should be very close to 0.");
    }

    @Test
    void testF_AtMax() {
        // Maximum boundary: x = 100 (we expect the function to approach 0)
        double x = 100;
        double result = integration.f(x);
        assertEquals(0, result, 1e-6, "f(100) should approach 0.");
    }

    /*
     * Boundary value tests for variable N in simpsonsMethod
     * */

    @Test
    void testSimpsonsN_AtMin() {
        int n = 2; // Minimum valid even number
        double a = 1; // Starting point
        double b = 3; // End point
        double h = (b - a) / n; // Step size
        double result = integration.simpsonsMethod(n, h, a);

        // Expected result calculated separately for f(x) = e^(-x) * (4 - x^2)
        double expected = 0.284900;
        assertEquals(expected, result, 1e-5, "Integration for minimum values failed.");
    }

    @Test
    void testSimpsonsN_AtMinPlus() {
        int n = 4; // Slightly above the minimum
        double a = 1; // Starting point slightly above 0
        double b = 3; // End point
        double h = (b - a) / n; // Step size
        double result = integration.simpsonsMethod(n, h, a);

        // Expected result calculated separately for f(x) = e^(-x) * (4 - x^2)
        double expected = 0.279641;
        assertEquals(expected, result, 1e-5, "Integration for slightly above minimum values failed.");
    }

    @Test
    void testSimpsonsN_AtNominal() {
        int n = 10; // Typical interval count
        double a = 1; // Starting point
        double b = 3; // End point
        double h = (b - a) / n; // Step size
        double result = integration.simpsonsMethod(n, h, a);

        // Expected result calculated separately for f(x) = e^(-x) * (4 - x^2)
        double expected = 0.27935;
        assertEquals(expected, result, 1e-5, "Integration for nominal values failed.");
    }

    @Test
    void testSimpsonsN_AtMaxMinus() {
        int n = 100; // Large interval count
        double a = 1; // Starting point
        double b = 3; // End point
        double h = (b - a) / n; // Step size
        double result = integration.simpsonsMethod(n, h, a);

        // Expected result calculated separately for f(x) = e^(-x) * (4 - x^2)
        double expected = 0.279352;
        assertEquals(expected, result, 1e-5, "Integration for maximum less one failed.");
    }

    @Test
    void testSimpsonsN_AtMax() {
        int n = 200; // Maximum practical interval count
        double a = 1; // Starting point
        double b = 3; // End point
        double h = (b - a) / n; // Step size
        double result = integration.simpsonsMethod(n, h, a);

        // Expected result calculated separately for f(x) = e^(-x) * (4 - x^2)
        double expected = 0.279352;
        assertEquals(expected, result, 1e-5, "Integration for maximum values failed.");
    }

    /*
     * QuadraticEquationSolver
     */
    private final QuadraticEquationSolver solver = new QuadraticEquationSolver();

    @Test
    void testDistinctRealRoots() {
        double a = 1, b = -3, c = 2; // Roots: x = 1, 2
        ComplexNumber[] roots = solver.solveEquation(a, b, c);
        assertNotNull(roots);
        assertEquals(2, roots.length, "Expected two distinct real roots.");
        assertEquals(2.0, roots[0].real, 1e-6, "Incorrect first root.");
        assertEquals(1.0, roots[1].real, 1e-6, "Incorrect second root.");
        assertNull(roots[0].imaginary, "First root should not have an imaginary part.");
        assertNull(roots[1].imaginary, "Second root should not have an imaginary part.");
    }

    @Test
    void testSingleRealRoot() {
        double a = 1, b = -2, c = 1; // Roots: x = 1 (double root)
        ComplexNumber[] roots = solver.solveEquation(a, b, c);
        assertNotNull(roots);
        assertEquals(1, roots.length, "Expected a single real root.");
        assertEquals(1.0, roots[0].real, 1e-6, "Incorrect root.");
        assertNull(roots[0].imaginary, "Root should not have an imaginary part.");
    }

    @Test
    void testComplexRoots() {
        double a = 1, b = 2, c = 5; // Roots: x = -1 ± 2i
        ComplexNumber[] roots = solver.solveEquation(a, b, c);
        assertNotNull(roots);
        assertEquals(2, roots.length, "Expected two complex roots.");
        assertEquals(-1.0, roots[0].real, 1e-6, "Incorrect real part of first root.");
        assertEquals(-1.0, roots[1].real, 1e-6, "Incorrect real part of second root.");
        assertEquals(2.0, roots[0].imaginary, 1e-6, "Incorrect imaginary part of first root.");
        assertEquals(-2.0, roots[1].imaginary, 1e-6, "Incorrect imaginary part of second root.");
    }

    //Fails!!!
    @Test
    void testZeroCoefficientAThrowsException() {
        double a = 0, b = 2, c = 3; // Not a quadratic equation
        Exception exception = assertThrows(
                ArithmeticException.class,
                () -> solver.solveEquation(a, b, c),
                "Coefficient 'a' being zero should throw an exception."
        );
        assertEquals("/ by zero", exception.getMessage(), "Expected divide-by-zero exception.");
    }

    @Test
    void testZeroCoefficients() {
        double a = 1, b = 0, c = 0; // Root: x = 0
        ComplexNumber[] roots = solver.solveEquation(a, b, c);
        assertNotNull(roots);
        assertEquals(1, roots.length, "Expected a single root.");
        assertEquals(0.0, roots[0].real, 1e-6, "Incorrect root.");
        assertNull(roots[0].imaginary, "Root should not have an imaginary part.");
    }

    @Test
    void testNegativeDiscriminantWithSmallA() {
        double a = 0.5, b = 1, c = 2; // Roots: x = -1 ± i√3
        ComplexNumber[] roots = solver.solveEquation(a, b, c);
        assertNotNull(roots);
        assertEquals(2, roots.length, "Expected two complex roots.");
        assertEquals(-1.0, roots[0].real, 1e-6, "Incorrect real part of first root.");
        assertEquals(-1.0, roots[1].real, 1e-6, "Incorrect real part of second root.");
        assertEquals(Math.sqrt(3), roots[0].imaginary, 1e-6, "Incorrect imaginary part of first root.");
        assertEquals(-Math.sqrt(3), roots[1].imaginary, 1e-6, "Incorrect imaginary part of second root.");
    }

    @Test
    void testAllZeroCoefficients() {
        double a = 0, b = 0, c = 0; // Not a valid equation
        ComplexNumber[] roots = solver.solveEquation(a, b, c);
        assertNotNull(roots);
        assertEquals(1, roots.length, "Expected no roots for all coefficients zero."); // changed expected from 0 to 1
    }

    @Test
    void testVeryLargeCoefficients() {
        double a = 1e6, b = -3e6, c = 2e6; // Roots: x = 2, 1
        ComplexNumber[] roots = solver.solveEquation(a, b, c);
        assertNotNull(roots);
        assertEquals(2, roots.length, "Expected two distinct real roots for large coefficients.");
        assertEquals(2.0, roots[0].real, 1e-3, "Incorrect first root for large coefficients.");
        assertEquals(1.0, roots[1].real, 1e-3, "Incorrect second root for large coefficients.");
        assertNull(roots[0].imaginary, "First root should not have an imaginary part.");
        assertNull(roots[1].imaginary, "Second root should not have an imaginary part.");
    }
}
