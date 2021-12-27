package com.comp301.a08shopping;

import com.comp301.a08shopping.events.*;
import com.comp301.a08shopping.exceptions.OutOfStockException;
import com.comp301.a08shopping.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StoreImpl implements Store {

  private String name;
  private ArrayList<StoreObserver> observers;
  private ArrayList<Product> products;
  private ArrayList<Integer> productStock;
  private ArrayList<Double> productDiscount;

  public StoreImpl(String name) {
    if (name == null || name == "") {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.observers = new ArrayList<StoreObserver>();
    this.products = new ArrayList<Product>();
    this.productStock = new ArrayList<Integer>();
    this.productDiscount = new ArrayList<Double>();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void addObserver(StoreObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    }
    observers.add(observer);
  }

  @Override
  public void removeObserver(StoreObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    }
    if (!observers.contains(observer)) {
      throw new NoSuchElementException();
    }
    observers.remove(observer);
  }

  @Override
  public List<Product> getProducts() {
    List<Product> returnList = new ArrayList<Product>();
    for (int i = 0; i < products.size(); i++) {
      returnList.add(products.get(i));
    }
    return returnList;
  }

  @Override
  public Product createProduct(String name, double basePrice, int inventory) {
    if (name == "" || name == null || basePrice < 0 || inventory < 0) {
      throw new IllegalArgumentException();
    }
    Product newProduct = new ProductImpl(name, basePrice);
    products.add(newProduct);
    productStock.add(inventory);
    productDiscount.add(0.00);
    return newProduct;
  }

  @Override
  public ReceiptItem purchaseProduct(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    }
    if (productStock.get(products.indexOf(product)) == 0) {
      throw new OutOfStockException();
    }
    int newVal = productStock.get(products.indexOf(product)) - 1;
    productStock.set(products.indexOf(product), newVal);
    notifyObservers(new PurchaseEvent(product, this));
    if (productStock.get(products.indexOf(product)) == 0) {
      notifyObservers(new OutOfStockEvent(product, this));
    }
    ReceiptItem receipt =
        new ReceiptItemImpl(product.getName(), getSalePrice(product), this.getName());
    return receipt;
  }

  @Override
  public void restockProduct(Product product, int numItems) {
    if (product == null || numItems < 0) {
      throw new IllegalArgumentException();
    }
    if (!products.contains(product)) {
      throw new ProductNotFoundException();
    }
    if (productStock.get(products.indexOf(product)) == 0) {
      notifyObservers(new BackInStockEvent(product, this));
    }
    productStock.set(
        products.indexOf(product), productStock.get(products.indexOf(product)) + numItems);
  }

  @Override
  public void startSale(Product product, double percentOff) {
    if (product == null || percentOff < 0 || percentOff > 1) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    }
    productDiscount.set(products.indexOf(product), percentOff);
    notifyObservers(new SaleStartEvent(product, this));
  }

  @Override
  public void endSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    }
    productDiscount.set(products.indexOf(product), 0.00);
    notifyObservers(new SaleEndEvent(product, this));
  }

  @Override
  public int getProductInventory(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    }
    return productStock.get(products.indexOf(product));
  }

  @Override
  public boolean getIsInStock(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    }
    if (productStock.get(products.indexOf(product)) > 0) {
      return true;
    }
    return false;
  }

  @Override
  public double getSalePrice(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    }
    return (Math.round(100 * product.getBasePrice()))
        * (1.00 - productDiscount.get(products.indexOf(product)))
        / 100;
  }

  @Override
  public boolean getIsOnSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (!products.contains(product)) {
      throw new ProductNotFoundException();
    }
    if (productDiscount.get(products.indexOf(product)) < 1) {
      return true;
    }
    return false;
  }

  private void notifyObservers(StoreEvent se) {
    for (int i = 0; i < observers.size(); i++) {
      observers.get(i).update(se);
    }
  }
}
