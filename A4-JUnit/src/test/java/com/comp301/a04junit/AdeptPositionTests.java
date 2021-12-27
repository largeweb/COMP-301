package com.comp301.a04junit;

import static org.junit.Assert.assertTrue;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.Position;
import com.comp301.a04junit.adventure.PositionImpl;

import org.junit.Test;

/** Write unit tests for the PositionImpl class here */
public class AdeptPositionTests {
  @Test
  public void unitTestFields() {
    int x = 3;
    int y = 3;
    Position newPos1 = new PositionImpl(0, 0);
    Position newPos2 = new PositionImpl(4, 5);
    Position newPos3 = new PositionImpl(2, -3);
    Position newPos4 = new PositionImpl(-2, 100);
    Position newPos5 = new PositionImpl(x,y);
    assertTrue(newPos1.getX()==0);
    assertTrue(newPos1.getY()==0);
    assertTrue(newPos2.getX()==4);
    assertTrue(newPos2.getY()==5);
    assertTrue(newPos5.getNeighbor(Direction.EAST).getX()==4);
    newPos5 = new PositionImpl(7,7);
    assertTrue(x==3);
    assertTrue(y==3);
    assertTrue(newPos2.getNeighbor(Direction.EAST).getX() == 5);
    assertTrue(newPos2.getNeighbor(Direction.WEST).getX() == 3);
    assertTrue(newPos2.getNeighbor(Direction.NORTH).getY() == 6);
    assertTrue(newPos2.getNeighbor(Direction.SOUTH).getY() == 4);
//    assertTrue(newPos3.getX()==2);
//    assertTrue(newPos3.getY()==-3);
//    assertTrue(newPos4.getX()==-2);
//    assertTrue(newPos4.getY()==100);
  }
}
