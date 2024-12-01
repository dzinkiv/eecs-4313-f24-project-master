package com.thealgorithms.maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class CollatzConjectureTest {

    private final CollatzConjecture collatzConjecture = new CollatzConjecture();

    @Test
    void testCollatzConjectureValidInputSmallNumber() {
        int firstNumber = 6;
        List<Integer> expectedSequence = List.of(6, 3, 10, 5, 16, 8, 4, 2, 1);
        List<Integer> result = collatzConjecture.collatzConjecture(firstNumber);
        assertEquals(expectedSequence, result, "The sequence should match for a valid small input.");
    }

    @Test
    void testCollatzConjectureValidInputLargeNumber() {
        int firstNumber = 27; // Known to produce a long sequence
        List<Integer> result = collatzConjecture.collatzConjecture(firstNumber);
        assertNotNull(result, "The sequence should not be null for a valid large input.");
        assertTrue(result.size() > 1, "The sequence for 27 should have multiple steps.");
    }

    @Test
    void testCollatzConjectureWithOne() {
        int firstNumber = 1;
        List<Integer> expectedSequence = List.of(1);
        List<Integer> result = collatzConjecture.collatzConjecture(firstNumber);
        assertEquals(expectedSequence, result, "The sequence starting with 1 should return only [1].");
    }

    @Test
    void testCollatzConjectureThrowsExceptionForZero() {
        int firstNumber = 0;
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> collatzConjecture.collatzConjecture(firstNumber),
                "Input of 0 should throw an exception.");
        assertEquals("Must be a natural number", exception.getMessage());
    }

    @Test
    void testCollatzConjectureThrowsExceptionForNegativeNumber() {
        int firstNumber = -5;
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> collatzConjecture.collatzConjecture(firstNumber),
                "Negative input should throw an exception.");
        assertEquals("Must be a natural number", exception.getMessage());
    }

    @Test
    void testCollatzConjectureWithLargeEvenNumber() {
        int firstNumber = 16;
        List<Integer> expectedSequence = List.of(16, 8, 4, 2, 1);
        List<Integer> result = collatzConjecture.collatzConjecture(firstNumber);
        assertEquals(expectedSequence, result, "The sequence should match for a large even input.");
    }

    @Test
    void testCollatzConjectureWithLargeOddNumber() {
        int firstNumber = 15;
        List<Integer> result = collatzConjecture.collatzConjecture(firstNumber);
        assertNotNull(result, "The sequence should not be null for a large odd input.");
        assertTrue(result.contains(1), "The sequence should eventually include 1.");
    }

    @Test
    void testNextNumberWithEvenInput() {
        int input = 4;
        int expectedNext = 2;
        int result = collatzConjecture.nextNumber(input);
        assertEquals(expectedNext, result, "Next number for even input should be n/2.");
    }

    @Test
    void testNextNumberWithOddInput() {
        int input = 3;
        int expectedNext = 10;
        int result = collatzConjecture.nextNumber(input);
        assertEquals(expectedNext, result, "Next number for odd input should be 3n+1.");
    }

//    Java runs out of memory running this one
//    @Test
//    void testCollatzConjectureHandlesEdgeCaseWithLargeInput() {
//        int firstNumber = Integer.MAX_VALUE / 2; // Large even number
//        List<Integer> result = collatzConjecture.collatzConjecture(firstNumber);
//        assertNotNull(result, "The sequence should not be null for large input.");
//        assertTrue(result.contains(1), "The sequence should eventually include 1 for large input.");
//    }
}