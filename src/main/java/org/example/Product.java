package org.example;

public abstract class Product implements Purchasable {
    private String name;
    private String brand;
    private double price;
    private String location;

    public Product(String name, String brand, double price, String location) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        if(brand == null || brand.isBlank()) throw new IllegalArgumentException("brand is required");
        if(price <= 0) throw new IllegalArgumentException("price must be > 0");
        if(location == null || location.isBlank()) throw new IllegalArgumentException("location is required");

        this.name = name.trim();
        this.brand = brand.trim();
        this.price = price;
        this.location = location.trim();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize()");
        super.finalize();
    }

    @Override
    public double getPrice() { return price; }

    @Override
    public String getName() { return name; }

    public String getBrand() { return brand; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return String.format("--%s | Brand: %s | Price: $%.2f | Location: %s", name, brand, price, location);
    }
}
