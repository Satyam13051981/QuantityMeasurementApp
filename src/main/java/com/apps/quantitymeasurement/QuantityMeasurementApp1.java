package com.apps.quantitymeasurement;

public class QuantityMeasurementApp1 {

    public static <U extends IMeasurable> boolean demonstrateEquality(Quantity<U> quantity1, Quantity<U> quantity2){
        return quantity1.equals(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(Quantity<U> quantity, U targetUnit){
        double value = quantity.convertTo(targetUnit);
        return new Quantity<>(value, targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> quantity1, Quantity<U> quantity2){
        return quantity1.add(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> quantity1, Quantity<U> quantity2, U targetUnit){
        return quantity1.add(quantity2, targetUnit);
    }


    public static void main(String[] args) {
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(120, LengthUnit.INCHES);
        System.out.println("Are length equal? " +lengthInFeet.equals(lengthInInches));

        Quantity<WeightUnit> weightInKilograms = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInGrams = new Quantity<>(1000, WeightUnit.GRAM);
        System.out.println("Are weight equal? " +weightInKilograms.equals(weightInGrams));

        double convertedLength = lengthInFeet.convertTo(LengthUnit.INCHES);
        System.out.println("10 feet in inches: "+ convertedLength);

        Quantity<LengthUnit> totalLength = lengthInFeet.add(lengthInInches, LengthUnit.FEET);
        System.out.println("Total length in feet: "+ totalLength.getValue()+ " "+totalLength.getUnit() );

        Quantity<WeightUnit> weightInPounds = new Quantity<>(2.0, WeightUnit.POUND);
        Quantity<WeightUnit> totalWeight = weightInKilograms.add(weightInPounds, WeightUnit.KILOGRAM);
        System.out.println("Total weight in kilogram "+totalWeight.getValue() + " "+ totalWeight.getUnit());

        Quantity<WeightUnit> convertedWeight = demonstrateConversion(weightInGrams, WeightUnit.KILOGRAM);
        System.out.println("Converted Weight "+ convertedWeight.getValue() + " "+ convertedWeight.getUnit());

        Quantity<WeightUnit> weightInPound = new Quantity<>(2.20462, WeightUnit.POUND);
        Quantity<WeightUnit> sumWeight = demonstrateAddition(weightInKilograms, weightInPound, WeightUnit.GRAM);
        System.out.println("sumWeight "+sumWeight);

        System.out.println(new Quantity<>(1.0, LengthUnit.FEET).equals(new Quantity<>(1.0, WeightUnit.KILOGRAM)));

    }
}
