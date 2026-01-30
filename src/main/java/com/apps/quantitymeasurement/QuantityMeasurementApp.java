package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        Feet feet = new Feet(2.34);
        Feet feet2 = new Feet(2.34);

        System.out.println("Is given feet equals: " + feet.equals(feet2));

        Inches inches1 = new Inches(26.8);
        Inches inches2 = new Inches(26.8);

        System.out.println("Is given inches are equals: " + inches1.equals(inches2));

        Length l1= new Length(12.0, LengthUnit.INCHES);
        Length l2= new Length(11.0, LengthUnit.FEET);
        System.out.println("Are Lengths equal " +l1.equals(l2));
    }
}
