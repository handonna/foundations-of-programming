package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private final List<Item> items;

  public InventoryImpl() {
    items = new ArrayList<>();
  }

  @Override
  public boolean isEmpty() {
    return items.isEmpty();
  }

  @Override
  public int getNumItems() {
    return items.size();
  }

  @Override
  public List<Item> getItems() {
    List<Item> inventory = new ArrayList<>();
    for (int i = 0; i < items.size(); i = i + 1) {
      inventory.add(items.get(i));
    }
    return inventory;
  }

  @Override
  public void addItem(Item item) {
    items.add(item);
  }

  @Override
  public void removeItem(Item item) {
    items.remove(item);
  }

  @Override
  public void clear() {
    items.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    for (int k = 0; k < other.getNumItems(); k = k + 1) {
      items.add(other.getItems().get(k));
    }
    other.clear();
  }
}
