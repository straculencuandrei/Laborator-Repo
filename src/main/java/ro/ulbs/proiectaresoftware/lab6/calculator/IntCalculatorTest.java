package main.java.ro.ulbs.proiectaresoftware.lab6.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntCalculatorTest {
    private IntCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new IntCalculator(10);
    }

    @Test
    @DisplayName("Test add")
    public void testAdd() {
        calculator.add(5);
        assertEquals(15, calculator.result());
    }

    @Test
    @DisplayName("Test subtract")
    public void testSubtract() {
        calculator.subtract(3);
        assertEquals(7, calculator.result());
    }

    @Test
    @DisplayName("Test multiply")
    public void testMultiply() {
        calculator.multiply(2);
        assertEquals(20, calculator.result());
    }

    @Test
    @DisplayName("Test chaining")
    public void testChaining() {
        calculator.add(5).subtract(3).multiply(2);
        assertEquals(24, calculator.result());
    }
}
