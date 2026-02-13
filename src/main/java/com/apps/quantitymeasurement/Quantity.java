package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity <U extends IMeasurable>{
    private double value;
    private U unit;

    public Quantity(double value, U unit){
        if(unit==null){
            throw new IllegalArgumentException();
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue(){
        return this.value;
    }

    public U getUnit() {
        return this.unit;
    }

    public <U extends IMeasurable> double convertTo(U targetUnit){

        if(!(targetUnit.getClass().equals(unit.getClass()))){
            throw new IllegalArgumentException();
        }
        double valueInBaseUnit=unit.convertToBaseUnit(value);
        //converting to target unit
        return targetUnit.convertFromBaseUnit(valueInBaseUnit);
    }

    public Quantity<U> add(Quantity<U> other){
        return add(new Quantity<>(value, unit), other, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit){
        return add(new Quantity<>(value, unit), other, targetUnit);
    }

    private Quantity<U> add(Quantity<U> quantity1, Quantity<U> quantity2, U targetUnit){
        if(!(quantity1.unit.getClass().equals(targetUnit.getClass())) || !(quantity2.unit.getClass().equals(targetUnit.getClass()))){
            throw new IllegalArgumentException();
        }
        if(!Double.isFinite(quantity1.value) || !Double.isFinite(quantity2.value)){
            throw new RuntimeException("Is infinite or NAN");
        }
        double valueInBaseUnit1=quantity1.unit.convertToBaseUnit(quantity1.value);
        double valueInBaseUnit2=quantity2.unit.convertToBaseUnit(quantity2.value);
        double sumInBaseUnit = valueInBaseUnit1+valueInBaseUnit2;
        //converting to specified unit
        double targetValue= sumInBaseUnit/targetUnit.getConversionFactor();
        targetValue = Math.round(targetValue*100)/100.0;
        return new Quantity(targetValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Quantity quantity = (Quantity) obj;

        if(unit.getClass()!=((Quantity<?>) obj).unit.getClass()){
            return false;
        }
        return compare(quantity);
    }

    private boolean compare(Quantity quantity){
        double epsilon = 0.01;
        double value1 = unit.convertToBaseUnit(value);
        double value2 = quantity.unit.convertToBaseUnit(quantity.value);
        double diff = Math.abs(value1 - value2);
        return diff <= epsilon;
    }

    @Override
    public String toString(){
        return "Value: "+value + " Unit: "+unit;
    }
}