package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void testAdd() {
        Example example = new Example();
        assertEquals(5, example.add(2, 3));
    }
    @Test
    public void testAdd() {
        Example example = new Example();
        assertEquals(0, example.add(0, 0));
    }
}
