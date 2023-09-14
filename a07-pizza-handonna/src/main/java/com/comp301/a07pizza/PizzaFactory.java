package com.comp301.a07pizza;

public class PizzaFactory {
  public static Pizza makeCheesePizza(Pizza.Size size) {
    Topping[] cheese = new Topping[] {};
    Pizza cheese_pizza = new PizzaImpl(size, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, cheese);
    return cheese_pizza;
  }

  public static Pizza makeHawaiianPizza(Pizza.Size size) {
    Topping[] hawaiian = new Topping[] {Topping.HAM, Topping.PINEAPPLE};
    Pizza hawaiian_pizza =
        new PizzaImpl(size, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, hawaiian);
    return hawaiian_pizza;
  }

  public static Pizza makeMeatLoversPizza(Pizza.Size size) {
    Topping[] meat =
        new Topping[] {Topping.PEPPERONI, Topping.SAUSAGE, Topping.BACON, Topping.GROUND_BEEF};
    Pizza meat_pizza = new PizzaImpl(size, Crust.DEEP_DISH, Sauce.TOMATO, Cheese.BLEND, meat);
    return meat_pizza;
  }

  public static Pizza makeVeggieSupremePizza(Pizza.Size size) {
    Topping[] veggie =
        new Topping[] {
          Topping.SUN_DRIED_TOMATO, Topping.GREEN_PEPPER, Topping.MUSHROOMS, Topping.OLIVES
        };
    Pizza veggie_pizza = new PizzaImpl(size, Crust.THIN, Sauce.TOMATO, Cheese.BLEND, veggie);
    return veggie_pizza;
  }

  public static Pizza makeDailySpecialPizza() {
    Topping[] special = new Topping[] {Topping.GREEN_PEPPER, Topping.MUSHROOMS, Topping.PEPPERONI};
    Pizza special_pizza =
        new PizzaImpl(Pizza.Size.MEDIUM, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, special);
    return special_pizza;
  }
}
