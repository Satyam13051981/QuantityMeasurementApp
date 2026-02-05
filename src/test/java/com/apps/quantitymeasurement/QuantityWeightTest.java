package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static com.apps.quantitymeasurement.QuantityMeasurementApp.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityWeightTest {

    @Test
    public void testEquality_KilogramToKilogram_SameValue(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(weight1.equals(weight2));
    }

    @Test
    public void testEquality_KilogramToKilogram_DifferentValue(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(2.0, WeightUnit.KILOGRAM);
        assertFalse(weight1.equals(weight2));
    }

    @Test
    public void testEquality_KilogramToGram_EquivalentValue(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertTrue(weight1.equals(weight2));
    }

    @Test
    public void testEquality_GramToKilogram_EquivalentValue(){
        QuantityWeight weight1= new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight weight2= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(weight1.equals(weight2));
    }

    @Test
    public void testEquality_NullComparison(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertFalse(weight1.equals(null));
    }

    @Test
    public void testEquality_SameReference(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(weight1.equals(weight1));
    }

    @Test
    public void testEquality_TransitiveProperty(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight weight3= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(weight1.equals(weight2));
        assertTrue(weight2.equals(weight3));
        assertTrue(weight1.equals(weight3));
    }

    @Test
    public void testEquality_ZeroValue(){
        QuantityWeight weight1= new QuantityWeight(0.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(0.0, WeightUnit.GRAM);
        assertTrue(weight1.equals(weight2));
    }

    @Test
    public void testEquality_NegativeValue(){
        QuantityWeight weight1= new QuantityWeight(-1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(-1000.0, WeightUnit.GRAM);
        assertTrue(weight1.equals(weight2));
    }

    @Test
    public void testEquality_LargeWeightValue(){
        QuantityWeight weight1= new QuantityWeight(1000000.0, WeightUnit.GRAM);
        QuantityWeight weight2= new QuantityWeight(1000.0, WeightUnit.KILOGRAM);
        assertTrue(weight1.equals(weight2));
    }

    @Test
    public void testEquality_SmallWeightValue(){
        QuantityWeight weight1= new QuantityWeight(0.001, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(1.0, WeightUnit.GRAM);
        assertTrue(weight1.equals(weight2));
    }

    @Test
    public void testConversion_PoundToKilogram(){
        QuantityWeight weight1= new QuantityWeight(2.20462, WeightUnit.POUND);
        assertEquals(weight1, demonstrateWeightConversion(weight1, WeightUnit.KILOGRAM));
    }

    @Test
    public void testEquality_KilogramToPound(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertEquals(weight1, demonstrateWeightConversion(weight1, WeightUnit.POUND));
    }

    @Test
    public void testConversion_SameUnit(){
        QuantityWeight weight1= new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        assertEquals(weight1, demonstrateWeightConversion(weight1, WeightUnit.KILOGRAM));
    }

    @Test
    public void testConversion_ZeroValue(){
        QuantityWeight weight1= new QuantityWeight(0.0, WeightUnit.KILOGRAM);
        assertEquals(weight1, demonstrateWeightConversion(weight1, WeightUnit.GRAM));
    }

    @Test
    public void testConversion_NegativeValue(){
        QuantityWeight weight1= new QuantityWeight(-1.0, WeightUnit.KILOGRAM);
        assertEquals(weight1, demonstrateWeightConversion(weight1, WeightUnit.GRAM));
    }

    @Test
    public void testConversion_RoundTrip(){
        QuantityWeight weight1= new QuantityWeight(1.5, WeightUnit.KILOGRAM);
        assertEquals(weight1, demonstrateWeightConversion(weight1, WeightUnit.GRAM).convertTo(WeightUnit.KILOGRAM));
    }

    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(2.0, WeightUnit.KILOGRAM);
        assertEquals(new QuantityWeight(3.0, WeightUnit.KILOGRAM), demonstrateWeightAddition(weight1, weight2));
    }

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(2000.0, WeightUnit.GRAM);
        assertEquals(new QuantityWeight(3.0, WeightUnit.KILOGRAM), demonstrateWeightAddition(weight1, weight2));
    }

    @Test
    public void testWeightUnitEnum_InchesConstant(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(2000.0, WeightUnit.GRAM);
        assertEquals(new QuantityWeight(3.0, WeightUnit.KILOGRAM), demonstrateWeightAddition(weight1, weight2));
    }

    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram(){
        QuantityWeight weight1= new QuantityWeight(2.20462, WeightUnit.POUND);
        QuantityWeight weight2= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertEquals(new QuantityWeight(4.40924, WeightUnit.POUND), demonstrateWeightAddition(weight1, weight2));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(new QuantityWeight(2000.0, WeightUnit.GRAM), demonstrateWeightAddition(weight1, weight2, WeightUnit.GRAM));
    }

    @Test
    public void testAddition_Commutativity(){
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(demonstrateWeightAddition(weight2, weight1), demonstrateWeightAddition(weight1, weight2));
    }

    @Test
    public void testAddition_WithZero(){
        QuantityWeight weight1= new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(0.0, WeightUnit.GRAM);
        assertEquals(new QuantityWeight(5.0, WeightUnit.KILOGRAM), demonstrateWeightAddition(weight1, weight2));
    }

    @Test
    public void testAddition_NegativeValues(){
        QuantityWeight weight1= new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(-2000.0, WeightUnit.GRAM);
        assertEquals(new QuantityWeight(3.0, WeightUnit.KILOGRAM), demonstrateWeightAddition(weight1, weight2));
    }

    @Test
    public void testAddition_LargeValues(){
        QuantityWeight weight1= new QuantityWeight(1e6, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(1e6, WeightUnit.KILOGRAM);
        assertEquals(new QuantityWeight(2e6, WeightUnit.KILOGRAM), demonstrateWeightAddition(weight1, weight2));
    }
}
