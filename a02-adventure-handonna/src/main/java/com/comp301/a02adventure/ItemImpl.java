package com.comp301.a02adventure;

public class ItemImpl implements Item {
  private final String item_name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException("null values for name parameter are not allowed.");
    }
    this.item_name = name;
  }

  public String getName() {
    return item_name;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    return other.toString() == item_name;
  }

  @Override
  public String toString() {
    return item_name;
  }
}
