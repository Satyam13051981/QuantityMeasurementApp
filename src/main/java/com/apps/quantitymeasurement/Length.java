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

    boolean compare(Length length){
        return Double.compare(convertToBaseUnit(length.value, length.unit), convertToBaseUnit(value, unit))==0;
    }

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
}
