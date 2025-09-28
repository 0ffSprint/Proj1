package org.example;

import lombok.Getter;

@Getter
public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String name, String brand, double price, String location, double weight) {
        super(name, brand, price, location);
        if(weight <= 0) throw new IllegalArgumentException("weight must be > 0");
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + " | Weight: " + weight + "kg";
    }
}
