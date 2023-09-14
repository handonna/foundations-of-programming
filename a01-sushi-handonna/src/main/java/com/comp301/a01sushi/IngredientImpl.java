package com.comp301.a01sushi;

public class IngredientImpl implements Ingredient {
  private final String Name;
  private final double Price;
  private final int Calories;
  private final boolean isVegetarian;
  private final boolean hasRice;
  private final boolean hasShellfish;

  public IngredientImpl(
      String Name,
      double Price,
      int Calories,
      boolean Vegetarian,
      boolean Rice,
      boolean Shellfish) {
    this.Name = Name;
    this.Price = Price;
    this.Calories = Calories;
    this.isVegetarian = Vegetarian;
    this.hasRice = Rice;
    this.hasShellfish = Shellfish;
  }

  public String getName() {
    return Name;
  }

  public double getCaloriesPerDollar() {
    return Calories / Price;
  }

  public int getCaloriesPerOunce() {
    return Calories;
  }

  public double getPricePerOunce() {
    return Price;
  }

  public boolean getIsVegetarian() {
    return isVegetarian;
  }

  public boolean getIsRice() {
    return hasRice;
  }

  public boolean getIsShellfish() {
    return hasShellfish;
  }

  public boolean equals(Ingredient other) {
    if (other == null) {
      return false;
    }
    return other.getName().equals(this.Name)
        && other.getCaloriesPerOunce() == this.Calories
        && other.getPricePerOunce() == this.Price
        && other.getIsVegetarian() == this.isVegetarian
        && other.getIsRice() == this.hasRice
        && other.getIsShellfish() == this.hasShellfish;
  }
}
