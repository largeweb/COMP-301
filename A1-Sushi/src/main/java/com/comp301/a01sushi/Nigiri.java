package com.comp301.a01sushi;

import java.util.Locale;

public class Nigiri implements Sushi {

  private String name;
  private IngredientPortion[] ingredients = {null, null};
  private int cals;
  private double cost;
  private boolean hasRice;
  private boolean hasShellfish;
  private boolean isVegetarian;

  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  public Nigiri(NigiriType type) {
    if (type == Nigiri.NigiriType.TUNA) {
      name = "tuna nigiri";
      ingredients[0] = new TunaPortion(0.75);
    } else if (type == Nigiri.NigiriType.YELLOWTAIL) {
      name = "yellowtail nigiri";
      ingredients[0] = new YellowtailPortion(0.75);
    } else if (type == Nigiri.NigiriType.EEL) {
      name = "eel nigiri";
      ingredients[0] = new EelPortion(0.75);
    } else if (type == Nigiri.NigiriType.CRAB) {
      name = "crab nigiri";
      ingredients[0] = new CrabPortion(0.75);
    } else if (type == Nigiri.NigiriType.SHRIMP) {
      name = "shrimp nigiri";
      ingredients[0] = new ShrimpPortion(0.75);
    }
    ingredients[1] = new RicePortion(0.5);
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
    return (int) Math.ceil(ingredients[0].getCalories() + ingredients[1].getCalories());
  }

  @Override
  public double getCost() {
    return ingredients[0].getCost() + ingredients[1].getCost();
  }

  @Override
  public boolean getHasRice() {
    return true;
  }

  @Override
  public boolean getHasShellfish() {
    if (ingredients[0].getIsShellfish()) {
      return true;
    }
    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    if (ingredients[0].getIsRice()) {
      return true;
    }
    return false;
  }
}
