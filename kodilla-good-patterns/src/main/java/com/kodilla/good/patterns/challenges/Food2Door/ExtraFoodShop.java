package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop extends Supplier {

    private static Map<Product, Integer> supplierStock = new HashMap<>();
    private final String name;

    static {
        supplierStock.put(new Product("ITALIAN HAM"), 1000);
        supplierStock.put(new Product("MOZZARELLA"), 5000);
        supplierStock.put(new Product("MILK"), 200);
        supplierStock.put(new Product("RED WINE"), 700);
    }

    public ExtraFoodShop() {
        this.name = getClass().getSimpleName();
    }

    @Override
    public boolean process(OrderRequest orderRequest) {
        return sellProductFromStock(supplierStock, orderRequest.getProduct(), orderRequest.getAmount()) != 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
