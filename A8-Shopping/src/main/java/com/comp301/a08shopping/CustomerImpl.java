package com.comp301.a08shopping;

import com.comp301.a08shopping.events.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements Customer, StoreObserver {

  private String name;
  private double budget;
  private List<ReceiptItem> receipts;

  public CustomerImpl(String name, double budget) {
    if (name == "" || name == null || budget < 0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.budget = budget;
    this.receipts = new ArrayList<ReceiptItem>();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getBudget() {
    return budget;
  }

  @Override
  public void purchaseProduct(Product product, Store store) {
    if (product == null || store == null) {
      throw new IllegalArgumentException();
    }
    if (store.getSalePrice(product) <= budget) {
      budget -= store.getSalePrice(product);
      receipts.add(store.purchaseProduct(product));
    } else {
      throw new IllegalStateException();
    }
  }

  @Override
  public List<ReceiptItem> getPurchaseHistory() {
    return receipts;
  }

  @Override
  public void update(StoreEvent event) {
    if (event instanceof BackInStockEvent) {
      System.out.println(
          event.getProduct().getName() + " is back in stock at " + event.getStore().getName());
    }
    if (event instanceof OutOfStockEvent) {
      System.out.println(
          event.getProduct().getName() + " is now out of stock at " + event.getStore().getName());
    }
    if (event instanceof PurchaseEvent) {
      System.out.println(
          "Someone purchased "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName());
    }
    if (event instanceof SaleEndEvent) {
      System.out.println(
          "The sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + " has ended");
    }
    if (event instanceof SaleStartEvent) {
      System.out.println(
          "New sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + "!");
    }
  }
}
