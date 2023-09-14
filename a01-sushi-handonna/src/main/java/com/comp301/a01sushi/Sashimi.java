package com.comp301.a01sushi;

public class Sashimi extends SushiImpl {

  private String Name;

  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  private final IngredientPortion seafood_sashimi;

  public Sashimi(SashimiType type) {
    super(type);
    seafood_sashimi = Ingredients[0];
  }

  @Override
  public String getName() {
    return seafood_sashimi.getName() + " " + "sashimi";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return new IngredientPortion[] {seafood_sashimi};
  }
}
