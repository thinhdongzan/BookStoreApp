package model.com.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Customer customer;
    private Map<Product, Integer> items;

    public Cart(Customer customer) {
        this.customer = customer;
        this.items = new HashMap<>();
    }

    // Thêm sản phẩm vào giỏ
    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    // Xóa sản phẩm khỏi giỏ
    public void removeProduct(Product product) {
        items.remove(product);
    }

    // Xem tất cả sản phẩm trong giỏ
    public void displayCart() {
        System.out.println("Cart for Customer: " + customer.getName());
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product: " + product.getName() + " | Quantity: " + quantity + " | Unit Price: " + product.getSellingPrice());
        }
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }
}
