package com.comp301.a07pizza;

public final class Cheese extends IngredientImpl {

  private Cheese(String ingredientName, Boolean isVegetarian, Boolean isVegan) {
    super(ingredientName, isVegetarian, isVegan);
  }

  public static final Cheese MOZZARELLA = new Cheese("mozzarella", true, false);
  public static final Cheese BLEND = new Cheese("blend", true, false);
  public static final Cheese VEGAN = new Cheese("vegan", true, true);
}
