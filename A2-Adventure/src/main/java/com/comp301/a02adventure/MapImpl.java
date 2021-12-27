package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class MapImpl implements Map {

  private int width;
  private int height;
  private int numItems;
  private Cell[][] cellGrid;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("negative width/height");
    }
    this.width = width;
    this.height = height;
    this.numItems = numItems;
    this.cellGrid = new Cell[width][height];
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x >= width || y >= height || x < 0 || y < 0) {
      throw new IndexOutOfBoundsException("requested cell out of map rangegggg");
    }
    if (cellGrid == null) {
      return null;
    }
    if (cellGrid[x] == null) {
      return null;
    }
    if (cellGrid[x][y] == null) {
      return null;
    }
    return cellGrid[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    if (position == null) {
      throw new IllegalArgumentException("position is null");
    }
    int x = position.getX();
    int y = position.getY();
    return getCell(x, y);
  }

  @Override
  public void initCell(int x, int y) {
    if (x >= width || y >= height || x < 0 || y < 0) {
      throw new IndexOutOfBoundsException("coords out of bounds");
    }
    cellGrid[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return numItems;
  }
}
