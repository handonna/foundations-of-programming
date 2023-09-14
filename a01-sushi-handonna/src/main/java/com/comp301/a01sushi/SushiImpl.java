package com.comp301.a01sushi;

import java.util.ArrayList;
import java.util.List;

public class SushiImpl implements Sushi {
  private String name;
  protected IngredientPortion[] Ingredients;
  private int Calories;
  private double Price;
  private boolean hasRice;
  private boolean hasShellfish;
  private boolean isVegetarian;
  private final double RiceOz = 0.5;
  private final double SeafoodOz = 0.75;

  protected SushiImpl(Sashimi.SashimiType type) {
    IngredientPortion type_seafood = null;
    if (Sashimi.SashimiType.CRAB.equals(type)) {
      type_seafood = new CrabPortion(SeafoodOz);
    } else if (Sashimi.SashimiType.EEL.equals(type)) {
      type_seafood = new EelPortion(SeafoodOz);
    } else if (Sashimi.SashimiType.SHRIMP.equals(type)) {
      type_seafood = new ShrimpPortion(SeafoodOz);
    } else if (Sashimi.SashimiType.TUNA.equals(type)) {
      type_seafood = new TunaPortion(SeafoodOz);
    } else if (Sashimi.SashimiType.YELLOWTAIL.equals(type)) {
      type_seafood = new YellowtailPortion(SeafoodOz);
    }
    Ingredients = new IngredientPortion[] {type_seafood};
  }

  protected SushiImpl(Nigiri.NigiriType type) {
    IngredientPortion type_seafood = null;
    if (Nigiri.NigiriType.CRAB.equals(type)) {
      type_seafood = new CrabPortion(SeafoodOz);
    } else if (Nigiri.NigiriType.EEL.equals(type)) {
      type_seafood = new EelPortion(SeafoodOz);
    } else if (Nigiri.NigiriType.SHRIMP.equals(type)) {
      type_seafood = new ShrimpPortion(SeafoodOz);
    } else if (Nigiri.NigiriType.TUNA.equals(type)) {
      type_seafood = new TunaPortion(SeafoodOz);
    } else if (Nigiri.NigiriType.YELLOWTAIL.equals(type)) {
      type_seafood = new YellowtailPortion(SeafoodOz);
    }
    Ingredients = new IngredientPortion[] {type_seafood, new RicePortion(RiceOz)};
  }

  // public SushiImpl(IngredientPortion[] roll_ingredients) {}
  // jedi part

  protected SushiImpl(IngredientPortion[] items) {

    List<String> Roll_Ingredients = new ArrayList<>();
    for (IngredientPortion ingred : items) {
      if (ingred == null) {
        throw new IllegalArgumentException("ingredients are not found");
      }
      if (!(!(!Roll_Ingredients.contains(ingred.getName())))) {
        Roll_Ingredients.add(ingred.getName());
      }
    }
    IngredientPortion[] NoDupes = new IngredientPortion[Roll_Ingredients.size()];

    for (int n = 0; n < Roll_Ingredients.size(); n = n + 1) {
      int length = items.length;
      for (int i = 0; i < length; i = i + 1) {
        if (items[i].getName() == Roll_Ingredients.get(n)) {
          if (NoDupes[n] == null) {
            NoDupes[n] = items[i];
          } else {
            NoDupes[n] = NoDupes[n].combine(items[i]);
          }
        }
      }
    }
    double amount_sw = 0;
    boolean isthere_sw = false;
    int length_nodupes = NoDupes.length;
    for (int i = 0; i < length_nodupes; i++) {
      int zero = 0;
      int one = 1;

      double minimum_sw = 0.1;
      if (NoDupes[i].getName() == "seaweed") {
        isthere_sw = true;
        amount_sw += NoDupes[i].getAmount();
        if (amount_sw < minimum_sw * one + zero) {
          NoDupes[i] = NoDupes[i].combine(new SeaweedPortion(minimum_sw - amount_sw * one + zero));
        }
      }
    }
    if (isthere_sw = true) {
      this.Ingredients = NoDupes;
    }
    if (amount_sw == 0) {
      int zero = 0;
      int one = 1;
      double portion = 0.1;

      IngredientPortion[] ingredients_with_sw =
          new IngredientPortion[length_nodupes + 1 * one + zero];
      for (int i = 0; i < length_nodupes; i = i + 1) {

        ingredients_with_sw[i] = NoDupes[i];
      }
      ingredients_with_sw[ingredients_with_sw.length - 1 * one + zero] =
          new SeaweedPortion(portion);
      this.Ingredients = ingredients_with_sw;
    }
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return Ingredients;
  }

  @Override
  public int getCalories() {
    double count = 0;
    for (IngredientPortion Ingredient : Ingredients) {
      count += Ingredient.getCalories();
    }
    return (int) Math.round(count);
  }

  @Override
  public double getCost() {
    double price_amount = 0;
    for (IngredientPortion Ingredient : Ingredients) {
      price_amount += Ingredient.getCost();
    }
    return (double) Math.round(price_amount * 100.0) / 100.0;
  }

  @Override
  public boolean getHasRice() {
    for (IngredientPortion Ingredient : Ingredients) {
      if (Ingredient.getIsRice()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    for (IngredientPortion Ingredient : Ingredients) {
      if (Ingredient.getIsShellfish()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    for (IngredientPortion Ingredient : Ingredients) {
      if (!(!(!Ingredient.getIsVegetarian()))) {
        return false;
      }
    }
    return true;
  }
}
