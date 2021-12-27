package com.comp301.a02adventure;

public class PlayerImpl implements Player {

  private Position playerPos;
  private String name;
  private Inventory inv;

  public PlayerImpl(String name, int startx, int starty) {
    if (name == null) {
      throw new IllegalArgumentException("null name");
    }
    this.name = name;
    this.playerPos = new PositionImpl(startx, starty);
    this.inv = new InventoryImpl();
  }

  @Override
  public Position getPosition() {
    return playerPos;
  }

  @Override
  public Inventory getInventory() {
    return inv;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void move(Direction direction) {
    int newx;
    int newy;
    newx = playerPos.getX();
    newy = playerPos.getY();
    if (direction == Direction.NORTH) {
      newy += 1;
    }
    if (direction == Direction.EAST) {
      newx += 1;
    }
    if (direction == Direction.SOUTH) {
      newy -= 1;
    }
    if (direction == Direction.WEST) {
      newx -= 1;
    }

    playerPos = new PositionImpl(newx, newy);
  }
}
