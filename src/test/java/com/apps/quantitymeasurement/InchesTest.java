package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InchesTest {

    @Test
    void testEquality_SameValue(){
        Inches inches1= new Inches(26.9);
        Inches inches2= new Inches(26.9);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    void testEquality_DifferentValue(){
        Inches inches1= new Inches(26.9);
        Inches inches2= new Inches(67.9);
        assertFalse(inches1.equals(inches2));
    }

    @Test
    void testEquality_NullComparision(){
        Inches inches1= new Inches(26.9);
        Inches inches2= null;
        assertFalse(inches1.equals(inches2));
    }

    @Test
    void testEquality_NonNumericInput(){
        Inches inches1= new Inches(26.9);
        String inches2 = "26.9inches";
        assertFalse(inches1.equals(inches2));
    }

    @Test
    void testEquality_SameReferences(){
        Inches inches1= new Inches(26.9);
        assertTrue(inches1.equals(inches1));
    }
}
