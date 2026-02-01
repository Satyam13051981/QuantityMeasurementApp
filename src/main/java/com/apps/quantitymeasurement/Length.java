package com.apps.quantitymeasurement;

public class Length {
    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit){
        this.value=value;
        this.unit=unit;
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
        double valueInBaseUnit=convertToBaseUnit(value, unit);
        double targetValue= valueInBaseUnit/targetUnit.getConversionFactor();
        return new Length(targetValue, targetUnit);
    }

    public String toString(){
        return "Length: value= "+ value + " Unit= " +unit;
    }
}
