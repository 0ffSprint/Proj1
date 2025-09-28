package org.example;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class OrderValue  extends RecursiveTask<Double> {
    private final List<Order> orders;
    private static final int hold = 2; // якщо замовлень мало — рахуємо напряму

    public OrderValue(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    protected Double compute() {
        if (orders.size() <= hold) {
            double total = 0;
            for (Order o : orders) {
                total += o.getTotalValue();
            }
            return total;
        } else {
            int mid = orders.size() / 2;
            OrderValue left = new OrderValue(orders.subList(0, mid));
            OrderValue right = new OrderValue(orders.subList(mid, orders.size()));

            left.fork();
            double rightResult = right.compute();
            double leftResult = left.join();

            return leftResult + rightResult;
        }
    }
}
