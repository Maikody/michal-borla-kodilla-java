package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Scanner;

public class FoodOrderApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();

            switch (scanner.nextInt()) {
                case 1:
                    OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
                    OrderRequest orderRequest = orderRequestRetriever.retrieve();
                    OrderProcessor orderProcessor = new OrderProcessor(orderRequest.getSupplier(), new FoodOrderRepository());
                    OrderDto newOrderData = orderProcessor.process(orderRequest);
                    if (newOrderData.isAccepted()) {
                        System.out.println("Order placed successfully");
                    } else {
                        System.out.println("Order rejected!");
                    }
                    break;
                case 2:
                    System.out.println("Closing application...");
                    exit = true;
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n*** Food Order Application Menu ***\n\n"
                + "Press right button:\n " +
                "1 - Place new order\n " +
                "2 - Exit");
    }

}
