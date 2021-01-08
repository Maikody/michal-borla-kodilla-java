package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.HashMap;
import java.util.Map;

public class HealthyShop extends Supplier {

    private static Map<Product, Integer> supplierStock = new HashMap<>();
    private final String name;

    static {
        supplierStock.put(new Product("LIGHT YOGURT"), 1000);
        supplierStock.put(new Product("VEGETABLE MIX"), 2000);
        supplierStock.put(new Product("FISH"), 3000);
        supplierStock.put(new Product("FRESH ORANGE JUICE"), 900);
    }

    public HealthyShop() {
        this.name = getClass().getSimpleName();
    }

    @Override
    public boolean process(OrderRequest orderRequest) {
        if (orderRequest.getAmount() > 500) {
            return (sellProductFromStock(supplierStock, orderRequest.getProduct(), orderRequest.getAmount()) != 0);
        }
        System.out.println(name + " accepts min 500 qty orders!");
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
