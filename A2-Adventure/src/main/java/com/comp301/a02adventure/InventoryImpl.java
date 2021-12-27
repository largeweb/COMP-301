package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {

  private List<Item> itemsList;

  public InventoryImpl() {
    itemsList = new ArrayList<>();
  }

  @Override
  public boolean isEmpty() {
    if (itemsList.isEmpty()) {
      return true;
    }
    return false;
  }

  @Override
  public int getNumItems() {
    return itemsList.size();
  }

  @Override
  public List<Item> getItems() {
    List<Item> clone = new ArrayList<>();
    for (int i = 0; i < itemsList.size(); i++) {
      clone.add(itemsList.get(i));
    }
    return clone;
  }

  @Override
  public void addItem(Item item) {
    itemsList.add(item);
  }

  @Override
  public void removeItem(Item item) {
    itemsList.remove(item);
  }

  @Override
  public void clear() {
    itemsList.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    for (int i = 0; i < other.getNumItems(); i++) {
      itemsList.add(other.getItems().get(i));
    }
    other.clear();
  }
}
