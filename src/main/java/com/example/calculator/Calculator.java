// Calculator.java
package com.example.calculator;

public class Calculator {
    
    // Ignore all issues in this method
    @SuppressWarnings("squid:S1854")
    public void methodWithIgnoredIssues() {
        // Issue: This statement has no effect
        int x = 10; // This statement is just an example and will be ignored by SonarQube
    }
    
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

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
