package com.comp301.a01sushi;

public class IngredientPortionImpl implements IngredientPortion {

  private Ingredient ingredient;
  private double amount;
  private String name;
  private double Calories;
  private double Price;
  private boolean isVegetarian;
  private boolean hasRice;
  private boolean hasShellfish;

  public void Portions(Ingredient ingredient_one, double amount_one) {
    if (amount_one < 0) {
      throw new IllegalArgumentException(); // amount not existent
    }
    ingredient = ingredient_one;
    amount = amount_one;
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
      return this;
    }
    if (!ingredient.equals(other.getIngredient())) {
      throw new IllegalArgumentException(); // cannot be combined
    }
    IngredientPortionImpl PortionTwo = new IngredientPortionImpl();
    PortionTwo.Portions(ingredient, amount + other.getAmount());
    return PortionTwo;
  }
}
