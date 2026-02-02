package com.apps.quantitymeasurement;

public class Inches {

  private final double value;
  public Inches(double value){
      this.value=value;
  }

  @Override
  public boolean equals(Object obj){
      if(this == obj){
          return true;
      }
      if (!(obj instanceof Inches)) {
          return false;
      }
      Inches inches = (Inches) obj;
      return Double.compare(inches.value, value)==0;
  }
}
