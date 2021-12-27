package com.comp301.a02adventure;

public final class ItemImpl implements Item {

  private String itemName;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.itemName = name;
  }

  public String getName() {
    return itemName;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (other.toString() == itemName) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return itemName;
  }
}
