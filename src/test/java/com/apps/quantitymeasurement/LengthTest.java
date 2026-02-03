package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.apps.quantitymeasurement.QuantityMeasurementApp.demonstrateLengthAddition;
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
        assertEquals(new Length(12.0, LengthUnit.INCHES), demonstrateLengthConversion(1, LengthUnit.FEET, LengthUnit.INCHES));
    }
    @Test
    public void testConversion_InchesToFeet(){
        assertEquals(new Length(2.0, LengthUnit.FEET), demonstrateLengthConversion(24, LengthUnit.INCHES, LengthUnit.FEET));
    }
    @Test
    public void testConversion_YardToInches(){
        assertEquals(new Length(36.0, LengthUnit.INCHES), demonstrateLengthConversion(1, LengthUnit.YARDS, LengthUnit.INCHES));
    }
    @Test
    public void testConversion_InchesToYard(){
        assertEquals(new Length(2.0, LengthUnit.YARDS), demonstrateLengthConversion(72, LengthUnit.INCHES, LengthUnit.YARDS));
    }
    @Test
    public void testConversion_CentimetersToInches(){
        assertEquals(new Length(1.0, LengthUnit.INCHES), demonstrateLengthConversion(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES));
    }
    @Test
    public void testConversion_FeetToYard(){
        assertEquals(new Length(2.0, LengthUnit.YARDS), demonstrateLengthConversion(6, LengthUnit.FEET, LengthUnit.YARDS));
    }
    @Test
    public void testConversion_RoundTrip_PreservesValue(){
        assertEquals(6.0, demonstrateLengthConversion(
                (demonstrateLengthConversion(6, LengthUnit.FEET, LengthUnit.YARDS)).getValue(),
                LengthUnit.YARDS, LengthUnit.FEET).getValue());
    }
    @Test
    public void testConversion_ZeroValue(){
        assertEquals(new Length(0.0, LengthUnit.INCHES), demonstrateLengthConversion(0, LengthUnit.FEET, LengthUnit.INCHES));
    }
    @Test
    public void testConversion_NegativeValue(){
        assertEquals(new Length(-12.0, LengthUnit.INCHES), demonstrateLengthConversion(-1, LengthUnit.FEET, LengthUnit.INCHES));
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
        assertEquals(-12.0
                    , demonstrateLengthConversion(-1, LengthUnit.FEET, LengthUnit.INCHES).getValue(),
                epsilon);
    }

    //UC6
    @Test
    public void testAddition_SameUnitFeetPlusFeet(){
        Length length1= new Length(1, LengthUnit.FEET);
        Length length2= new Length(2, LengthUnit.FEET);
        assertEquals(new Length(3.0, LengthUnit.FEET), demonstrateLengthAddition(length1, length2));
    }

    @Test
    public void testAddition_SameUnitInchPlusInch(){
        Length length1= new Length(6, LengthUnit.INCHES);
        Length length2= new Length(6, LengthUnit.INCHES);
        assertEquals(new Length(12.0, LengthUnit.INCHES), demonstrateLengthAddition(length1, length2));
    }

    @Test
    public void testAddition_CrossUnitFeetPlusInch(){
        Length length1= new Length(1, LengthUnit.FEET);
        Length length2= new Length(12, LengthUnit.INCHES);
        assertEquals(new Length(2.0, LengthUnit.FEET), demonstrateLengthAddition(length1, length2));
    }

    @Test
    public void testAddition_CrossUnitInchPlusFeet(){
        Length length1= new Length(12, LengthUnit.INCHES);
        Length length2= new Length(1, LengthUnit.FEET);
        assertEquals(new Length(24.0, LengthUnit.INCHES), demonstrateLengthAddition(length1, length2));
    }

    @Test
    public void testAddition_CrossUnitYardPlusFeet(){
        Length length1= new Length(1, LengthUnit.YARDS);
        Length length2= new Length(3, LengthUnit.FEET);
        assertEquals(new Length(2.0, LengthUnit.YARDS), demonstrateLengthAddition(length1, length2));
    }

    @Test
    public void testAddition_CrossUnitCentimeterPlusInches(){
        double epsilon = 1e-6;
        Length length1= new Length(2.54, LengthUnit.CENTIMETERS);
        Length length2= new Length(1, LengthUnit.INCHES);
        assertEquals(5.08,
                demonstrateLengthAddition(length1, length2).getValue(),
                epsilon);
    }

    @Test
    public void testAddition_Commutative(){
        Length length1= new Length(1, LengthUnit.FEET);
        Length length2= new Length(12, LengthUnit.INCHES);
        assertEquals(demonstrateLengthAddition(length2, length1), demonstrateLengthAddition(length1, length2));
    }

    @Test
    public void testAddition_WithZero(){
        Length length1= new Length(5, LengthUnit.FEET);
        Length length2= new Length(0, LengthUnit.INCHES);
        assertEquals(new Length(5.0, LengthUnit.FEET), demonstrateLengthAddition(length1, length2));
    }

    @Test
    public void testAddition_NegativeValues(){
        Length length1= new Length(5, LengthUnit.FEET);
        Length length2= new Length(-2, LengthUnit.FEET);
        assertEquals(new Length(3.0, LengthUnit.FEET), demonstrateLengthAddition(length1, length2));
    }

    @Test
    public void testAddition_NullSecondOperand(){
        Length length1= new Length(5, LengthUnit.FEET);
        assertThrows(NullPointerException.class, () ->{
            demonstrateLengthAddition(length1, null);
        });
    }

    @Test
    public void testAddition_LargeValues(){
        Length length1= new Length(1e6, LengthUnit.FEET);
        Length length2= new Length(1e6, LengthUnit.FEET);
        assertEquals(new Length(2e6, LengthUnit.FEET), demonstrateLengthAddition(length1, length2));
    }

    @Test
    public void testAddition_SmallValues(){
        double epsilon = 1e-6;
        Length length1= new Length(.01, LengthUnit.FEET);
        Length length2= new Length(.02, LengthUnit.FEET);
        assertEquals(.03, demonstrateLengthAddition(length1, length2).getValue(),
                epsilon
                );
    }

    //UC7
    @Test
    public void testAddition_ExplicitTargetUnit_Feet(){
        Length length1= new Length(1, LengthUnit.FEET);
        Length length2= new Length(12, LengthUnit.INCHES);
        assertEquals(new Length(2, LengthUnit.FEET), demonstrateLengthAddition(length1, length2, LengthUnit.FEET));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches(){
        Length length1= new Length(1, LengthUnit.FEET);
        Length length2= new Length(12, LengthUnit.INCHES);
        assertEquals(new Length(24, LengthUnit.INCHES), demonstrateLengthAddition(length1, length2, LengthUnit.INCHES));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards(){
        double epsilon = 0.1d;
        Length length1= new Length(1, LengthUnit.FEET);
        Length length2= new Length(12, LengthUnit.INCHES);
        assertEquals(0.66, demonstrateLengthAddition(length1, length2, LengthUnit.YARDS).getValue(),
                epsilon);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters(){
        double epsilon = 0.1d;
        Length length1= new Length(1, LengthUnit.INCHES);
        Length length2= new Length(1, LengthUnit.INCHES);
        assertEquals(5.08, demonstrateLengthAddition(length1, length2, LengthUnit.CENTIMETERS).getValue(),
                epsilon);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand(){
        Length length1= new Length(2, LengthUnit.YARDS);
        Length length2= new Length(3, LengthUnit.FEET);
        assertEquals(new Length(3.0, LengthUnit.YARDS), demonstrateLengthAddition(length1, length2, LengthUnit.YARDS));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand(){
        Length length1= new Length(2, LengthUnit.YARDS);
        Length length2= new Length(3, LengthUnit.FEET);
        assertEquals(new Length(9.0, LengthUnit.FEET), demonstrateLengthAddition(length1, length2, LengthUnit.FEET));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutative(){
        Length length1= new Length(1, LengthUnit.FEET);
        Length length2= new Length(12, LengthUnit.INCHES);
        assertEquals(demonstrateLengthAddition(length1, length2, LengthUnit.YARDS),
                demonstrateLengthAddition(length2, length1, LengthUnit.YARDS));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero(){
        double epsilon = 0.1d;
        Length length1= new Length(5, LengthUnit.FEET);
        Length length2= new Length(0, LengthUnit.INCHES);
        assertEquals(1.67, demonstrateLengthAddition(length1, length2, LengthUnit.YARDS).getValue(),
                epsilon);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues(){
        Length length1= new Length(5, LengthUnit.FEET);
        Length length2= new Length(-2.0, LengthUnit.FEET);
        assertEquals(new Length(36.0, LengthUnit.INCHES),demonstrateLengthAddition(length1, length2, LengthUnit.INCHES));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit(){
        Length length1= new Length(1.0, LengthUnit.FEET);
        Length length2= new Length(12.0, LengthUnit.INCHES);
        assertThrows(NullPointerException.class, () ->{
            demonstrateLengthAddition(length1, length2, null);
        });
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale(){
        Length length1= new Length(1000.0, LengthUnit.FEET);
        Length length2= new Length(500.0, LengthUnit.FEET);
        assertEquals(new Length(18000.0, LengthUnit.INCHES),demonstrateLengthAddition(length1, length2, LengthUnit.INCHES));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale(){
        Length length1= new Length(12.0, LengthUnit.INCHES);
        Length length2= new Length(12.0, LengthUnit.INCHES);
        assertEquals(new Length(0.67, LengthUnit.YARDS),demonstrateLengthAddition(length1, length2, LengthUnit.YARDS));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NaN(){
        double nan = Double.NaN;
        Length length1= new Length(nan, LengthUnit.INCHES);
        Length length2= new Length(12.0, LengthUnit.INCHES);
        assertThrows(RuntimeException.class, ()->{
            demonstrateLengthAddition(length1, length2, LengthUnit.YARDS);
        });
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SecondNaN(){
        double nan = Double.NaN;
        Length length1= new Length(12.0, LengthUnit.INCHES);
        Length length2= new Length(nan, LengthUnit.INCHES);
        assertThrows(RuntimeException.class, ()->{
            demonstrateLengthAddition(length1, length2, LengthUnit.YARDS);
        });
    }

}
