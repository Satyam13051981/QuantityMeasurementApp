package com.apps.quantitymeasurement;

import java.util.Optional;

public class Length {
    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit){
        this.value=value;
        this.unit=unit;
    }

    public double getValue(){
        return value;
    }

    private double convertToBaseUnit(double value, LengthUnit unit){
        return value*unit.getConversionFactor();
    }

    private boolean compare(Length length){
        return Double.compare(convertToBaseUnit(length.value, length.unit), convertToBaseUnit(value, unit))==0;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (!(obj instanceof Length)) {
            return false;
        }
        Length length = (Length) obj;
        return compare(length);
    }

    public Length convertTo(LengthUnit targetUnit){
        //Checking null for target unit
        Optional<LengthUnit> optionalTargetUnit = Optional.ofNullable(targetUnit);
        optionalTargetUnit.orElseThrow(IllegalArgumentException::new);
        //Checking null for source unit
        Optional<LengthUnit> optionalSourceTUnit = Optional.ofNullable(unit);
        optionalSourceTUnit.orElseThrow(IllegalArgumentException::new);
        //Checking NaN for Infinite values
        if(!Double.isFinite(value)){
            throw new RuntimeException("Is infinite or NAN");
        }
        double valueInBaseUnit=convertToBaseUnit(value, unit);
        //converting to target unit
        double targetValue= valueInBaseUnit/targetUnit.getConversionFactor();
        targetValue = Math.round(targetValue *100)/100.0;
        return new Length(targetValue, targetUnit);
    }

    public Length add(Length thatLength){
        double valueSorceInBaseUnit=convertToBaseUnit(value, unit);
        double valueTargetInBaseUnit=convertToBaseUnit(thatLength.value, thatLength.unit);
        double sumInBaseUnit = valueSorceInBaseUnit+valueTargetInBaseUnit;
        //converting to target unit
        double targetValue= sumInBaseUnit/thatLength.unit.getConversionFactor();
        return new Length(targetValue, thatLength.unit);
    }

    @Override
    public String toString(){
        return ""+value;
    }
}
