package com.example.calc;

import java.math.BigInteger;

public class Calculator {

    public double sqrt(double x) {
        if (x < 0) throw new IllegalArgumentException("Square root of negative number");
        return Math.sqrt(x);
    }

    // Factorial using BigInteger up to non-negative integers
    public BigInteger factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial of negative number");
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Natural logarithm ln(x)
    public double ln(double x) {
        if (x <= 0) throw new IllegalArgumentException("ln(x) domain is x>0");
        return Math.log(x);
    }

    // Power x^b
    public double power(double x, double b) {
        // Java Math.pow handles many cases; check edge cases if needed
        return Math.pow(x, b);
    }
}

