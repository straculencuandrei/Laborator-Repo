package main.java.ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleCalculatorTest {
    private DoubleCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new DoubleCalculator();
        calculator.init();
    }

    @Test
    @DisplayName("Test add")
    public void testAdd() {
        calculator.add(10.0).add(5.0);
        assertEquals(15.0, calculator.result(), 0.001);
    }

    @Test
    @DisplayName("Test subtract")
    public void testSubtract() {
        calculator.add(10.0).subtract(3.3);
        assertEquals(6.7, calculator.result(), 0.001);
    }

    @Test
    @DisplayName("Test multiply")
    public void testMultiply() {
        calculator.add(5.0).multiply(2.2);
        assertEquals(11.0, calculator.result(), 0.001);
    }

    @Test
    @DisplayName("Test divide")
    public void testDivide() {
        calculator.add(10.0).divide(3.0);
        assertEquals(3.333, calculator.result(), 0.001);
    }

    @Test
    @DisplayName("Test chaining")
    public void testChaining() {
        calculator.add(10.0).add(5.0).subtract(3.3).multiply(2.2).divide(3.0);
        // (10 + 5 - 3.3) * 2.2 / 3 = 11.7 * 2.2 / 3 = 25.74 / 3 = 8.58
        assertEquals(8.58, calculator.result(), 0.001);
    }
}
