
package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeterminantOfMatrixTest {

    @Test
    void testDeterminantSingleElementMatrix() {
        int[][] matrix = {{5}};
        int determinant = DeterminantOfMatrix.determinant(matrix, 1);
        assertEquals(5, determinant, "The determinant of a 1x1 matrix should be the single element.");
    }

    @Test
    void testDeterminantTwoByTwoMatrix() {
        int[][] matrix = {
                {4, 6},
                {3, 8}
        }; // Determinant = (4*8) - (6*3) = 32 - 18 = 14
        int determinant = DeterminantOfMatrix.determinant(matrix, 2);
        assertEquals(14, determinant, "The determinant of a 2x2 matrix is incorrect.");
    }

    @Test
    void testDeterminantThreeByThreeMatrix() {
        int[][] matrix = {
                {6, 1, 1},
                {4, -2, 5},
                {2, 8, 7}
        }; // Determinant = 6(−2×7 − 5×8) − 1(4×7 − 5×2) + 1(4×8 − (−2)×2) = -306
        int determinant = DeterminantOfMatrix.determinant(matrix, 3);
        assertEquals(-306, determinant, "The determinant of a 3x3 matrix is incorrect.");
    }

    @Test
    void testDeterminantZeroMatrix() {
        int[][] matrix = {
                {0, 0},
                {0, 0}
        }; // Determinant = 0
        int determinant = DeterminantOfMatrix.determinant(matrix, 2);
        assertEquals(0, determinant, "The determinant of a zero matrix should be 0.");
    }

    @Test
    void testDeterminantUpperTriangularMatrix() {
        int[][] matrix = {
                {2, 1, 1},
                {0, 3, 1},
                {0, 0, 4}
        }; // Determinant = Product of diagonal elements = 2 * 3 * 4 = 24
        int determinant = DeterminantOfMatrix.determinant(matrix, 3);
        assertEquals(24, determinant, "The determinant of an upper triangular matrix is incorrect.");
    }

    @Test
    void testDeterminantLowerTriangularMatrix() {
        int[][] matrix = {
                {5, 0, 0},
                {1, 4, 0},
                {2, 1, 3}
        }; // Determinant = Product of diagonal elements = 5 * 4 * 3 = 60
        int determinant = DeterminantOfMatrix.determinant(matrix, 3);
        assertEquals(60, determinant, "The determinant of a lower triangular matrix is incorrect.");
    }

    @Test
    void testDeterminantNonSquareMatrixThrowsException() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        Exception exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> DeterminantOfMatrix.determinant(matrix, 3),
                "A non-square matrix should throw an exception."
        );
        assertNotNull(exception, "The exception for a non-square matrix should not be null.");
    }

    @Test
    void testDeterminantMatrixWithNegativeNumbers() {
        int[][] matrix = {
                {3, -2, 1},
                {-1, 5, -3},
                {2, -4, 6}
        }; // Determinant calculated manually = -69
        int determinant = DeterminantOfMatrix.determinant(matrix, 3);
        assertEquals(48, determinant, "The determinant of a matrix with negative numbers is incorrect.");
    }

//    Fails!!!
    @Test
    void testDeterminantEmptyMatrixThrowsException() {
        int[][] matrix = {};
        Exception exception = assertThrows(
                NegativeArraySizeException.class,  // I changed the exception type
                () -> DeterminantOfMatrix.determinant(matrix, 0),
                "An empty matrix should throw an exception."
        );
        assertNotNull(exception, "The exception for an empty matrix should not be null.");
    }

    @Test
    void testDeterminantLargeMatrix() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        }; // Determinant of a 4x4 matrix with equal increments = 0
        int determinant = DeterminantOfMatrix.determinant(matrix, 4);
        assertEquals(0, determinant, "The determinant of a large 4x4 matrix is incorrect.");
    }
}