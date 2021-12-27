package com.comp301.a01sushi;

public class BaseIngredientPortion implements IngredientPortion {

  private Ingredient ingredient;
  private double amount;
  private String name;
  private boolean isVegetarian;
  private boolean hasRice;
  private boolean hasShellfish;
  private double cals;
  private double cost;

  public void setPortionValues(Ingredient _ingredient, double _amount) {
    if (_amount < 0) {
      throw new IllegalArgumentException("amount less than 0");
    }
    ingredient = _ingredient;
    amount = _amount;
  }

  @Override
  public Ingredient getIngredient() {
    return ingredient;
  }

  @Override
  public double getAmount() {
    return amount;
  }

  @Override
  public String getName() {
    return ingredient.getName();
  }

  @Override
  public boolean getIsVegetarian() {
    return ingredient.getIsVegetarian();
  }

  @Override
  public boolean getIsRice() {
    return ingredient.getIsRice();
  }

  @Override
  public boolean getIsShellfish() {
    return ingredient.getIsShellfish();
  }

  @Override
  public double getCalories() {
    return ingredient.getCaloriesPerOunce() * amount;
  }

  @Override
  public double getCost() {
    return ingredient.getPricePerOunce() * amount;
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return (IngredientPortion) this;
    }
    if (!ingredient.equals(other.getIngredient())) {
      throw new IllegalArgumentException("can't combine different ingredients!");
    }
    BaseIngredientPortion newPortion = new BaseIngredientPortion();
    newPortion.setPortionValues(ingredient, amount + other.getAmount());
    return newPortion;
  }
}
