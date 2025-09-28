package org.example;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Order {
    private static int idGen = 0;
    private int orderId;
    private String customerName;
    private LocalDate orderDate;
    private double totalValue;
    private List<Product> products = new ArrayList<>();

    public Order() {
        this.orderId = ++idGen;
    }

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
            recalculateTotal();
        }
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            recalculateTotal();
        }
    }

    public int getProductCount() {
        return products.size();
    }

    private void recalculateTotal() {
        totalValue = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
