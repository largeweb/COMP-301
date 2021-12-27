package com.comp301.a02adventure;

public class CellImpl implements Cell {

  private Position cellPos;
  private String name;
  private String description;
  private Inventory chest;
  private boolean visited;
  private boolean hasChest;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null || description == null) {
      throw new IllegalArgumentException("name or description are bad");
    }
    cellPos = new PositionImpl(x, y);
    this.name = name;
    this.description = description;
    this.visited = false;
    if (hasChest) {
      chest = new InventoryImpl();
    }
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public Position getPosition() {
    return cellPos;
  }

  @Override
  public Inventory getChest() {
    return chest;
  }

  @Override
  public boolean getIsVisited() {
    return visited;
  }

  @Override
  public boolean hasChest() {
    return hasChest;
  }

  @Override
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("name is null");
    }
    this.name = name;
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("description is null");
    }
    this.description = description;
  }

  @Override
  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException("chest is null");
    }
    hasChest = true;
    this.chest = chest;
  }

  @Override
  public void visit() {
    visited = true;
  }
}
