package com.apps.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class QuantityMeasurementAppTest {

    @Test
    public void test1(){
        Feet feet = new Feet(2.34);
        Feet feet2 = new Feet(2.34);

        boolean actual = feet.equals(feet2);

        assertEquals(actual, true);

    }

    @Test
    public void failureTest(){
        Feet feet = new Feet(2.34);
        Feet feet2 = new Feet(2.38);

        boolean actual = feet.equals(feet2);

        assertEquals(actual, false);

    }

    @Test
    public void failureTestIntWithDouble(){
        Feet feet = new Feet(2.34);
        Feet feet2 = new Feet(2);

        boolean actual = feet.equals(feet2);

        assertEquals(actual, false);

    }

    @Test
    public void instanceTest(){
        Feet feet = new Feet(2.34);
        String feetString = "String Obj";
        assertFalse(feet.equals(feetString), "Different instance");
    }

    @Test
    public void sameReferenceTest(){
        Feet feet = new Feet(2.34);
        assertTrue(feet.equals(feet));
    }
}
