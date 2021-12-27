package com.comp301.a07pizza;

public class IngredientImpl implements Ingredient {

  private String ingredientName;
  private Boolean isVegetarian;
  private Boolean isVegan;

  public IngredientImpl(String ingredientName, Boolean isVegetarian, Boolean isVegan) {
    this.ingredientName = ingredientName;
    this.isVegetarian = isVegetarian;
    this.isVegan = isVegan;
  }

  @java.lang.Override
  public String getName() {
    return ingredientName;
  }

  @java.lang.Override
  public boolean isVegetarian() {
    return isVegetarian;
  }

  @java.lang.Override
  public boolean isVegan() {
    return isVegan;
  }
}
