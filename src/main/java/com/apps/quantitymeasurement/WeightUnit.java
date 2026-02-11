package com.apps.quantitymeasurement;

public enum WeightUnit implements IMeasurable{
    KILOGRAM(1),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor){
        this.conversionFactor= conversionFactor;
    }

    @Override
    public double getConversionFactor(){
        return conversionFactor;
    }


    @Override
    public double convertToBaseUnit(double value) {
        return value*getConversionFactor();
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        double targetValue= baseValue/getConversionFactor();
        targetValue = Math.round(targetValue *100)/100.0;
        return targetValue;
    }

    public static void main(String[] args) {
        System.out.println(WeightUnit.GRAM.convertToBaseUnit(5000));
        System.out.println( WeightUnit.GRAM.convertFromBaseUnit(1.00));
    }
}
