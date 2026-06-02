package main.java.ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewIntCalculatorTest {
    private NewIntCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new NewIntCalculator();
        calculator.init();
    }

    @Test
    @DisplayName("Test add")
    public void testAdd() {
        calculator.add(10).add(5);
        assertEquals(15, calculator.result());
    }

    @Test
    @DisplayName("Test subtract")
    public void testSubtract() {
        calculator.add(10).subtract(3);
        assertEquals(7, calculator.result());
    }

    @Test
    @DisplayName("Test multiply")
    public void testMultiply() {
        calculator.add(5).multiply(2);
        assertEquals(10, calculator.result());
    }

    @Test
    @DisplayName("Test divide")
    public void testDivide() {
        calculator.add(10).divide(2);
        assertEquals(5, calculator.result());
    }

    @Test
    @DisplayName("Test chaining")
    public void testChaining() {
        calculator.add(10).add(5).subtract(3).multiply(2).divide(3);
        assertEquals(8, calculator.result());
    }
}
