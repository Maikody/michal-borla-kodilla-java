package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderDto {
    private Supplier supplier;
    private Product product;
    private int amount;
    private boolean isAccepted;

    public OrderDto(Supplier supplier, Product product, int amount, boolean isAccepted) {
        this.supplier = supplier;
        this.product = product;
        this.amount = amount;
        this.isAccepted = isAccepted;
    }

    public Supplier getSupplier() { return supplier; }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isAccepted() { return isAccepted; }

}
