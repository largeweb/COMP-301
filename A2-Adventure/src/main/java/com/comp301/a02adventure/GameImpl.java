package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {

  private Player player;
  private Map map;

  public GameImpl(Map map, Player player) {
    if (player == null || map == null) {
      throw new IllegalArgumentException("null map/player");
    }
    this.player = player;
    this.map = map;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    if (player.getInventory().getItems().size() == map.getNumItems()) {
      return true;
    }
    return false;
  }

  @Override
  public void printCellInfo() {
    System.out.println("Location: " + map.getCell(player.getPosition()).getName());
    System.out.println(map.getCell(player.getPosition()).getDescription());
    if (map.getCell(player.getPosition()).getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (map.getCell(player.getPosition()).hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    map.getCell(player.getPosition()).visit();
  }

  @Override
  public void openChest() {
    if (!map.getCell(player.getPosition()).hasChest()) {
      System.out.println("No chest to open, sorry!");
    } else {
      if (map.getCell(player.getPosition()).getChest().isEmpty()) {
        System.out.println("The chest is empty.");
      } else {
        System.out.println(
            "You collected these items: "
                + map.getCell(player.getPosition()).getChest().getItems());
        player.getInventory().transferFrom(map.getCell(player.getPosition()).getChest());
      }
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    int newx;
    int newy;
    newx = player.getPosition().getX();
    newy = player.getPosition().getY();
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
    if (newx < map.getWidth() && newx >= 0 && newy < map.getHeight() && newy >= 0) {
      if (map.getCell(newx, newy) != null) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void move(Direction direction) {
    if (canMove(direction)) {
      player.move(direction);
      printCellInfo();
    } else {
      System.out.println("You can't go that way! Try another direction.");
    }
  }
}
