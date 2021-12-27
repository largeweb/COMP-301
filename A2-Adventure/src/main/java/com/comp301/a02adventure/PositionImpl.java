package com.comp301.a02adventure;

public class PositionImpl implements Position {

  private int x;
  private int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public Position getNeighbor(Direction direction) {
    int nx;
    int ny;
    nx = x;
    ny = y;
    if (direction == Direction.NORTH) {
      ny += 1;
    }
    if (direction == Direction.EAST) {
      nx += 1;
    }
    if (direction == Direction.SOUTH) {
      ny -= 1;
    }
    if (direction == Direction.WEST) {
      nx -= 1;
    }
    Position neighbor = new PositionImpl(nx, ny);
    return neighbor;
  }
}
