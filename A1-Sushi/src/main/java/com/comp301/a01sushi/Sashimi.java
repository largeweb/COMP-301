package com.comp301.a01sushi;

import java.util.Locale;

public class Sashimi implements Sushi {

  private String name;
  private IngredientPortion[] ingredients = {null};
  private int cals;
  private double cost;
  private boolean hasRice;
  private boolean hasShellfish;
  private boolean isVegetarian;

  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  public Sashimi(SashimiType type) {
    if (type == SashimiType.TUNA) {
      name = "tuna sashimi";
      ingredients[0] = new TunaPortion(0.75);
    } else if (type == SashimiType.YELLOWTAIL) {
      name = "yellowtail sashimi";
      ingredients[0] = new YellowtailPortion(0.75);
    } else if (type == SashimiType.EEL) {
      name = "eel sashimi";
      ingredients[0] = new EelPortion(0.75);
    } else if (type == SashimiType.CRAB) {
      name = "crab sashimi";
      ingredients[0] = new CrabPortion(0.75);
    } else if (type == SashimiType.SHRIMP) {
      name = "shrimp sashimi";
      ingredients[0] = new ShrimpPortion(0.75);
    }
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortion[] listPortions = ingredients;
    return listPortions;
  }

  @Override
  public int getCalories() {
    return (int) Math.ceil(ingredients[0].getCalories());
  }

  @Override
  public double getCost() {
    return ingredients[0].getCost();
  }

  @Override
  public boolean getHasRice() {
    return ingredients[0].getIsRice();
  }

  @Override
  public boolean getHasShellfish() {
    return ingredients[0].getIsShellfish();
  }

  @Override
  public boolean getIsVegetarian() {
    return ingredients[0].getIsVegetarian();
  }
}
