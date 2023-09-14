package com.comp301.a08shopping;

import com.comp301.a08shopping.events.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements Customer {
  private final String name;
  private double budget;
  private final List<ReceiptItem> receipts;

  public CustomerImpl(String name, double budget) {
    if (name == null || budget < 0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.budget = budget;
    this.receipts = new ArrayList<ReceiptItem>();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getBudget() {
    return budget;
  }

  @Override
  public void purchaseProduct(Product product, Store store) {
    if (store == null || product == null) {
      throw new IllegalArgumentException();
    }
    if (store.getSalePrice(product) <= budget) {
      budget -= store.getSalePrice(product);
      receipts.add(store.purchaseProduct(product));
    } else {
      throw new IllegalStateException();
    }
  }

  @Override
  public List<ReceiptItem> getPurchaseHistory() {
    List<ReceiptItem> clone = new ArrayList<>();
    for (ReceiptItem i : receipts) {
      clone.add(i);
    }
    return clone;
  }

  @Override
  public void update(StoreEvent event) {
    String product_name = event.getProduct().getName();
    String store_name = event.getStore().getName();
    if (event instanceof BackInStockEvent) {
      System.out.println(product_name + " is back in stock at " + store_name);
    }
    if (event instanceof OutOfStockEvent) {
      System.out.println(product_name + " is now out of stock at " + store_name);
    }
    if (event instanceof PurchaseEvent) {
      System.out.println("Someone purchased " + product_name + " at " + store_name);
    }
    if (event instanceof SaleEndEvent) {
      System.out.println("The sale for " + product_name + " at " + store_name + " has ended");
    }
    if (event instanceof SaleStartEvent) {
      System.out.println("New sale for " + product_name + " at " + store_name + "!");
    }
  }
}
