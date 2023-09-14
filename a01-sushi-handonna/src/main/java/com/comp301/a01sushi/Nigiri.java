package com.comp301.a01sushi;

public class Nigiri extends SushiImpl {
  // not sure how to do this one, take similar approach as sashimi?

  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  private final IngredientPortion nigiri_seafood;

  public Nigiri(NigiriType type) {
    super(type);
    nigiri_seafood = Ingredients[0];
  }

  @Override
  public String getName() {
    return nigiri_seafood.getName() + " " + "nigiri";
  }

}
