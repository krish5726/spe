package com.example.calc;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testSqrt() {
        assertEquals(2.0, calc.sqrt(4.0), 1e-9);
        assertEquals(0.0, calc.sqrt(0.0), 1e-9);
        assertThrows(IllegalArgumentException.class, () -> calc.sqrt(-1.0));
    }

    @Test
    void testFactorial() {
        assertEquals(BigInteger.ONE, calc.factorial(0));
        assertEquals(BigInteger.valueOf(1), calc.factorial(1));
        assertEquals(BigInteger.valueOf(120), calc.factorial(5));
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(-3));
    }

    @Test
    void testLn() {
        assertEquals(0.0, calc.ln(1.0), 1e-9);
        assertTrue(calc.ln(Math.E) >= 0.999 && calc.ln(Math.E) <= 1.001);
        assertThrows(IllegalArgumentException.class, () -> calc.ln(0.0));
        assertThrows(IllegalArgumentException.class, () -> calc.ln(-1.0));
    }

    @Test
    void testPower() {
        assertEquals(8.0, calc.power(2.0,3.0), 1e-9);
        assertEquals(1.0, calc.power(5.0, 0.0), 1e-9);
        assertEquals(0.25, calc.power(2.0, -2.0), 1e-9);
    }
}
