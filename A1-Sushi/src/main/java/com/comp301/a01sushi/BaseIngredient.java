package com.comp301.a01sushi;

public class BaseIngredient implements Ingredient {

  private String name;
  private double priceOz;
  private int calsOz;
  private boolean isVegetarian;
  private boolean hasRice;
  private boolean hasShellfish;

  public void setValues(
      String _name,
      double _prizeOz,
      int _calsOz,
      boolean _isVeg,
      boolean _hasRice,
      boolean _hasShellfish) {
    name = _name;
    priceOz = _prizeOz;
    calsOz = _calsOz;
    isVegetarian = _isVeg;
    hasRice = _hasRice;
    hasShellfish = _hasShellfish;
  }

  public String getName() {
    return name;
  }

  @java.lang.Override
  public double getCaloriesPerDollar() {
    return (1 / priceOz) * calsOz;
  }

  @java.lang.Override
  public int getCaloriesPerOunce() {
    return calsOz;
  }

  @java.lang.Override
  public double getPricePerOunce() {
    return priceOz;
  }

  @java.lang.Override
  public boolean getIsVegetarian() {
    return isVegetarian;
  }

  @java.lang.Override
  public boolean getIsRice() {
    return hasRice;
  }

  @java.lang.Override
  public boolean getIsShellfish() {
    return hasShellfish;
  }

  @java.lang.Override
  public boolean equals(Ingredient other) {
    if (other == null) {
      return false;
    }
    if (other.getName().equals(name)
        && other.getCaloriesPerOunce() == calsOz
        && (other.getPricePerOunce() <= priceOz + 0.01
            && other.getPricePerOunce() >= priceOz - 0.01)
        && other.getIsVegetarian() == isVegetarian
        && other.getIsRice() == hasRice
        && other.getIsShellfish() == hasShellfish) {
      return true;
    }
    return false;
  }
}
