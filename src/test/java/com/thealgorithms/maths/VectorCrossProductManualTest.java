package com.thealgorithms.maths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorCrossProductManualTest {
//    private VectorCrossProduct vectorA;
//    private VectorCrossProduct vectorB;
//
//    @BeforeEach
//    void setUp() {
//        vectorA = new VectorCrossProduct(1, -2, 3);
//        vectorB = new VectorCrossProduct(2, 0, 3);
//    }
//
//    @Test
//    void testCrossProduct_ValidVectors() {
//        VectorCrossProduct result = vectorA.crossProduct(vectorB);
//
//        assertEquals(-6, result.x, "X component should be -6");
//        assertEquals(3, result.y, "Y component should be 3");
//        assertEquals(4, result.z, "Z component should be 4");
//    }
//
//    @Test
//    void testCrossProduct_InvalidVectors() {
//        VectorCrossProduct zeroVector = new VectorCrossProduct();
//        VectorCrossProduct result = zeroVector.crossProduct(zeroVector);
//
//        assertEquals(0, result.x, "X component should be -6");
//        assertEquals(0, result.y, "Y component should be 3");
//        assertEquals(0, result.z, "Z component should be 4");
//    }
//
//    @Test
//    void testCrossProduct_LargePositiveVectors() {
//        vectorA.x = Integer.MAX_VALUE;
//        vectorA.y = Integer.MAX_VALUE;
//        vectorA.z = Integer.MAX_VALUE;
//
//        vectorB.x = Integer.MIN_VALUE;
//        vectorB.y = Integer.MIN_VALUE;
//        vectorB.z = Integer.MIN_VALUE;
//
//        VectorCrossProduct result = vectorA.crossProduct(vectorB);
//        result.displayVector();
//
//        assertEquals(0, result.x, "X component should be -6");
//        assertEquals(0, result.y, "Y component should be 3");
//        assertEquals(0, result.z, "Z component should be 4");
//    }

    @Test
    void testCrossProduct() {
        // Test cross product of two 0-vectors
        VectorCrossProduct vector = new VectorCrossProduct(0,0,0);
        VectorCrossProduct result = vector.crossProduct(vector);

        assertEquals(0, result.x, "X component should be 0");
        assertEquals(0, result.y, "Y component should be 0");
        assertEquals(0, result.z, "Z component should be 0");

        // Test cross product of parallel vectors
        vector = new VectorCrossProduct(1,0,0);
        result = vector.crossProduct(vector);

        assertEquals(0, result.x, "X component should be 0");
        assertEquals(0, result.y, "Y component should be 0");
        assertEquals(0, result.z, "Z component should be 0");

        // Test cross product of perpendicular vectors
        VectorCrossProduct vectorB = new VectorCrossProduct(0,1,0);
        result = vector.crossProduct(vectorB);

        assertEquals(0, result.x, "X component should be 0");
        assertEquals(0, result.y, "Y component should be 0");
        assertEquals(1, result.z, "Z component should be 1");

        // Test cross product of opposite vectors (180 degrees between two)
        VectorCrossProduct vectorC = new VectorCrossProduct(0,-1,0);
        result = vectorB.crossProduct(vectorC);

        assertEquals(0, result.x, "X component should be 0");
        assertEquals(0, result.y, "Y component should be 0");
        assertEquals(0, result.z, "Z component should be 0");

        // Test cross product of 2 valid vectors with arbitrary values
        VectorCrossProduct vectorD = new VectorCrossProduct(4,-2,5);
        VectorCrossProduct vectorE = new VectorCrossProduct(-1,6,3);
        result = vectorD.crossProduct(vectorE);

        assertEquals(-36, result.x, "X component should be -36");
        assertEquals(-17, result.y, "Y component should be -17");
        assertEquals(22, result.z, "Z component should be 22");

        // Test cross product of two large vectors
        VectorCrossProduct vectorF = new VectorCrossProduct(Integer.MAX_VALUE,0,0);
        VectorCrossProduct vectorG = new VectorCrossProduct(0,Integer.MAX_VALUE,0);
        result = vectorF.crossProduct(vectorG);

        assertEquals(0, result.x, "X component should be 0");
        assertEquals(0, result.y, "Y component should be 0");
        assertEquals(Integer.MAX_VALUE*Integer.MAX_VALUE, result.z, "Z component should be MAX_VALUE^2");
    }

    @Test
    void testCrossProduct_OtherMethods() {
        VectorCrossProduct vector = new VectorCrossProduct(0,0,0);
        VectorCrossProduct.main(null);
        VectorCrossProduct.test();
        vector.displayVector();
        assertEquals(0, vector.magnitude());
    }
}



// Cross product calculation based on the formula
// x = (y * z) - (z * y)
// y = -((x * z) - (z * x))
// z = (x * y) - (y * x)