package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    //UC5
    public static Length demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit){
        Length length= new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(Length length, LengthUnit toUnit){
        return length.convertTo(toUnit);
    }

    //UC6
    public static Length demonstrateLengthAddition(Length length1, Length length2){
        return length1.add(length2);
    }

    //UC7
    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit){
        return length1.add(length2, targetUnit);
    }

    //UC9
    public static QuantityWeight demonstrateWeightConversion(QuantityWeight weight, WeightUnit toUnit){
        return weight.convertTo(toUnit);
    }

    public static QuantityWeight demonstrateWeightAddition(QuantityWeight weight1, QuantityWeight weight2){
        return weight1.add(weight2);
    }

    public static QuantityWeight demonstrateWeightAddition(QuantityWeight weight1, QuantityWeight weight2, WeightUnit targetUnit){
        return weight1.add(weight2, targetUnit);
    }

    public static void main(String[] args) {
        //UC1
        Feet feet = new Feet(2.34);
        Feet feet2 = new Feet(2.34);
        System.out.println("Is given feet equals: " + feet.equals(feet2));

        //UC2
        Inches inches1 = new Inches(26.8);
        Inches inches2 = new Inches(26.8);
        System.out.println("Is given inches are equals: " + inches1.equals(inches2));

        //UC3
        Length l1= new Length(12.0, LengthUnit.INCHES);
        Length l2= new Length(11.0, LengthUnit.FEET);
        System.out.println("Are Lengths equal? " +l1.equals(l2));

        //UC4
        Length length1= new Length(1, LengthUnit.FEET);
        Length length2= new Length(12, LengthUnit.INCHES);
        System.out.println("Are Lengths equal? " +length1.equals(length2));

        Length length3= new Length(1, LengthUnit.YARDS);
        Length length4= new Length(36, LengthUnit.INCHES);
        System.out.println("Are Lengths equal? " +length3.equals(length4));

        Length length5= new Length(100, LengthUnit.CENTIMETERS);
        Length length6= new Length(39.3701, LengthUnit.INCHES);
        System.out.println("Are Lengths equal? " +length5.equals(length6));

        //UC5
        Length length8= new Length(8, LengthUnit.CENTIMETERS);
        System.out.println(demonstrateLengthConversion(length8, LengthUnit.YARDS));

        System.out.println(demonstrateLengthConversion(8, LengthUnit.YARDS, LengthUnit.INCHES));
        System.out.println(demonstrateLengthConversion(1, LengthUnit.FEET, LengthUnit.INCHES));
        System.out.println(demonstrateLengthConversion(3, LengthUnit.YARDS, LengthUnit.FEET));
        System.out.println(demonstrateLengthConversion(36, LengthUnit.INCHES, LengthUnit.YARDS));
        System.out.println(demonstrateLengthConversion(1, LengthUnit.INCHES, LengthUnit.INCHES));

        //UC6
        Length length9= new Length(1, LengthUnit.YARDS);
        Length length10= new Length(36, LengthUnit.INCHES);
        System.out.println(demonstrateLengthAddition(length10, length9));

        //UC7
        Length length11= new Length(1, LengthUnit.FEET);
        Length length12= new Length(12, LengthUnit.INCHES);
        System.out.println(demonstrateLengthAddition(length11, length12, LengthUnit.YARDS));

        //UC9 Equality Comparisons
        QuantityWeight weight1= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        System.out.println("Is weight equal? "+ weight1.equals(weight2));

        QuantityWeight weight3= new QuantityWeight(1000.0, WeightUnit.GRAM);
        System.out.println("Is weight equal? "+ weight1.equals(weight3));

        QuantityWeight weight4= new QuantityWeight(1.0, WeightUnit.POUND);
        QuantityWeight weight5= new QuantityWeight(1.0, WeightUnit.POUND);
        System.out.println("Is weight equal? "+ weight4.equals(weight5));

        QuantityWeight weight6= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight7= new QuantityWeight(2.20462, WeightUnit.POUND);
        System.out.println("Is weight equal? "+ weight6.equals(weight7));

        QuantityWeight weight8= new QuantityWeight(500.0, WeightUnit.GRAM);
        QuantityWeight weight9= new QuantityWeight(0.5, WeightUnit.KILOGRAM);
        System.out.println("Is weight equal? "+ weight8.equals(weight9));

        QuantityWeight weight10= new QuantityWeight(1.0, WeightUnit.POUND);
        QuantityWeight weight11= new QuantityWeight(453.592, WeightUnit.GRAM);
        System.out.println("Is weight equal? "+ weight10.equals(weight11));

        //UC9 Unit conversion
        QuantityWeight weight12= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        System.out.println(demonstrateWeightConversion(weight12, WeightUnit.GRAM));

        QuantityWeight weight13= new QuantityWeight(2.0, WeightUnit.POUND);
        System.out.println(demonstrateWeightConversion(weight13, WeightUnit.KILOGRAM));

        QuantityWeight weight14= new QuantityWeight(500.0, WeightUnit.GRAM);
        System.out.println(demonstrateWeightConversion(weight14, WeightUnit.POUND));

        QuantityWeight weight15= new QuantityWeight(0.0, WeightUnit.KILOGRAM);
        System.out.println(demonstrateWeightConversion(weight15, WeightUnit.GRAM));

        //UC9 Addition Operation (Implicit target Unit)
        QuantityWeight weight16= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight17= new QuantityWeight(2.0, WeightUnit.KILOGRAM);
        System.out.println(demonstrateWeightAddition(weight16,weight17));

        QuantityWeight weight18= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight19= new QuantityWeight(1000.0, WeightUnit.GRAM);
        System.out.println(demonstrateWeightAddition(weight18,weight19));

        QuantityWeight weight20= new QuantityWeight(500.0, WeightUnit.GRAM);
        QuantityWeight weight21= new QuantityWeight(0.5, WeightUnit.KILOGRAM);
        System.out.println(demonstrateWeightAddition(weight20,weight21));

        //UC9 Addition Operation (Explicit target Unit)
        QuantityWeight weight22= new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight23= new QuantityWeight(1000., WeightUnit.GRAM);
        System.out.println(demonstrateWeightAddition(weight22,weight23, WeightUnit.GRAM));

        QuantityWeight weight24= new QuantityWeight(1.0, WeightUnit.POUND);
        QuantityWeight weight25= new QuantityWeight(453.592, WeightUnit.GRAM);
        System.out.println(demonstrateWeightAddition(weight24,weight25, WeightUnit.POUND));

        QuantityWeight weight26= new QuantityWeight(2.0, WeightUnit.KILOGRAM);
        QuantityWeight weight27= new QuantityWeight(4.0, WeightUnit.POUND);
        System.out.println(demonstrateWeightAddition(weight26,weight27, WeightUnit.KILOGRAM));

        System.out.println(length1.equals(weight26));
    }
}
