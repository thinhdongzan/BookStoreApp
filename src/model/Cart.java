package model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Customer customer;
    private static Cart instance;
    private Map<Product, Integer> items = new HashMap<>();

    public static final double SHIPPING_FEE = 10.00;

    private Cart() {
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void remove(Product product) {
        items.remove(product);
    }

    public double getTotalCost() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getSellingPrice() * quantity;
        }
        return total;
    }

    public double getTotalCostWithShipping() {
        return getTotalCost() + SHIPPING_FEE;
    }

    public double getSHIPPING_FEE() {
        return SHIPPING_FEE;
    }
}
