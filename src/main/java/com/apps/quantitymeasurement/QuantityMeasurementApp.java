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

    }
}
