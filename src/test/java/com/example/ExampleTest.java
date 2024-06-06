package com.example;

import org.junit.Test;
import org.junit.Assert
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void testAdd() {
        Example example = new Example();
        assertEquals(5, example.add(2, 3));
    }
     @Test
    public void testAddnegative() {
        Example example = new Example();
        Assert.assertNotEquals(5, example.add(3, 3));
    }
}
