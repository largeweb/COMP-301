package com.comp301.a04junit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;
import com.comp301.a04junit.adventure.Inventory;
import com.comp301.a04junit.adventure.InventoryImpl;

import org.junit.Test;

/** Write unit tests for the InventoryImpl class here */
public class JediInventoryTests {
  @Test
  public void jediInvFields() {
    InventoryImpl newInv1 = new InventoryImpl();
    assertTrue(newInv1.isEmpty());
    assertTrue(newInv1.getNumItems() == 0);
    newInv1.addItem(new ItemImpl("Item1"));
    assertTrue(!newInv1.isEmpty());
    assertTrue(newInv1.getNumItems() == 1);
  }

  @Test
  public void jediInvEmpty() {
    InventoryImpl newInv1 = new InventoryImpl();
    assertTrue(newInv1.isEmpty());
    newInv1.addItem(new ItemImpl("Item1"));
    assertTrue(!newInv1.isEmpty());
  }

  @Test
  public void jediInvAddItem() {
    InventoryImpl newInv1 = new InventoryImpl();
    assertTrue(newInv1.isEmpty());
    newInv1.addItem(new ItemImpl("test"));
    assertTrue(!newInv1.isEmpty());
    assertTrue(newInv1.getNumItems() == 1);
    assertTrue(!newInv1.getItems().isEmpty());
    newInv1.addItem(new ItemImpl("test2"));
    assertTrue(!newInv1.isEmpty());
    assertTrue(newInv1.getNumItems() == 2);
  }

  @Test
  public void jediInvRemoveItem() {
    InventoryImpl newInv1 = new InventoryImpl();
    assertTrue(newInv1.isEmpty());
    newInv1.addItem(new ItemImpl("test"));
    newInv1.addItem(new ItemImpl("test2"));
    assertTrue(newInv1.getNumItems() == 2);
    newInv1.removeItem(newInv1.getItems().get(1));
    assertTrue(newInv1.getNumItems() == 1);
  }

  @Test
  public void jediInvClear() {
    InventoryImpl newInv1 = new InventoryImpl();
    newInv1.addItem(new ItemImpl("test"));
    newInv1.addItem(new ItemImpl("test2"));
    assertTrue(newInv1.getNumItems() == 2);
    newInv1.clear();
    assertTrue(newInv1.isEmpty());
  }

  @Test
  public void jediInvTransferFrom() {
    InventoryImpl newInv1 = new InventoryImpl();
    InventoryImpl newInv2 = new InventoryImpl();
    newInv1.addItem(new ItemImpl("test"));
    newInv1.addItem(new ItemImpl("test2"));
    newInv2.addItem(new ItemImpl("testOther"));
    newInv2.addItem(new ItemImpl("testOther2"));
    assertTrue(newInv1.getNumItems() == 2);
    assertTrue(newInv2.getNumItems() == 2);
    newInv1.transferFrom(newInv2);
    assertTrue(newInv2.isEmpty());
    assertTrue(newInv1.getNumItems() == 4);
    newInv1.transferFrom(null);
    assertTrue(newInv1.getNumItems() == 4);
  }
}
