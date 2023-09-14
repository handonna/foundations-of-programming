package com.comp301.a01sushi;

public class Roll extends SushiImpl {
  private String name;

  private final String Name;
  private int Calories;
  private double Price;
  private boolean hasRice;
  private boolean hasShellfish;
  private boolean isVegetarian;

  private IngredientPortion[] sushiorder;

  public Roll(String name, IngredientPortion[] roll_ingredients) {
    super(roll_ingredients);
    this.Name = name;
    }

  public String getName() {
    return Name;
  }

  public IngredientPortion[] getIngredients() {
    return sushiorder;
  }

  public int getCalories() {
    double Total_Calories = 0;
    for (int i = 0; i < sushiorder.length; ) {
      Total_Calories += sushiorder[i].getCalories();
      i = i + 1;
    }
    return (int) Total_Calories;
  }

  public double getCost() {
    double Total_Price = 0;
    for (int i = 0; i < sushiorder.length; ) {
      Total_Price += sushiorder[i].getCost();
      i = i + 1;
    }
    return Math.round(Total_Price * 100.0) / 100.0;
  }

  public boolean getHasRice() {
    for (int i = 0; i < sushiorder.length; i++) {
      if (sushiorder[i].getIsRice()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    return false;
  }

  public boolean getIsVegetarian() {
    for (int i = 0; i < sushiorder.length; i++) {
      if (sushiorder[i].getIsVegetarian()) {
        return true;
      }
    }
    return false;
  }
}
