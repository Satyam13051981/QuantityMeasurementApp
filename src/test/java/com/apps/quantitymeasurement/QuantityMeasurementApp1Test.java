package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static com.apps.quantitymeasurement.QuantityMeasurementApp1.demonstrateAddition;
import static com.apps.quantitymeasurement.QuantityMeasurementApp1.demonstrateConversion;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementApp1Test {

    @Test
    public void lengthFeetEqualsInches(){
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(120, LengthUnit.INCHES);
        assertTrue(lengthInFeet.equals(lengthInInches));
    }
    @Test
    public void lengthYardEqualsFeet(){
        Quantity<LengthUnit> lengthInYard = new Quantity<>(10, LengthUnit.YARDS);
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(30, LengthUnit.FEET);
        assertTrue(lengthInYard.equals(lengthInFeet));
    }
    @Test
    public void weightKilogramEqualsGrams(){
        Quantity<WeightUnit> weightInKilograms = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInGrams = new Quantity<>(1000, WeightUnit.GRAM);
        assertTrue(weightInKilograms.equals(weightInGrams));
    }
    @Test
    public void weightPoundEqualsGrams(){
        Quantity<WeightUnit> weightInPound = new Quantity<>(5, WeightUnit.POUND);
        Quantity<WeightUnit> weightInGrams = new Quantity<>(2267.96, WeightUnit.GRAM);
        assertTrue(weightInPound.equals(weightInGrams));
    }
    @Test
    public void convertLengthFeetToInches(){
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        assertEquals(120.00,lengthInFeet.convertTo(LengthUnit.INCHES));
    }
    @Test
    public void addLengthFeetAndInches(){
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(120, LengthUnit.INCHES);
        demonstrateAddition(lengthInFeet,lengthInInches,LengthUnit.FEET);
        Quantity<LengthUnit> totalLength = demonstrateAddition(lengthInFeet,lengthInInches,LengthUnit.FEET);
        assertEquals(20.0,totalLength.getValue());
        assertEquals(LengthUnit.FEET,totalLength.getUnit());
        assertEquals(new Quantity<LengthUnit>(20.0, LengthUnit.FEET),totalLength);
    }

    @Test
    public void addWeightKilogramsAndGrams(){
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
    public void convertWeightKilogramsToGrams(){
        Quantity<WeightUnit> weightInKilogram = new Quantity<>(5, WeightUnit.KILOGRAM);
        assertEquals(new Quantity<>(5000.00, WeightUnit.GRAM),demonstrateConversion(weightInKilogram, WeightUnit.GRAM));
    }

    @Test
    public void addWeightKilogramsAndPounds(){
        double epsilon = 1e6;
        Quantity<WeightUnit> weightInKilogram = new Quantity<>(2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInPound = new Quantity<>(5, WeightUnit.POUND);
        Quantity<WeightUnit> totalWeight = weightInKilogram.add(weightInPound);
        assertEquals(4.26,totalWeight.getValue(), epsilon);
        assertEquals(WeightUnit.KILOGRAM,totalWeight.getUnit());
    }

    @Test
    public void convertLengthYardsToInches(){
        Quantity<LengthUnit> lengthtInYards = new Quantity<>(5, LengthUnit.YARDS);
        assertEquals(new Quantity<>(180, LengthUnit.INCHES),demonstrateConversion(lengthtInYards, LengthUnit.INCHES));
    }


    //Negative test for Cross-Type Operations
    @Test
    public void preventCrossTypeComparisonLengthVsWeight(){
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<WeightUnit> weightInKilogram = new Quantity<>(2, WeightUnit.KILOGRAM);
        assertFalse(lengthInFeet.equals(weightInKilogram));
    }
    @Test
    public void preventCrossTypeAdditionLengthVsWeight(){
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<WeightUnit> weightInKilogram = new Quantity<>(2, WeightUnit.KILOGRAM);
        //demonstrateAddition(lengthInFeet,weightInKilogram);
        assertFalse(lengthInFeet.equals(weightInKilogram));
    }
    @Test
    public void preventCrossTypeComparisonLengthToWeight(){

    }
    @Test
    public void addLengthYardAndFeet(){

    }
    @Test
    public void addWeightTonnesAndKilograms(){

    }

    //Backward compatibility test with previous Implementation
    @Test
    public void backwardCompatibilityLengthFeetEqualsInches(){

    }
    @Test
    public void backwardCompatibilityWeightKilogramsEqualsGrams(){

    }
    @Test
    public void backwardCompatibilityConvertLengthFeetToInches(){

    }
    @Test
    public void backwardCompatibilityWeightKilogramsToGrams(){

    }
    @Test
    public void backwardCompatibilityAddLengthInSameUnit(){

    }
    @Test
    public void backwardCompatibilityAddWeightInSameUnit(){

    }
    @Test
    public void backwardCompatibilityLengthYardEqualsFeet(){

    }
    @Test
    public void backwardCompatibilityWeightPoundEqualsGram(){

    }
    @Test
    public void backwardCompatibilityChainedAdditionsLength(){

    }

}
