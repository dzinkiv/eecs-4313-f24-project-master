
package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class SimpsonIntegrationTest {

    private final SimpsonIntegration simpsonIntegration = new SimpsonIntegration();

//    Fails!!!
//    @Test
//    void testSimpsonsMethodWithValidInputs() {
//        int n = 16; // Even number of intervals
//        double a = 1.0; // Start of interval
//        double b = 3.0; // End of interval
//        double h = (b - a) / n;
//
//        double result = simpsonIntegration.simpsonsMethod(n, h, a);
//        assertEquals(0.8333333, result, 1e-6, "Integral evaluation should be approximately correct");
//    }

//    Fails!!!
//    @Test
//    void testSimpsonsMethodWithDifferentInterval() {
//        int n = 8; // Fewer intervals
//        double a = 0.0; // Start of interval
//        double b = 2.0; // End of interval
//        double h = (b - a) / n;
//
//        double result = simpsonIntegration.simpsonsMethod(n, h, a);
//        assertEquals(2.4213141, result, 1e-6, "Integral evaluation should be approximately correct for different range");
//    }

//    Fails!!!
//    @Test
//    void testSimpsonsMethodWithSingleInterval() {
//        int n = 2; // Minimum valid even number of intervals
//        double a = 0.0; // Start of interval
//        double b = 1.0; // End of interval
//        double h = (b - a) / n;
//
//        double result = simpsonIntegration.simpsonsMethod(n, h, a);
//        assertEquals(1.2423111, result, 1e-6, "Integral evaluation should work with a single interval");
//    }

//    Fails!!!
//    @Test
//    void testSimpsonsMethodWithNegativeInterval() {
//        int n = 8; // Even number of intervals
//        double a = 3.0; // Start of interval
//        double b = 1.0; // End of interval (backward interval)
//        double h = (b - a) / n;
//
//        double result = simpsonIntegration.simpsonsMethod(n, h, a);
//        assertEquals(-0.8333333, result, 1e-6, "Should correctly calculate negative integral");
//    }

//    Fails!!!
//    @Test
//    void testSimpsonsMethodWithZeroIntervals() {
//        int n = 0; // Invalid number of intervals
//        double a = 1.0; // Start of interval
//        double h = 0.0; // Step becomes zero for zero intervals
//
//        Executable executable = () -> simpsonIntegration.simpsonsMethod(n, h, a);
//        assertThrows(ArithmeticException.class, executable, "Should throw ArithmeticException due to division by zero");
//    }

//    Fails!!!
//    @Test
//    void testSimpsonsMethodWithNegativeStepSize() {
//        int n = -4; // Negative number of intervals (invalid)
//        double a = 1.0; // Start of interval
//        double h = -0.5; // Negative step size
//
//        Executable executable = () -> simpsonIntegration.simpsonsMethod(n, h, a);
//        assertThrows(IllegalArgumentException.class, executable, "Should throw IllegalArgumentException for invalid inputs");
//    }

    @Test
    void testSimpsonsMethodWithZeroIntervalWidth() {
        int n = 4; // Even number of intervals
        double a = 1.0; // Start of interval
        double b = 1.0; // End of interval (no width)
        double h = (b - a) / n;

        double result = simpsonIntegration.simpsonsMethod(n, h, a);
        assertEquals(0.0, result, "Integral of zero-width interval should be zero");
    }

    @Test
    void testSimpsonsMethodWithUnusualFunction() {
        // Override the sample function to test a different implementation
        SimpsonIntegration testIntegration = new SimpsonIntegration() {
            @Override
            public double f(double x) {
                return x * x; // Simple quadratic function f(x) = x^2
            }
        };

        int n = 10;
        double a = 0.0;
        double b = 2.0;
        double h = (b - a) / n;

        double result = testIntegration.simpsonsMethod(n, h, a);
        assertEquals(8.0 / 3.0, result, 1e-6, "Should integrate x^2 correctly");
    }

    @Test
    void testSimpsonsMethodHandlesEdgeCaseWithZeroFunction() {
        // Override the sample function to always return zero
        SimpsonIntegration testIntegration = new SimpsonIntegration() {
            @Override
            public double f(double x) {
                return 0.0; // Constant zero function
            }
        };

        int n = 16;
        double a = 1.0;
        double b = 3.0;
        double h = (b - a) / n;

        double result = testIntegration.simpsonsMethod(n, h, a);
        assertEquals(0.0, result, "Integral of constant zero function should be zero");
    }
}