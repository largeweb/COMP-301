package com.comp301.a04junit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.comp301.a04junit.adventure.*;

import com.comp301.a04junit.alphabetizer.Alphabetizer;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

/** Write unit tests for the PlayerImpl class here */
public class JediPlayerTests {
  @Test
  public void playerTestValidation() {
    PlayerImpl player1 = new PlayerImpl("p1", 1, 1);
//    assertTrue(!testExceptionReturnType(new PlayerImpl(null, 3, 3)));
  }

//  boolean testExceptionReturnType(PlayerImpl test) {
//    try {
//      test.getName();
//    } catch (Exception e1) {
//      return true;
//    }
//    return false;
//  }

  @Test
  public void playerTestInv() {
    PlayerImpl player1 = new PlayerImpl("p1", 1, 1);
    assertTrue(player1.getInventory().getNumItems()==0);
    player1.getInventory().addItem(new ItemImpl("testItem"));
    assertTrue(player1.getInventory().getNumItems()==1);
    assertTrue(!player1.getInventory().isEmpty());
//    assertNull(new PlayerImpl(null, 0, 0));
  }

  @Test
  public void playerTestGetName() {
    PlayerImpl player1 = new PlayerImpl("p1", 1, 1);
//    PlayerImpl playerNull = new PlayerImpl(null, 1, 1);
    assertTrue(player1.getName().equals("p1"));
//    assertTrue(playerNull.getName() == null);
  }

  @Test
  public void playerTestMove() {
    PlayerImpl player1 = new PlayerImpl("p1", 1, 1);
    player1.move(Direction.EAST);
    PlayerImpl player2 = new PlayerImpl("p1", 11, 11);
    player2.move(Direction.EAST);
    assertTrue(player2.getPosition().getX() == 12);
    assertTrue(player2.getPosition().getY() == 11);
    player2.move(Direction.WEST);
    player2.move(Direction.SOUTH);
    assertTrue(player2.getPosition().getX() == 11);
    assertTrue(player2.getPosition().getY() == 10);
    player2.move(Direction.NORTH);
    player2.move(Direction.NORTH);
    assertTrue(player2.getPosition().getX() == 11);
    assertTrue(player2.getPosition().getY() == 12);
    player2.move(Direction.SOUTH);
    player2.move(Direction.WEST);
    assertTrue(player2.getPosition().getX() == 10);
    assertTrue(player2.getPosition().getY() == 11);
  }
}
