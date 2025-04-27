package com.main;

import com.model.*;

public class Main {
    public static void main(String[] args) {
        // Tạo một cửa hàng
        Store store = new Store();

        // Thêm sản phẩm vào cửa hàng
        Book book1 = new Book(1, "Java Programming", 20, 50, 70, "NXB Tre", "John Doe", "ISBN123");
        Toy toy1 = new Toy(2, "Lego Set", 10, 100, 150, "Lego", "6+", "Blocks");
        Stationery pen1 = new Stationery(3, "Ballpoint Pen", 100, 2, 5, "Thiên Long", "Pen");

        store.addProduct(book1);
        store.addProduct(toy1);
        store.addProduct(pen1);

        // Hiển thị sản phẩm hiện có trong cửa hàng
        System.out.println("Danh sách sản phẩm trong cửa hàng:");
        store.displayAllProducts();

        // Tạo một khách hàng
        Customer customer = new Customer(1, "user1", "pass123", "Nguyen Van A", "0123456789", "Hanoi");

        // Khách hàng tạo giỏ hàng
        Cart cart = new Cart(customer);

        // Thêm sản phẩm vào giỏ hàng
        cart.addProduct(book1, 2);  // Mua 2 cuốn sách Java
        cart.addProduct(toy1, 1);   // Mua 1 bộ Lego

        // Hiển thị giỏ hàng
        System.out.println("\nGiỏ hàng của khách:");
        cart.displayCart();

        // Xuất hóa đơn
        System.out.println("\nHóa đơn thanh toán:");
        Invoice invoice = new Invoice(cart);
        invoice.generateInvoice();
    }
}
