package com.comp301.a07pizza;

public class PizzaImpl implements Pizza {
  private final Size size;
  private final Crust crust;
  private final Sauce sauce;
  private final Cheese cheese;
  private final Topping[] toppings;
  private Ingredient[] ingred;

  public PizzaImpl(Size size, Crust crust, Sauce sauce, Cheese cheese, Topping[] toppings) {
    this.size = size;
    this.crust = crust;
    this.sauce = sauce;
    this.cheese = cheese;
    this.toppings = toppings;
  }

  @Override
  public boolean isVegetarian() {
    int ingredients = getIngredients().length;
    for (int i = 0; i < ingredients; i++) {
      if (getIngredients()[i].isVegetarian() != true) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isVegan() {
    int ingredients = getIngredients().length;
    for (int i = 0; i < ingredients; i++) {
      if (getIngredients()[i].isVegan() != true) {
        return false;
      }
    }

    return true;
  }

  @Override
  public double getPrice() {
    double small_cost = 7.0;
    double price = 0.0;
    if (size == Size.SMALL) {
      price = small_cost + (0.25 * toppings.length);
    }
    if (size == Size.MEDIUM) {
      price = small_cost + 2.00 + (0.5 * toppings.length);
    }
    if (size == Size.LARGE) {
      price = small_cost + 4.00 + (0.75 * toppings.length);
    }
    return price;
  }

  @Override
  public Size getSize() {
    return size;
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
    ingred = new Ingredient[toppings.length + 3];

    ingred[0] = crust;
    ingred[1] = sauce;
    ingred[2] = cheese;

    for (int i = 0; i < toppings.length; i++) {
      ingred[i + 3] = toppings[i];
    }
    return ingred;
  }
}
