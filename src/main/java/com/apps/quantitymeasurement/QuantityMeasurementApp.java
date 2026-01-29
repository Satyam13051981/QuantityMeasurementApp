package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        Feet feet = new Feet(2.34);
        Feet feet2 = new Feet(2.34);

        System.out.println(feet.equals(feet2));
    }
}
