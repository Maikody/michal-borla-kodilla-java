package com.kodilla.good.patterns.challenges.Food2Door;

import java.time.LocalDateTime;

public class OrderRequest {
    private Supplier supplier;
    private Product product;
    private int amount;
    private LocalDateTime orderDate;

    public OrderRequest(Supplier supplier, Product product, int amount) {
        this.supplier = supplier;
        this.product = product;
        this.amount = amount;
        this.orderDate = LocalDateTime.now();
    }

    public Supplier getSupplier() { return supplier; }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getOrderDate() { return orderDate; }

}
