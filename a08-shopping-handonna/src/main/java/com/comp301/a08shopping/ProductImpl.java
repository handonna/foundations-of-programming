package com.comp301.a08shopping;

import com.comp301.a08shopping.exceptions.OutOfStockException;

public class ProductImpl implements Product {
  private final String name;
  private final double basePrice;
  private int inventory;
  private double salePrice;

  public ProductImpl(String name, double basePrice) {
    if (basePrice <= 0.0 || name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.basePrice = basePrice;
  }

  public ProductImpl(String name, double basePrice, int inventory) {
    if (basePrice <= 0.0 || name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.basePrice = basePrice;
    this.inventory = inventory;
    this.salePrice = basePrice;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getBasePrice() {
    return basePrice;
  }

  public boolean noStock() {
    return inventory == 0;
  }

  public double product_purchased() {
    if (inventory <= 0) {
      throw new OutOfStockException();
    } else {
      inventory = inventory - 1;
      return salePrice;
    }
  }

  public void addStock(int quantity) {
    inventory = inventory + quantity;
  }

  public void after_sale(double percent) {
    double percent_off = 1.0 - percent;
    this.salePrice = basePrice * percent_off;
  }

  public void base() {
    this.salePrice = this.basePrice;
  }

  public int getInventory() {
    return inventory;
  }

  public double getSalePrice() {
    return salePrice;
  }
}
