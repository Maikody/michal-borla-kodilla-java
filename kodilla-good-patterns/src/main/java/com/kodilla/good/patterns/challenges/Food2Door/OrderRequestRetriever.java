package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Scanner;

public class OrderRequestRetriever {

    private static final String EXTRAFOODSHOP = "EXTRAFOODSHOP";
    private static final String HEALTHYSHOP = "HEALTHYSHOP";
    private static final String GLUTENFREESHOP = "GLUTENFREESHOP";

    public OrderRequest retrieve() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter food supplier name: ");

        Supplier supplier = null;
        while (supplier == null) {
            String foodSupplier = scanner.nextLine().trim().toUpperCase();

            switch (foodSupplier) {
                case (EXTRAFOODSHOP):
                    supplier = new ExtraFoodShop();
                    break;
                case (HEALTHYSHOP):
                    supplier = new HealthyShop();
                    break;
                case (GLUTENFREESHOP):
                    supplier = new GlutenFreeShop();
                    break;
                default:
                    System.out.println(foodSupplier + " not found in database.");
                    System.out.println("Enter different supplier");
            }
        }

        System.out.println("Enter product to order: ");
        String product = scanner.nextLine().trim().toUpperCase();

        boolean isQuantityFormatOk = false;
        int quantity = 0;
        String quantityString;
        System.out.println("Enter quantity: ");
        while (!isQuantityFormatOk) {
            quantityString = scanner.nextLine();
            try {
                quantity = Integer.parseInt(quantityString);
                isQuantityFormatOk = true;
            } catch (NumberFormatException e) {
                System.out.println("Enter numbers only!");
            }
        }

        return new OrderRequest(supplier, new Product(product), quantity);
    }

}
