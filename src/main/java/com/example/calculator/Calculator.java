// Calculator.java
package com.example.calculator;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    // START-NOSCAN
    public int subtract(int a, int b) {
        return a - b;
    }
    // END-NOSCAN
    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
