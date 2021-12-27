package com.comp301.a07pizza;

public class PizzaFactory {

  public static Pizza makeCheesePizza(Pizza.Size size) {
    Pizza pizza =
        new PizzaImpl(size, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, new Topping[0]);
    return pizza;
  }

  public static Pizza makeHawaiianPizza(Pizza.Size size) {
    Pizza pizza =
        new PizzaImpl(
            size,
            Crust.HAND_TOSSED,
            Sauce.TOMATO,
            Cheese.BLEND,
            new Topping[] {Topping.HAM, Topping.PINEAPPLE});
    return pizza;
  }

  public static Pizza makeMeatLoversPizza(Pizza.Size size) {
    Pizza pizza =
        new PizzaImpl(
            size,
            Crust.DEEP_DISH,
            Sauce.TOMATO,
            Cheese.BLEND,
            new Topping[] {Topping.PEPPERONI, Topping.SAUSAGE, Topping.BACON, Topping.GROUND_BEEF});
    return pizza;
  }

  public static Pizza makeVeggieSupremePizza(Pizza.Size size) {
    Pizza pizza =
        new PizzaImpl(
            size,
            Crust.THIN,
            Sauce.TOMATO,
            Cheese.BLEND,
            new Topping[] {
              Topping.SUN_DRIED_TOMATO, Topping.GREEN_PEPPER, Topping.MUSHROOMS, Topping.OLIVES
            });
    return pizza;
  }

  public static Pizza makeDailySpecialPizza() {
    Pizza pizza =
        new PizzaImpl(
            Pizza.Size.LARGE,
            Crust.HAND_TOSSED,
            Sauce.TOMATO,
            Cheese.BLEND,
            new Topping[] {
              Topping.BUFFALO_CHICKEN,
              Topping.BACON,
              Topping.JALAPENO,
              Topping.PEPPERONI,
              Topping.ONION
            });
    return pizza;
  }
}
