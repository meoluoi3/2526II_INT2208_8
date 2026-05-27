package BTVNTesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    public void testInvalidInput() {
        assertEquals("Invalid Input", Triangle.classify(50, 0, 50));
        assertEquals("Invalid Input", Triangle.classify(50, 50, 0));
        assertEquals("Invalid Input", Triangle.classify(0, 50, 50));
        assertEquals("Invalid Input", Triangle.classify(50, 50, 101));
        assertEquals("Invalid Input", Triangle.classify(50, 101, 50));
        assertEquals("Invalid Input", Triangle.classify(101, 50, 50));
    }

    @Test
    public void testNotATriangle() {
        assertEquals("Not a Triangle", Triangle.classify(1, 2, 3));
        assertEquals("Not a Triangle", Triangle.classify(2, 3, 1));
        assertEquals("Not a Triangle", Triangle.classify(3, 2, 1));
    }

    @Test
    public void testEquilateral() {
        assertEquals("Equilateral", Triangle.classify(1, 1, 1));
        assertEquals("Equilateral", Triangle.classify(50, 50, 50));
        assertEquals("Equilateral", Triangle.classify(100, 100, 100));
    }

    @Test
    public void testIsosceles() {
        assertEquals("Isosceles", Triangle.classify(50, 50, 75));
        assertEquals("Isosceles", Triangle.classify(50, 75, 50));
        assertEquals("Isosceles", Triangle.classify(75, 50, 50));
        assertEquals("Isosceles", Triangle.classify(2, 2, 3));
        assertEquals("Isosceles", Triangle.classify(2, 3, 2));
        assertEquals("Isosceles", Triangle.classify(3, 2, 2));
    }

    @Test
    public void testScalene() {
        assertEquals("Scalene", Triangle.classify(2, 3, 4));
        assertEquals("Scalene", Triangle.classify(98, 99, 100));
        assertEquals("Scalene", Triangle.classify(49, 50, 51));
    }
}