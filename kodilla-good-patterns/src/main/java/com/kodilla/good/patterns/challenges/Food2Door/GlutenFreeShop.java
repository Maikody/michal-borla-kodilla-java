package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShop extends Supplier {

    private static Map<Product, Integer> supplierStock = new HashMap<>();
    private final String name;

    static {
        supplierStock.put(new Product("GLUTEN FREE WHEAT"), 300);
        supplierStock.put(new Product("GLUTEN FREE PASTA"), 800);
        supplierStock.put(new Product("GLUTEN FREE MUESLI"), 200);
        supplierStock.put(new Product("GLUTEN FREE BREAD"), 1500);
    }

    public GlutenFreeShop() {
        this.name = getClass().getSimpleName();
    }

    @Override
    public boolean process(OrderRequest orderRequest) {
        if (orderRequest.getProduct().getName().matches("(Gluten Free)")) {
            return (sellProductFromStock(supplierStock, orderRequest.getProduct(), orderRequest.getAmount()) != 0);
        }
        System.out.println(name + " accepts orders only for gluten free products!");
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

}
