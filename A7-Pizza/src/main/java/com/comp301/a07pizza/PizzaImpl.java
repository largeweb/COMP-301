package com.comp301.a07pizza;

import java.util.ArrayList;
// import com.comp301.a07pizza.Pizza.Size;

public final class PizzaImpl implements Pizza {

  private Size pizzaSize;
  private Crust crust;
  private Sauce sauce;
  private Cheese cheese;
  private Topping[] toppings;

  public PizzaImpl(Size pizzaSize, Crust crust, Sauce sauce, Cheese cheese, Topping[] toppings) {
    this.pizzaSize = pizzaSize;
    this.crust = crust;
    this.sauce = sauce;
    this.cheese = cheese;
    this.toppings = toppings;
  }

  @Override
  public boolean isVegetarian() {
    for (int i = 0; i < getIngredients().length; i++) {
      if (getIngredients()[i].isVegetarian() == false) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isVegan() {
    for (int i = 0; i < getIngredients().length; i++) {
      if (getIngredients()[i].isVegan() == false) {
        return false;
      }
    }
    return true;
  }

  @Override
  public double getPrice() {
    double price = 0;
    if (pizzaSize == Size.SMALL) {
      price = 7.00 + (0.25 * toppings.length);
    }
    if (pizzaSize == Size.MEDIUM) {
      price = 9.00 + (0.50 * toppings.length);
    }
    if (pizzaSize == Size.LARGE) {
      price = 11.00 + (0.75 * toppings.length);
    }
    return price;
  }

  @Override
  public Size getSize() {
    return pizzaSize;
  }

  @Override
  public Ingredient getSauce() {
    return sauce;
  }

  @Override
  public Ingredient getCheese() {
    return cheese;
  }

  @Override
  public Ingredient getCrust() {
    return crust;
  }

  @Override
  public Ingredient[] getToppings() {
    return toppings;
  }

  @Override
  public Ingredient[] getIngredients() {
    Ingredient[] ingredients = new Ingredient[toppings.length + 3];
    ingredients[0] = crust;
    ingredients[1] = sauce;
    ingredients[2] = cheese;
    for (int i = 0; i < toppings.length; i++) {
      ingredients[i + 3] = toppings[i];
    }
    return ingredients;
  }
}
