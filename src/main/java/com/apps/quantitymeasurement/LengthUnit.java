package com.apps.quantitymeasurement;

public enum LengthUnit implements IMeasurable{
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor){
        this.conversionFactor=conversionFactor;
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

    @Override
    public String getUnitName() {
        return this.name();
    }
}
