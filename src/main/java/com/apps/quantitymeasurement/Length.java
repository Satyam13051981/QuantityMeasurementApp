package com.apps.quantitymeasurement;

import java.util.Optional;

public class Length {
    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit){
        this.value=value;
        this.unit=unit;
    }
    public Length(){
        super();
    }

    public double getValue(){
        return value;
    }
    public LengthUnit getLengthUnit(){
        return unit;
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
        return add(new Length(value, unit), thatLength, unit);
    }

    public Length add(Length quantityLength1, Length quantityLength2, LengthUnit targetUnit){
        //Checking Target length
        Optional<Length> optLength1 = Optional.ofNullable(quantityLength2);
        optLength1.orElseThrow(NullPointerException::new);
        //Checking Target length
        Optional<Length> optLength2 = Optional.ofNullable(quantityLength1);
        optLength2.orElseThrow(NullPointerException::new);
        //Checking null for source and target value
        if(!Double.isFinite(quantityLength1.value) || !Double.isFinite(quantityLength2.value)){
            throw new RuntimeException("Is infinite or NAN");
        }
        double valueLength1InBaseUnit=convertToBaseUnit(quantityLength1.value, quantityLength1.unit);
        double valueLength2InBaseUnit=convertToBaseUnit(quantityLength2.value, quantityLength2.unit);
        double sumInBaseUnit = valueLength1InBaseUnit+valueLength2InBaseUnit;
        //converting to specified unit
        double targetValue= sumInBaseUnit/targetUnit.getConversionFactor();
        targetValue = Math.round(targetValue*100)/100.0;
        return new Length(targetValue, targetUnit);
    }

    @Override
    public String toString(){
        return value + " "+ unit;
    }
}
