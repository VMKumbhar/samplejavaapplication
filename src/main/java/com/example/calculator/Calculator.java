// Calculator.java
package com.example.calculator;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    
    // Ignore all issues in this method
    // START-NOSCAN
    public void methodWithIgnoredIssues() {
        // Issue: This statement has no effect
        int x = 10; // This statement is just an example and will be ignored by SonarQube
    }
    // END-NOSCAN

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
