package com.comp301.a08shopping;

import com.comp301.a08shopping.events.*;
import com.comp301.a08shopping.exceptions.OutOfStockException;
import com.comp301.a08shopping.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StoreImpl implements Store {
  private final String name; // name of store
  private final List<StoreObserver> observers =
      new ArrayList<>(); // active observers of store sale events
  private final List<Product> products = new ArrayList<>(); // products sold at store

  public StoreImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
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
    observers.remove(observer);
  }

  @Override
  public List<Product> getProducts() {
    List<Product> copy = new ArrayList<>(); // empty list
    for (Product p : products) {
      copy.add(p); // add copies to empty list
    }
    return copy;
  }

  @Override
  public Product createProduct(String name, double basePrice, int inventory) {
    if (name == null || basePrice < 0 || inventory < 0) {
      throw new IllegalArgumentException();
    }
    Product create_new = new ProductImpl(name, basePrice, inventory);
    products.add(create_new);
    return create_new;
  }

  @Override
  public ReceiptItem purchaseProduct(Product product) throws OutOfStockException {
    /*if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    } else {
      int index = products.indexOf(product);
      ProductImpl purchased_product =
          (ProductImpl) products.get(index); // get the product that was purchased

      notify(
          new PurchaseEvent(
              purchased_product,
              this)); // notify of event - someone purchases copy of item from store
      if (purchased_product.getInventory()
          == 0) { // if out of stock, notify of event - last copy gone, now out of stock
      }
      double price = purchased_product.product_purchased(); // price purchase was bought at
      return new ReceiptItemImpl(purchased_product.getName(), price, this.name); // creating reciept
    } */

    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    } else {
      int index = products.indexOf(product);
      ProductImpl purchased_product =
          (ProductImpl) products.get(index); // get the product that was purchased
      double price = purchased_product.product_purchased();
      notify(new PurchaseEvent(purchased_product, this));
      if (purchased_product.noStock()) {
        notify(new OutOfStockEvent(purchased_product, this));
      }
      return new ReceiptItemImpl(purchased_product.getName(), price, this.name);
    }
  }

  @Override
  public void restockProduct(Product product, int numItems) {
    if (product == null || numItems < 0) { // illegal argument if product or numItems is invalid
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException(); // if store doesn't carry product
    } else { // if store carries product
      int index = products.indexOf(product);
      ProductImpl new_stock = (ProductImpl) products.get(index);
      if (new_stock.noStock()
          && numItems > 0) { // add items back to stock and notify back in stock event
        notify(new BackInStockEvent(new_stock, this));
      }
      new_stock.addStock(numItems);
    }
  }

  @Override
  public void startSale(Product product, double percentOff) {
    if (product == null || percentOff < 0 || percentOff > 1) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    } else {
      int index = products.indexOf(product);
      ProductImpl saleProduct = (ProductImpl) products.get(index); // get sale item
      saleProduct.after_sale(percentOff); // get new sale price
      notify(new SaleStartEvent(saleProduct, this));
    }
  }

  @Override
  public void endSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    }
    int index = products.indexOf(product); // sale is ended for product
    ProductImpl revertProduct = (ProductImpl) products.get(index);
    revertProduct.base(); // turns sale price back to base price
    notify(new SaleEndEvent(revertProduct, this));
  }

  @Override
  public int getProductInventory(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    } else {
      int index = products.indexOf(product);
      ProductImpl total = (ProductImpl) products.get(index);
      return total.getInventory();
    }
  }

  @Override
  public boolean getIsInStock(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    } else {
      int index = products.indexOf(product);
      ProductImpl stock = (ProductImpl) products.get(index);
      boolean isInStock = stock.noStock();
      return isInStock == false;
    }
  }

  @Override
  public double getSalePrice(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    } else {
      int index = products.indexOf(product);
      ProductImpl sale_price = (ProductImpl) products.get(index);
      return sale_price.getSalePrice();
    }
  }

  @Override
  public boolean getIsOnSale(Product product) {
    if (product == null) {
      throw new IllegalArgumentException();
    }
    if (products.contains(product) == false) {
      throw new ProductNotFoundException();
    } else {
      int index = products.indexOf(product);
      ProductImpl isOnSale = (ProductImpl) products.get(index);
      return isOnSale.getSalePrice() == isOnSale.getBasePrice();
    }
  }

  private void notify(StoreEvent sEvent) {
    for (StoreObserver observe : observers) {
      observe.update(sEvent);
    }
  }
}
