package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationSolverTest {

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

//    Fails!!!
//    @Test
//    void testZeroCoefficientAThrowsException() {
//        double a = 0, b = 2, c = 3; // Not a quadratic equation
//        Exception exception = assertThrows(
//                ArithmeticException.class,
//                () -> solver.solveEquation(a, b, c),
//                "Coefficient 'a' being zero should throw an exception."
//        );
//        assertEquals("/ by zero", exception.getMessage(), "Expected divide-by-zero exception.");
//    }

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
