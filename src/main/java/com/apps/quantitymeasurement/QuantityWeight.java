package com.apps.quantitymeasurement;

import java.util.Optional;

public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    QuantityWeight(double value, WeightUnit unit){
        this.value=value;
        this.unit=unit;
    }

    private double convertToBaseUnit(double value, WeightUnit unit){
        return value*unit.getConversionFactor();
    }

    private boolean compare(QuantityWeight quantityWeight){
        double epsilon = 0.01;
        double value1 = convertToBaseUnit(value, unit);
        double value2 = convertToBaseUnit(quantityWeight.value, quantityWeight.unit);
        double diff = Math.abs(value1 - value2);
        return diff <= epsilon;
        //return Double.compare(convertToBaseUnit(quantityWeight.value, quantityWeight.unit), convertToBaseUnit(value, unit))==0;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(!(obj instanceof QuantityWeight)){
            return false;
        }
        QuantityWeight quantityWeight = (QuantityWeight)obj;
        return compare(quantityWeight);
    }

    public QuantityWeight convertTo(WeightUnit targetUnit){
        //Checking null for target unit
        Optional<WeightUnit> optionalTargetWeightUnit = Optional.ofNullable(targetUnit);
        optionalTargetWeightUnit.orElseThrow(IllegalArgumentException::new);
        //Checking null for source unit
        Optional<WeightUnit> optionalSourceWeightUnit = Optional.ofNullable(unit);
        optionalSourceWeightUnit.orElseThrow(IllegalArgumentException::new);
        //Checking NaN for Infinite values
        if(!Double.isFinite(value)){
            throw new RuntimeException("Is infinite or NAN");
        }
        double valueInBaseUnit=convertToBaseUnit(value, unit);
        //converting to target unit
        double targetValue= valueInBaseUnit/targetUnit.getConversionFactor();
        targetValue = Math.round(targetValue *100)/100.0;
        return new QuantityWeight(targetValue, targetUnit);
    }

    public QuantityWeight add(QuantityWeight thatWeight){
        return add(new QuantityWeight(value, unit), thatWeight, unit);
    }

    public QuantityWeight add(QuantityWeight weight, WeightUnit targetUnit){
        return add(new QuantityWeight(value,unit), new QuantityWeight(weight.value, weight.unit), targetUnit);
    }

    private QuantityWeight add(QuantityWeight quantityWeight1, QuantityWeight quantityWeight2, WeightUnit targetUnit){
        //Checking Target weight
        Optional<QuantityWeight> optWeight1 = Optional.ofNullable(quantityWeight1);
        optWeight1.orElseThrow(NullPointerException::new);
        //Checking Target weight
        Optional<QuantityWeight> optWeight2 = Optional.ofNullable(quantityWeight2);
        optWeight2.orElseThrow(NullPointerException::new);
        //Checking null for source and target value
        if(!Double.isFinite(quantityWeight1.value) || !Double.isFinite(quantityWeight2.value)){
            throw new RuntimeException("Is infinite or NAN");
        }
        double valueWeight1InBaseUnit=convertToBaseUnit(quantityWeight1.value, quantityWeight1.unit);
        double valueWeight2InBaseUnit=convertToBaseUnit(quantityWeight2.value, quantityWeight2.unit);
        double sumInBaseUnit = valueWeight1InBaseUnit+valueWeight2InBaseUnit;
        //converting to specified unit
        double targetValue= sumInBaseUnit/targetUnit.getConversionFactor();
        targetValue = Math.round(targetValue*100)/100.0;
        return new QuantityWeight(targetValue, targetUnit);
    }

    @Override
    public String toString(){
        return value +" "+ unit;
    }
}
