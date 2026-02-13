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
        assertThrows(IllegalArgumentException.class, () -> {
            lengthInYards.convertTo(WeightUnit.GRAM);
        });
    }

    //UC 11 Test cases

    @Test
    void testEquality_LitreToLitre_SameValue(){
        Quantity<VolumeUnit> VolumeInLitres1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> VolumeInLitres2 = new Quantity<>(1, VolumeUnit.LITRE);
        assertTrue(VolumeInLitres1.equals(VolumeInLitres2));
    }
    @Test
    void testEquality_LitreToLitre_DifferentValue(){
        Quantity<VolumeUnit> VolumeInLitres1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> VolumeInLitres2 = new Quantity<>(2, VolumeUnit.LITRE);
        assertFalse(VolumeInLitres1.equals(VolumeInLitres2));
    }
    @Test
    void testEquality_LitreToMillilitre_EquivalentValue(){
        Quantity<VolumeUnit> VolumeInLitres = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> VolumeInMillilitres = new Quantity<>(1000, VolumeUnit.MILLILITRE);
        assertTrue(VolumeInLitres.equals(VolumeInMillilitres));
    }
    @Test
    void testEquality_MillilitreToLitre_EquivalentValue(){
        Quantity<VolumeUnit> VolumeInLitres = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> VolumeInMillilitres = new Quantity<>(1000, VolumeUnit.MILLILITRE);
        assertTrue(VolumeInMillilitres.equals(VolumeInLitres));
    }
    @Test
    void testEquality_LitreToGallon_EquivalentValue(){
        Quantity<VolumeUnit> VolumeInLitres = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> VolumeInGallon = new Quantity<>(0.264172, VolumeUnit.GALLON);
        assertTrue(VolumeInLitres.equals(VolumeInGallon));
    }
    @Test
    void testEquality_GallonToLitre_EquivalentValue(){
        Quantity<VolumeUnit> VolumeInGallon = new Quantity<>(1, VolumeUnit.GALLON);
        Quantity<VolumeUnit> VolumeInLitres = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertTrue(VolumeInGallon.equals(VolumeInLitres));
    }
    @Test
    void testEquality_VolumeVsLength_Incompatible(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<LengthUnit> LengthInFeet = new Quantity<>(1, LengthUnit.FEET);
        assertFalse(VolumeInLitre.equals(LengthInFeet));
    }
    @Test
    void testEquality_VolumeVsWeight_Incompatible(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<WeightUnit> WeightInKilogram = new Quantity<>(1, WeightUnit.KILOGRAM);
        assertFalse(VolumeInLitre.equals(WeightInKilogram));
    }
    @Test
    void testEquality_NullComparison(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(1, VolumeUnit.LITRE);
        assertFalse(VolumeInLitre.equals(null));
    }
    @Test
    void testEquality_SameReference(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(1, VolumeUnit.LITRE);
        assertTrue(VolumeInLitre.equals(VolumeInLitre));
    }
    @Test
    void testEquality_NullUnit(){
        assertThrows(IllegalArgumentException.class, () ->{
            Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(1, null);
        });
    }
    @Test
    void testEquality_TransitiveProperty(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> VolumeInMillilitres = new Quantity<>(1000, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> VolumeInLitre1 = new Quantity<>(1, VolumeUnit.LITRE);
        assertTrue(VolumeInLitre.equals(VolumeInMillilitres));
        assertTrue(VolumeInMillilitres.equals(VolumeInLitre1));
        assertTrue(VolumeInLitre.equals(VolumeInLitre1));
    }
    @Test
    void testEquality_ZeroValue(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> VolumeInMillilitres = new Quantity<>(0, VolumeUnit.MILLILITRE);
        assertTrue(VolumeInLitre.equals(VolumeInMillilitres));
    }
    @Test
    void testEquality_NegativeVolume(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> VolumeInMillilitres = new Quantity<>(0, VolumeUnit.MILLILITRE);
        assertTrue(VolumeInLitre.equals(VolumeInMillilitres));
    }
    @Test
    void testEquality_LargeVolumeValue(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(1000, VolumeUnit.LITRE);
        Quantity<VolumeUnit> VolumeInMillilitres = new Quantity<>(1000000, VolumeUnit.MILLILITRE);
        assertTrue(VolumeInLitre.equals(VolumeInMillilitres));
    }
    @Test
    void testEquality_SmallVolumeValue(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> VolumeInMillilitres = new Quantity<>(1, VolumeUnit.MILLILITRE);
        assertTrue(VolumeInLitre.equals(VolumeInMillilitres));
    }
    @Test
    void testConversion_LitreToMillilitre(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals(new Quantity<>(1000, VolumeUnit.MILLILITRE),demonstrateConversion(VolumeInLitre, VolumeUnit.MILLILITRE));
    }
    @Test
    void testConversion_MillilitreToLitre(){
        Quantity<VolumeUnit> VolumeInMillilitres = new Quantity<>(1000, VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(1, VolumeUnit.LITRE),demonstrateConversion(VolumeInMillilitres, VolumeUnit.LITRE));
    }
    @Test
    void testConversion_GallonToLitre(){
        Quantity<VolumeUnit> VolumeInGallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        assertEquals(new Quantity<>(3.78541, VolumeUnit.LITRE),demonstrateConversion(VolumeInGallon, VolumeUnit.LITRE));
    }
    @Test
    void testConversion_LitreToGallon(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertEquals(new Quantity<>(1, VolumeUnit.GALLON),demonstrateConversion(VolumeInLitre, VolumeUnit.GALLON));
    }
    @Test
    void testConversion_MillilitreToGallon(){
        Quantity<VolumeUnit> VolumeInMillilitre = new Quantity<>(1000, VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(0.26, VolumeUnit.GALLON),demonstrateConversion(VolumeInMillilitre, VolumeUnit.GALLON));
    }
    @Test
    void testConversion_SameUnit(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(5, VolumeUnit.LITRE);
        assertEquals(new Quantity<>(5, VolumeUnit.LITRE),demonstrateConversion(VolumeInLitre, VolumeUnit.LITRE));
    }
    @Test
    void testConversion_ZeroValue(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(0, VolumeUnit.LITRE);
        assertEquals(new Quantity<>(0, VolumeUnit.MILLILITRE),demonstrateConversion(VolumeInLitre, VolumeUnit.MILLILITRE));
    }
    @Test
    void testConversion_NegativeValue(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(-1.0, VolumeUnit.LITRE);
        assertEquals(new Quantity<>(-1000.0, VolumeUnit.MILLILITRE),demonstrateConversion(VolumeInLitre, VolumeUnit.MILLILITRE));
    }
    @Test
    void testConversion_RoundTrip(){
        Quantity<VolumeUnit> VolumeInLitre = new Quantity<>(1.5, VolumeUnit.LITRE);
        Quantity<VolumeUnit> VolumeInMillilitre = demonstrateConversion(VolumeInLitre,VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> convertToLitre = demonstrateConversion(VolumeInMillilitre,VolumeUnit.MILLILITRE);
        assertEquals(VolumeInLitre,convertToLitre);
    }
    @Test
    void testAddition_SameUnit_LitrePlusLitre(){
        Quantity<VolumeUnit> value1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sumOfValue = demonstrateAddition(value1,value2);
        assertEquals(new Quantity<>(3.0, VolumeUnit.LITRE), sumOfValue);
    }
    @Test
    void testAddition_SameUnit_MillilitrePlusMillilitre(){
        Quantity<VolumeUnit> value1 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sumOfValue = demonstrateAddition(value1,value2);
        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), sumOfValue);
    }
    @Test
    void testAddition_SameUnit_LitrePlusMillilitre(){
        Quantity<VolumeUnit> value1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sumOfValue = demonstrateAddition(value1,value2);
        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), sumOfValue);
    }
    @Test
    void testAddition_SameUnit_MillilitrePlusLitre(){
        Quantity<VolumeUnit> value1 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sumOfValue = demonstrateAddition(value1,value2);
        assertEquals(new Quantity<>(2000.0, VolumeUnit.MILLILITRE), sumOfValue);
    }
    @Test
    void testAddition_CrossUnit_GallonPlusLitre(){
        Quantity<VolumeUnit> value1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> value2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sumOfValue = demonstrateAddition(value1,value2);
        assertEquals(new Quantity<>(2.0, VolumeUnit.GALLON), sumOfValue);
    }
    @Test
    void testAddition_ExplicitTargetUnit_Litre(){
        Quantity<VolumeUnit> value1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sumOfValue = demonstrateAddition(value1,value2,VolumeUnit.LITRE);
        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), sumOfValue);
    }
    @Test
    void testAddition_ExplicitTargetUnit_Millilitre(){
        Quantity<VolumeUnit> value1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sumOfValue = demonstrateAddition(value1,value2,VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(2000.0, VolumeUnit.MILLILITRE), sumOfValue);
    }
    @Test
    void testAddition_ExplicitTargetUnit_Gallon(){
        Quantity<VolumeUnit> value1 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sumOfValue = demonstrateAddition(value1,value2,VolumeUnit.GALLON);
        assertEquals(new Quantity<>(2.0, VolumeUnit.GALLON), sumOfValue);
    }
    @Test
    void testAddition_Commutativity(){
        Quantity<VolumeUnit> value1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(1000, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sumOfValue1 = demonstrateAddition(value1,value2);
        Quantity<VolumeUnit> sumOfValue2 = demonstrateAddition(value2,value1);
        assertEquals(sumOfValue1,sumOfValue2);
    }
    @Test
    void testAddition_WithZero(){
        Quantity<VolumeUnit> value1 = new Quantity<>(5, VolumeUnit.LITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sumOfValue1 = demonstrateAddition(value1,value2);
        assertEquals(value1,sumOfValue1);
    }
    @Test
    void testAddition_NegativeValues(){
        Quantity<VolumeUnit> value1 = new Quantity<>(5, VolumeUnit.LITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(-2000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> sumOfValue1 = demonstrateAddition(value1,value2);
        assertEquals(new Quantity<>(3, VolumeUnit.LITRE),sumOfValue1);
    }
    @Test
    void testAddition_LargeValues(){
        Quantity<VolumeUnit> value1 = new Quantity<>(1e6, VolumeUnit.LITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(1e6, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sumOfValue1 = demonstrateAddition(value1,value2);
        assertEquals(new Quantity<>(2e6, VolumeUnit.LITRE),sumOfValue1);
    }
    @Test
    void testAddition_SmallValues(){
        Quantity<VolumeUnit> value1 = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> value2 = new Quantity<>(0.002, VolumeUnit.LITRE);
        Quantity<VolumeUnit> sumOfValue1 = demonstrateAddition(value1,value2);
        assertEquals(new Quantity<>(0.003, VolumeUnit.LITRE),sumOfValue1);
    }
    @Test
    void testVolumeUnitEnum_LitreConstant(){
        assertEquals(1.0,VolumeUnit.LITRE.getConversionFactor());
    }
    @Test
    void testVolumeUnitEnum_MillilitreConstant(){
        assertEquals(0.001,VolumeUnit.MILLILITRE.getConversionFactor());
    }
    @Test
    void testVolumeUnitEnum_GallonConstant(){
        assertEquals(3.78541,VolumeUnit.GALLON.getConversionFactor());
    }
    @Test
    void testConvertToBaseUnit_LitreToLitre(){
        assertEquals(5.0,VolumeUnit.LITRE.convertToBaseUnit(5.0));
    }
    @Test
    void testConvertToBaseUnit_MillilitreToLitre(){
        assertEquals(1.0,VolumeUnit.MILLILITRE.convertToBaseUnit(1000.0));
    }
    @Test
    void testConvertToBaseUnit_GallonToLitre(){
        assertEquals(3.78541,VolumeUnit.GALLON.convertToBaseUnit(1.0));
    }
    @Test
    void testConvertFromBaseUnit_LitreToLitre(){
        assertEquals(2.0,VolumeUnit.LITRE.convertFromBaseUnit(2.0));
    }
    @Test
    void testConvertFromBaseUnit_LitreToMillilitre(){
        assertEquals(1000.0,VolumeUnit.MILLILITRE.convertFromBaseUnit(1.0));
    }
    @Test
    void testConvertFromBaseUnit_LitreToGallon(){
        assertEquals(1.0,VolumeUnit.GALLON.convertFromBaseUnit(3.78541));
    }

}
