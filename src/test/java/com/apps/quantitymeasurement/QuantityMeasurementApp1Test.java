package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static com.apps.quantitymeasurement.QuantityMeasurementApp1.demonstrateAddition;
import static com.apps.quantitymeasurement.QuantityMeasurementApp1.demonstrateConversion;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementApp1Test {

    @Test
    public void testLengthFeetEqualsInches(){
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(120, LengthUnit.INCHES);
        assertTrue(lengthInFeet.equals(lengthInInches));
    }
    @Test
    public void testLengthYardEqualsFeet(){
        Quantity<LengthUnit> lengthInYard = new Quantity<>(10, LengthUnit.YARDS);
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(30, LengthUnit.FEET);
        assertTrue(lengthInYard.equals(lengthInFeet));
    }
    @Test
    public void testWeightKilogramEqualsGrams(){
        Quantity<WeightUnit> weightInKilograms = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInGrams = new Quantity<>(1000, WeightUnit.GRAM);
        assertTrue(weightInKilograms.equals(weightInGrams));
    }
    @Test
    public void testWeightPoundEqualsGrams(){
        Quantity<WeightUnit> weightInPound = new Quantity<>(5, WeightUnit.POUND);
        Quantity<WeightUnit> weightInGrams = new Quantity<>(2267.96, WeightUnit.GRAM);
        assertTrue(weightInPound.equals(weightInGrams));
    }
    @Test
    public void testConvertLengthFeetToInches(){
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        assertEquals(120.00,lengthInFeet.convertTo(LengthUnit.INCHES));
    }
    @Test
    public void testAddLengthFeetAndInches(){
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(120, LengthUnit.INCHES);
        demonstrateAddition(lengthInFeet,lengthInInches,LengthUnit.FEET);
        Quantity<LengthUnit> totalLength = demonstrateAddition(lengthInFeet,lengthInInches,LengthUnit.FEET);
        assertEquals(20.0,totalLength.getValue());
        assertEquals(LengthUnit.FEET,totalLength.getUnit());
        assertEquals(new Quantity<LengthUnit>(20.0, LengthUnit.FEET),totalLength);
    }

    @Test
    public void testAddWeightKilogramsAndGrams(){
        Quantity<WeightUnit> weightInKilogram = new Quantity<>(5, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInGrams = new Quantity<>(1000, WeightUnit.GRAM);
        Quantity<WeightUnit> totalWeight = weightInKilogram.add(weightInGrams);
        assertEquals(6.0,totalWeight.getValue());
        assertEquals(WeightUnit.KILOGRAM,totalWeight.getUnit());
    }

    //Generic Type Safety
    @Test
    public void TestGenericTypeSafetyWithWeight(){

    }

    @Test
    public void testConvertWeightKilogramsToGrams(){
        Quantity<WeightUnit> weightInKilogram = new Quantity<>(5, WeightUnit.KILOGRAM);
        assertEquals(new Quantity<>(5000.00, WeightUnit.GRAM),demonstrateConversion(weightInKilogram, WeightUnit.GRAM));
    }

    @Test
    public void testCddWeightKilogramsAndPounds(){
        double epsilon = 1e6;
        Quantity<WeightUnit> weightInKilogram = new Quantity<>(2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInPound = new Quantity<>(5, WeightUnit.POUND);
        Quantity<WeightUnit> totalWeight = weightInKilogram.add(weightInPound);
        assertEquals(4.26,totalWeight.getValue(), epsilon);
        assertEquals(WeightUnit.KILOGRAM,totalWeight.getUnit());
    }

    @Test
    public void testConvertLengthYardsToInches(){
        Quantity<LengthUnit> lengthInYards = new Quantity<>(5, LengthUnit.YARDS);
        assertEquals(new Quantity<>(180, LengthUnit.INCHES),demonstrateConversion(lengthInYards, LengthUnit.INCHES));
    }


    //Negative test for Cross-Type Operations
    @Test
    public void testPreventCrossTypeComparisonLengthVsWeight(){
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<WeightUnit> weightInKilogram = new Quantity<>(2, WeightUnit.KILOGRAM);
        assertFalse(lengthInFeet.equals(weightInKilogram));
    }


    @Test
    public void testAddLengthYardAndFeet(){
        Quantity<LengthUnit> lengthInYards = new Quantity<>(5, LengthUnit.YARDS);
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> sumLength = lengthInYards.add(lengthInFeet);
        assertEquals(new Quantity<>(8.33, LengthUnit.YARDS), sumLength);
    }

    @Test
    public void testAddLengthYardAndFeetNanThrows(){
        Quantity<LengthUnit> lengthInYards = new Quantity<>(Double.NaN, LengthUnit.YARDS);
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        assertThrows(RuntimeException.class, () -> {
            lengthInYards.add(lengthInFeet);
        });
    }
    @Test
    public void testAddLengthYardAndFeetNullValues(){
        Quantity<LengthUnit> lengthInYards = new Quantity<>(5, LengthUnit.YARDS);
        assertThrows(RuntimeException.class, () -> {
            lengthInYards.add(null);
        });
    }
    @Test
    public void testAddLengthFeetAndYardNullValues(){
        Quantity<LengthUnit> lengthInYards = new Quantity<>(5, LengthUnit.YARDS);
        Quantity<LengthUnit> lengthInFeet = null;
        assertThrows(RuntimeException.class, () -> {
            lengthInFeet.add(lengthInYards);
        });
    }

    @Test
    public void testEqualsLengthSameValues(){
        Quantity<LengthUnit> lengthInYards = new Quantity<>(5, LengthUnit.YARDS);
        Quantity<LengthUnit> lengthInFeet = null;
        assertTrue(lengthInYards.equals(lengthInYards));
    }

    @Test
    public void testEqualsInstance(){
        Quantity<LengthUnit> lengthInYards = new Quantity<>(5, LengthUnit.YARDS);
        Quantity<WeightUnit> weightInKilogram = new Quantity<>(2, WeightUnit.KILOGRAM);
        assertFalse(weightInKilogram.equals(lengthInYards));
    }

    @Test
    public void testEqualsConvertToInstance(){
        Quantity<LengthUnit> lengthInYards = new Quantity<>(5, LengthUnit.YARDS);
        Quantity<WeightUnit> weightInKilogram = new Quantity<>(2, WeightUnit.KILOGRAM);
        assertThrows(IllegalArgumentException.class, () -> {
            lengthInYards.convertTo(WeightUnit.GRAM);
        });
    }

}
