package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.apps.quantitymeasurement.QuantityMeasurementApp.demonstrateLengthConversion;
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

    //UC5
    @Test
    public void testConversion_FeetToInches(){
        assertEquals(demonstrateLengthConversion(1, LengthUnit.FEET, LengthUnit.INCHES).toString(), String.valueOf(12.0));
    }
    @Test
    public void testConversion_InchesToFeet(){
        assertEquals(demonstrateLengthConversion(24, LengthUnit.INCHES, LengthUnit.FEET).toString(), String.valueOf(2.0));
    }
    @Test
    public void testConversion_YardToInches(){
        assertEquals(demonstrateLengthConversion(1, LengthUnit.YARDS, LengthUnit.INCHES).toString(), String.valueOf(36.0));
    }
    @Test
    public void testConversion_InchesToYard(){
        assertEquals(demonstrateLengthConversion(72, LengthUnit.INCHES, LengthUnit.YARDS).toString(), String.valueOf(2.0));
    }
    @Test
    public void testConversion_CentimetersToInches(){
        assertEquals(demonstrateLengthConversion(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES).toString(), String.valueOf(1.0));
    }
    @Test
    public void testConversion_FeetToYard(){
        assertEquals(demonstrateLengthConversion(6, LengthUnit.FEET, LengthUnit.YARDS).toString(), String.valueOf(2.0));
    }
    @Test
    public void testConversion_RoundTrip_PreservesValue(){
        assertEquals(demonstrateLengthConversion(
                (demonstrateLengthConversion(6, LengthUnit.FEET, LengthUnit.YARDS)).getValue(),
                LengthUnit.YARDS, LengthUnit.FEET).toString(), String.valueOf(6.0));
    }
    @Test
    public void testConversion_ZeroValue(){
        assertEquals(demonstrateLengthConversion(0, LengthUnit.FEET, LengthUnit.INCHES).toString(), String.valueOf(0.0));
    }
    @Test
    public void testConversion_NegativeValue(){
        assertEquals(demonstrateLengthConversion(-1, LengthUnit.FEET, LengthUnit.INCHES).toString(), String.valueOf(-12.0));
    }
    @Test
    public void testConversion_InvalidUnit_Throws(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            demonstrateLengthConversion(5, null, LengthUnit.INCHES);
        });
    }
    @Test
    public void testConversion_NANOrInfinite_Throws(){
        double num = Double.NaN;
        Assertions.assertThrows(RuntimeException.class, () -> {
            demonstrateLengthConversion(num, LengthUnit.YARDS, LengthUnit.INCHES);
        });
    }
    @Test
    public void testConversion_PrecisionTolerance(){
        double epsilon = 1e-6;
        assertEquals( demonstrateLengthConversion(-1, LengthUnit.FEET, LengthUnit.INCHES).toString()
                    , String.valueOf(-12.0),
                String.valueOf(epsilon));
    }

}
