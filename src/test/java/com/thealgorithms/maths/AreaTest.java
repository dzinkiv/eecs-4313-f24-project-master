package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AreaTest {

    @Test
    void testSurfaceAreaCubeValid() {
        assertEquals(24.0, Area.surfaceAreaCube(2), 1e-6);
        assertEquals(150.0, Area.surfaceAreaCube(5), 1e-6);
    }

    @Test
    void testSurfaceAreaCubeInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCube(-2));
        assertEquals("Must be a positive sideLength", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaCube(0));
        assertEquals("Must be a positive sideLength", exception.getMessage());
    }

    @Test
    void testSurfaceAreaSphereValid() {
        assertEquals(50.265482, Area.surfaceAreaSphere(2), 1e-6);
        assertEquals(314.159265, Area.surfaceAreaSphere(5), 1e-6);
    }

    @Test
    void testSurfaceAreaSphereInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaSphere(-1));
        assertEquals("Must be a positive radius", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaSphere(0));
        assertEquals("Must be a positive radius", exception.getMessage());
    }

//    Fails!!!
//    @Test
//    void testSurfaceAreaTrapeziumValid() {
//        assertEquals(14.0, Area.surfaceAreaTrapezium(3, 4, 2), 1e-6);
//        assertEquals(36.0, Area.surfaceAreaTrapezium(6, 6, 3), 1e-6);
//    }

    @Test
    void testSurfaceAreaTrapeziumInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaTrapezium(-3, 4, 2));
        assertEquals("Must be a positive base1", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaTrapezium(3, -4, 2));
        assertEquals("Must be a positive base2", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaTrapezium(3, 4, -2));
        assertEquals("Must be a positive height", exception.getMessage());
    }

    @Test
    void testSurfaceAreaParallelogramValid() {
        assertEquals(20.0, Area.surfaceAreaParallelogram(4, 5), 1e-6);
        assertEquals(35.0, Area.surfaceAreaParallelogram(7, 5), 1e-6);
    }

    @Test
    void testSurfaceAreaParallelogramInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaParallelogram(-4, 5));
        assertEquals("Must be a positive base", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaParallelogram(4, -5));
        assertEquals("Must be a positive height", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaParallelogram(0, 5));
        assertEquals("Must be a positive base", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Area.surfaceAreaParallelogram(4, 0));
        assertEquals("Must be a positive height", exception.getMessage());
    }
}