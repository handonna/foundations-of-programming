package com.comp301.a07pizza;

public class Sauce extends IngredientImpl {
  private Sauce(String name, boolean is_vegetarian, boolean is_vegan) {
    super(name, is_vegetarian, is_vegan);
  }

  public static final Sauce TOMATO = new Sauce("tomato", true, true);
  public static final Sauce BARBECUE = new Sauce("barbecue", true, true);
  public static final Sauce PESTO = new Sauce("pesto", true, true);
  public static final Sauce ALFREDO = new Sauce("alfredo", true, false);
  public static final Sauce RANCH = new Sauce("ranch", true, false);
}
