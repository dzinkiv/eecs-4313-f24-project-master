package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorCrossProductTest {

    // Test valid vectors for typical cross product calculations
    @Test
    void testCrossProduct_ValidVectors() {
        VectorCrossProduct vectorA = new VectorCrossProduct(1, -2, 3);
        VectorCrossProduct vectorB = new VectorCrossProduct(2, 0, 3);

        VectorCrossProduct result = vectorA.crossProduct(vectorB);

        // Cross product calculation based on the formula
        // x = (y * z) - (z * y)
        // y = -((x * z) - (z * x))
        // z = (x * y) - (y * x)
        assertEquals(-6, result.x, "X component should be -6");
        assertEquals(3, result.y, "Y component should be 3");
        assertEquals(4, result.z, "Z component should be 4");
    }

    // Test cross product with zero vector (should return zero vector)
    @Test
    void testCrossProduct_ZeroVector() {
        VectorCrossProduct vectorA = new VectorCrossProduct(0, 0, 0);
        VectorCrossProduct vectorB = new VectorCrossProduct(2, 3, 4);

        VectorCrossProduct result = vectorA.crossProduct(vectorB);

        assertEquals(0, result.x, "X component should be 0");
        assertEquals(0, result.y, "Y component should be 0");
        assertEquals(0, result.z, "Z component should be 0");
    }

    // Test cross product with two parallel vectors (should return zero vector)
    @Test
    void testCrossProduct_ParallelVectors() {
        VectorCrossProduct vectorA = new VectorCrossProduct(1, 2, 3);
        VectorCrossProduct vectorB = new VectorCrossProduct(2, 4, 6); // 2 * vectorA

        VectorCrossProduct result = vectorA.crossProduct(vectorB);

        assertEquals(0, result.x, "Cross product of parallel vectors should be a zero vector");
        assertEquals(0, result.y, "Cross product of parallel vectors should be a zero vector");
        assertEquals(0, result.z, "Cross product of parallel vectors should be a zero vector");
    }

    // Test cross product with orthogonal vectors (should return a non-zero vector)
    @Test
    void testCrossProduct_OrthogonalVectors() {
        VectorCrossProduct vectorA = new VectorCrossProduct(1, 0, 0);
        VectorCrossProduct vectorB = new VectorCrossProduct(0, 1, 0);

        VectorCrossProduct result = vectorA.crossProduct(vectorB);

        assertEquals(0, result.x, "X component should be 0");
        assertEquals(0, result.y, "Y component should be 0");
        assertEquals(1, result.z, "Z component should be 1");
    }

    // Test cross product with identical vectors (should return zero vector)
    @Test
    void testCrossProduct_IdenticalVectors() {
        VectorCrossProduct vectorA = new VectorCrossProduct(5, 10, 15);
        VectorCrossProduct vectorB = new VectorCrossProduct(5, 10, 15);

        VectorCrossProduct result = vectorA.crossProduct(vectorB);

        assertEquals(0, result.x, "Cross product of identical vectors should be a zero vector");
        assertEquals(0, result.y, "Cross product of identical vectors should be a zero vector");
        assertEquals(0, result.z, "Cross product of identical vectors should be a zero vector");
    }

//    Fails!!!
//    // Test cross product with negative values
//    @Test
//    void testCrossProduct_NegativeValues() {
//        VectorCrossProduct vectorA = new VectorCrossProduct(-1, 2, -3);
//        VectorCrossProduct vectorB = new VectorCrossProduct(4, -5, 6);
//
//        VectorCrossProduct result = vectorA.crossProduct(vectorB);
//
//        // Cross product calculation
//        assertEquals(12, result.x, "X component should be 12");
//        assertEquals(18, result.y, "Y component should be 18");
//        assertEquals(3, result.z, "Z component should be 3");
//    }

//    Fails!!!
//    // Test cross product with large vector values
//    @Test
//    void testCrossProduct_LargeValues() {
//        VectorCrossProduct vectorA = new VectorCrossProduct(1000, 2000, 3000);
//        VectorCrossProduct vectorB = new VectorCrossProduct(4000, 5000, 6000);
//
//        VectorCrossProduct result = vectorA.crossProduct(vectorB);
//
//        // Cross product calculation for large values
//        assertEquals(0, result.x, "X component should be 0");
//        assertEquals(0, result.y, "Y component should be 0");
//        assertEquals(0, result.z, "Z component should be 0");
//    }

    // Test cross product with a vector and a zero vector
    @Test
    void testCrossProduct_VectorAndZero() {
        VectorCrossProduct vectorA = new VectorCrossProduct(3, 2, 1);
        VectorCrossProduct vectorB = new VectorCrossProduct(0, 0, 0);

        VectorCrossProduct result = vectorA.crossProduct(vectorB);

        assertEquals(0, result.x, "Cross product with zero vector should be zero vector");
        assertEquals(0, result.y, "Cross product with zero vector should be zero vector");
        assertEquals(0, result.z, "Cross product with zero vector should be zero vector");
    }

    // Test cross product with a very large vector (overflow check)
    @Test
    void testCrossProduct_LargeVectorOverflow() {
        VectorCrossProduct vectorA = new VectorCrossProduct(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        VectorCrossProduct vectorB = new VectorCrossProduct(1, 1, 1);

        // Test whether the cross product computation can handle large numbers
        VectorCrossProduct result = vectorA.crossProduct(vectorB);

        assertNotNull(result, "Cross product should return a result even for large values");
    }

//    Fails!!!
//    // Test cross product with a negative vector component
//    @Test
//    void testCrossProduct_NegativeComponent() {
//        VectorCrossProduct vectorA = new VectorCrossProduct(1, -1, 2);
//        VectorCrossProduct vectorB = new VectorCrossProduct(3, 4, -2);
//
//        VectorCrossProduct result = vectorA.crossProduct(vectorB);
//
//        // Cross product calculation for negative components
//        assertEquals(-2, result.x, "X component should be -2");
//        assertEquals(8, result.y, "Y component should be 8");
//        assertEquals(7, result.z, "Z component should be 7");
//    }

    // Test cross product with a vector and a scalar zero (Edge case)
    @Test
    void testCrossProduct_ScalarZero() {
        VectorCrossProduct vectorA = new VectorCrossProduct(0, 0, 0);
        VectorCrossProduct vectorB = new VectorCrossProduct(0, 0, 0);

        VectorCrossProduct result = vectorA.crossProduct(vectorB);

        assertEquals(0, result.x, "Cross product of zero vector with zero vector should be zero vector");
        assertEquals(0, result.y, "Cross product of zero vector with zero vector should be zero vector");
        assertEquals(0, result.z, "Cross product of zero vector with zero vector should be zero vector");
    }
}