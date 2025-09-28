package org.example;

import java.util.ArrayList;
import java.util.List;

public class OnlineStore {
    private static List<User> users = new ArrayList<>();

    public static User registerUser(String name) {
        User u = new User(name);
        users.add(u);
        return u;
    }

    public static List<User> getUsers() { return users; }
    public static int getUserCount() { return users.size(); }

    public static void printDetails() {
        System.out.println("=== Online Store ===");
        System.out.println("--Total users: " + users.size());
        for(User u : users) {
            u.printUser();
            System.out.println();
        }
        System.out.println("===========END===========\n");
    }

    public static int countAllProducts() {
        int total = 0;
        for(User u : users) total += u.getCart().getSize();
        return total;
    }

    public static void purchaseAll(Purchasable[] items) {
        double total = 0;
        for(Purchasable item : items) {
            total += item.getPrice();
            System.out.println("Purchased: " + item.getName() + " for $" + item.getPrice());
        }
        System.out.println("Total purchase amount: $" + total);
    }
}
