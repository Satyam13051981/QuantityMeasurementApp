package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {

    @Test
    public void testEquality_FeetToFeet_SameValue(){
        Length l1= new Length(12.0, LengthUnit.FEET);
        Length l2= new Length(12.0, LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_InchToInch_SameValue(){
        Length l1= new Length(5.0, LengthUnit.INCHES);
        Length l2= new Length(5.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_NullComparison(){
        Length l1= new Length(12.0, LengthUnit.INCHES);
        Length l2= new Length(1.0, LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue(){
        Length l1= new Length(12.0, LengthUnit.INCHES);
        Length l2= new Length(1.0, LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue(){
        Length l1= new Length(2.0, LengthUnit.INCHES);
        Length l2= new Length(1.0, LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testEquality_InchToInch_DifferentValue(){
        Length l1= new Length(2.0, LengthUnit.INCHES);
        Length l2= new Length(1.0, LengthUnit.INCHES);
        assertFalse(l1.equals(l2));
    }

    @Test
    void testExpectedExceptionWithParentType() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("One");
        });
    }

    @Test
    public void testEquality_InvalidUnit(){
        Length l1= new Length(2.0, null);
        Length l2= new Length(1.0, LengthUnit.INCHES);
        Assertions.assertThrows(NullPointerException.class, () -> {
            l1.equals(l2);
        });
    }

    @Test
    public void testEquality_SameReference(){
        Length l1= new Length(2.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l1));
    }

    @Test
    public void testEquality_NullComaparison(){
        Length l1= new Length(1.0, LengthUnit.INCHES);
        assertFalse(l1.equals(null));
    }

    //Use case 5

    @Test
    public void testEquality_YardToYard_SameValue(){
        Length l1= new Length(1.0, LengthUnit.YARDS);
        Length l2= new Length(1.0, LengthUnit.YARDS);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_YardToYard_DifferentValue(){
        Length l1= new Length(1.0, LengthUnit.YARDS);
        Length l2= new Length(2.0, LengthUnit.YARDS);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue(){
        Length l1= new Length(1.0, LengthUnit.YARDS);
        Length l2= new Length(3.0, LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue(){
        Length l1= new Length(3.0, LengthUnit.FEET);
        Length l2= new Length(1.0, LengthUnit.YARDS);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue(){
        Length l1= new Length(1.0, LengthUnit.YARDS);
        Length l2= new Length(36.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue(){
        Length l1= new Length(36.0, LengthUnit.INCHES);
        Length l2= new Length(1.0, LengthUnit.YARDS);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue(){
        Length l1= new Length(1.0, LengthUnit.YARDS);
        Length l2= new Length(2.0, LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue(){
        Length l1= new Length(1.0, LengthUnit.CENTIMETERS);
        Length l2= new Length(0.393701, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue(){
        Length l1= new Length(1.0, LengthUnit.CENTIMETERS);
        Length l2= new Length(1.0, LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty(){
        Length l1= new Length(1.0, LengthUnit.YARDS);
        Length l2= new Length(3.0, LengthUnit.FEET);
        Length l3= new Length(36.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
        assertTrue(l2.equals(l3));
        assertTrue(l3.equals(l1));
    }

    @Test
    public void testEquality_YardWithNullUnit(){
        Length l1= new Length(2.0, null);
        Length l2= new Length(1.0, LengthUnit.YARDS);
        Assertions.assertThrows(NullPointerException.class, () -> {
            l1.equals(l2);
        });
    }

    @Test
    public void testEquality_YardSameReference(){
        Length l1= new Length(1.0, LengthUnit.YARDS);
        assertTrue(l1.equals(l1));
    }

    @Test
    public void testEquality_CentimetersWithNullUnit(){
        Length l1= new Length(2.0, null);
        Length l2= new Length(1.0, LengthUnit.CENTIMETERS);
        Assertions.assertThrows(NullPointerException.class, () -> {
            l1.equals(l2);
        });
    }

    @Test
    public void testEquality_CentimetersSameReference(){
        Length l1= new Length(1.0, LengthUnit.CENTIMETERS);
        assertTrue(l1.equals(l1));
    }

    @Test
    public void testEquality_CentimetersNullComparisons(){
        Length l1= new Length(1.0, LengthUnit.CENTIMETERS);
        assertFalse(l1.equals(null));
    }

    @Test
    public void testEquality_AlUnits_ComplexScenario(){
        Length l1= new Length(2.0, LengthUnit.YARDS);
        Length l2= new Length(6.0, LengthUnit.FEET);
        Length l3= new Length(72.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
        assertTrue(l2.equals(l3));
    }

}
