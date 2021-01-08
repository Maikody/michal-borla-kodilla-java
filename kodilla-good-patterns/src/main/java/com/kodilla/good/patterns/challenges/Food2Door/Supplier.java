package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Map;

public abstract class Supplier {

    public abstract boolean process(OrderRequest orderRequest);
    public abstract String getName();

    public int sellProductFromStock(Map<Product, Integer> shopStock, Product product, int amount) {
        if (shopStock.containsKey(product) && amount > 0) {
            if (shopStock.get(product) - amount > 0) {
                shopStock.put(product, shopStock.get(product) - amount);
                return amount;
            }
            System.out.println("Supplier does not have such quantity of this product in stock!\n" +
                               "Available amount: " + shopStock.get(product));
            return 0;
        }
        System.out.println("Product not found in supplier stock!");
        return 0;
    }

}
