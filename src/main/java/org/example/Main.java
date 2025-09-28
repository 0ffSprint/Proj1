package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws ProductNotFoundException {

        List<Order> orders = new ArrayList<>();

        Order order1 = new Order();
        order1.setCustomerName("Alice");
        order1.addProduct(new PhysicalProduct("Laptop", "Dell", 1200, "Georgia", 2.5));
        order1.addProduct(new DigitalProduct("Ebook", "FJF", 30, "Online", "PDF", "Android"));
        orders.add(order1);

        Order order2 = new Order();
        order2.setCustomerName("Bob");
        order2.addProduct(new PhysicalProduct("Phone", "Samsung", 800, "USA", 0.3));
        order2.addProduct(new PhysicalProduct("Headphones", "Sony", 150, "Japan", 0.2));
        orders.add(order2);


        double normalTotal = orders.stream()
                .mapToDouble(Order::getTotalValue)
                .sum();
        System.out.println("Загальна сума (main): $" + normalTotal);


        ForkJoinPool pool = new ForkJoinPool();
        OrderValue task = new OrderValue(orders);
        double parallelTotal = pool.invoke(task);
        System.out.println("Загальна сума (ForkJoin): $" + parallelTotal);

        System.out.println("\n---- Деталі замовлень ----");
        for (Order o : orders) {
            System.out.println("Customer: " + o.getCustomerName());
            System.out.println("Total: $" + o.getTotalValue());
            System.out.println(o);
        }
    }
}
