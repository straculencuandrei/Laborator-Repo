package main.java.ro.ulbs.proiectaresoftware.lab6.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdvancedCalculatorTest {
    private AdvancedCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new AdvancedCalculator(10);
    }

    @Test
    @DisplayName("Test divide")
    public void testDivide() {
        calculator.divide(2);
        assertEquals(5, calculator.result());
    }

    @Test
    @DisplayName("Test root")
    public void testRoot() {
        calculator = new AdvancedCalculator(64);
        calculator.root(2);
        assertEquals(8, calculator.result());
    }

    @Test
    @DisplayName("Test chaining with advanced operations")
    public void testChaining() {
        calculator.add(5).subtract(3).multiply(2).add(3).root(3);
        // (10 + 5 - 3) * 2 + 3 = 12 * 2 + 3 = 27. root(27, 3) = 3
        assertEquals(3, calculator.result());
    }
}
