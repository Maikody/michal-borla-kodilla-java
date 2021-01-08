package com.kodilla.good.patterns.challenges.Food2Door;

public class SupplierFactory {
    private static final String EXTRAFOODSHOP = "EXTRAFOODSHOP";
    private static final String HEALTHYSHOP = "HEALTHYSHOP";
    private static final String GLUTENFREESHOP = "GLUTENFREESHOP";

    public static Supplier getSupplier(String supplier) {
        switch (supplier) {
            case (EXTRAFOODSHOP):
                return new ExtraFoodShop();
            case (HEALTHYSHOP):
                return new HealthyShop();
            case (GLUTENFREESHOP):
                return new GlutenFreeShop();
            default:
                System.out.println(supplier + " not found in database.");
                return null;
        }
    }

}
