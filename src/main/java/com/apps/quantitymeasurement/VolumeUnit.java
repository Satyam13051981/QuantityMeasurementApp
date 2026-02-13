package com.apps.quantitymeasurement;

public enum VolumeUnit implements IMeasurable{
    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor){
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
