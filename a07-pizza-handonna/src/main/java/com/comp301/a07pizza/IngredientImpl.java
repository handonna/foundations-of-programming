package com.comp301.a07pizza;

public class IngredientImpl implements Ingredient {
  private final String name;
  private final boolean is_vegetarian;
  private final boolean is_vegan;

  public IngredientImpl(String name, boolean is_vegetarian, boolean is_vegan) {
    this.name = name;
    this.is_vegetarian = is_vegetarian;
    this.is_vegan = is_vegan;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isVegetarian() {
    return is_vegetarian;
  }

  @Override
  public boolean isVegan() {
    return is_vegan;
  }
}
