package com.comp301.a04junit;

import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/** Write unit tests for the ItemImpl class here */
public class AdeptItemTests {
  @Test
  public void itemCapNames() {
    ItemImpl item = new ItemImpl("CAPNAME");
    ItemImpl item2 = new ItemImpl("capname");
    assertTrue(item.getName() == "CAPNAME");
    assertTrue(item2.getName() == "capname");
  }

  @Test
  public void itemCapEquals() {
    ItemImpl item = new ItemImpl("cap");
    ItemImpl item2 = new ItemImpl("notCap");
    ItemImpl item3 = new ItemImpl("cap");
//    ItemImpl item4 = new ItemImpl(null);
    assertTrue(item.getName().equals("cap"));
    assertTrue(!item.equals(item2));
    assertTrue(item.equals(item3));
//    assertTrue(!item.equals(item4));
  }
  @Test
  public void itemNull() {
    ItemImpl item = new ItemImpl("cap");
//    ItemImpl item2 = new ItemImpl(null);
    ItemImpl item3 = new ItemImpl("cap");
    ItemImpl item4 = new ItemImpl("cap2");
    assertFalse("an item should equal false to another that is null",item.equals(null));
    //    ItemImpl item4 = new ItemImpl(null);
//    Assert.assertNull(item2.getName());
    assertTrue(!item.equals(item4));
    assertTrue(item.equals(item3));
//    assertTrue(!item.equals(item4));
  }
}
