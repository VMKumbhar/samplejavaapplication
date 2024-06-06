package com.example;

public class Example {

    // Ignore all issues in this method
    @SuppressWarnings("squid:S00112")
    public void methodWithIgnoredIssues() {
        // Issue: This statement has no effect
        int x = 10; // This statement is just an example and will be ignored by SonarQube
    }

    public int add(int a, int b) {
        return a + b;
    }
}
