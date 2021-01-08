package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Scanner;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter food supplier name: ");
        String foodSupplier = scanner.nextLine().trim().toUpperCase();

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

        return new OrderRequest(foodSupplier, new Product(product), quantity);
    }

}
