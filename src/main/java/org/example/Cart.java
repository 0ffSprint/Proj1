package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {
    private List<Product> products;



    public Cart() { this(new ArrayList<>()); }

    public Cart(List<Product> products) {
        this.products = products != null ? products : new ArrayList<>();
    }

    public void addProduct(Product p) { if(p != null) products.add(p); }
    public void removeProduct(Product p) { products.remove(p); }

    public int getSize() { return products.size(); }

    public double getTotalPrice() {
        double total = 0;
        for(Product p : products) total += p.getPrice();
        return total;
    }

    public Product findProductByIndex(int index) throws ProductNotFoundException {
        if(index < 0 || index >= products.size()) {
            throw new ProductNotFoundException("Product index: " + index + " - not found in cart.");
        }
        return products.get(index);
    }

    public void printCart() {
        if(products.isEmpty()) {
            System.out.println("----Cart is empty");
        } else {
            System.out.println("----Cart contains " + products.size() + " products:");
            for(Product p : products) {
                System.out.println("------" + p);
            }
        }
    }
}
