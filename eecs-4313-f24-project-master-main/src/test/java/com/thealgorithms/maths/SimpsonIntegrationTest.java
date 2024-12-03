
package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class SimpsonIntegrationTest {

    private final SimpsonIntegration simpsonIntegration = new SimpsonIntegration();






//    Fails!!!
    @Test
    void testSimpsonsMethodWithNegativeStepSize() {
        int n = -4; // Negative number of intervals (invalid)
        double a = 1.0; // Start of interval
        double h = -0.5; // Negative step size

        Executable executable = () -> simpsonIntegration.simpsonsMethod(n, h, a);
        assertThrows(IllegalArgumentException.class, executable, "Should throw IllegalArgumentException for invalid inputs");
    }

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
	
/*
 * Mine
 * 
 * */
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
    
   
    
    


}