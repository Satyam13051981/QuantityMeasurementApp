package com.apps.quantitymeasurement;

public class Feet {

   private final double value;

   public Feet(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Feet)) {
            return false;
        }
        Feet feet = (Feet) obj;
        return Double.compare(value, feet.value) == 0;
    }
}
