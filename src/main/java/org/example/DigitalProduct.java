package org.example;

import lombok.Getter;

@Getter
public class DigitalProduct extends Product {
    private String fileFormat;
    private String platform;

    public DigitalProduct(String name, String brand, double price, String location, String fileFormat, String platform) {
        super(name, brand, price, location);
        if(fileFormat == null || fileFormat.isBlank()) throw new IllegalArgumentException("fileFormat is required");
        this.fileFormat = fileFormat;
        this.platform = platform;
    }

    @Override
    public String toString() {
        return super.toString() + " | Format: " + fileFormat+ " | Platform: " + platform;
    }
}
