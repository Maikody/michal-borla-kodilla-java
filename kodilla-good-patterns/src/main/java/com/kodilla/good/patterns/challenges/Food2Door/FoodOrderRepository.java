package com.kodilla.good.patterns.challenges.Food2Door;

import java.io.*;

public class FoodOrderRepository {
    private static final String filename = "foodOrders.txt";

    public void createOrder(OrderRequest orderRequest) {
        File file= new File(filename);

        try (FileWriter fileWriter = new FileWriter(file,true)) {
            fileWriter.write(String.format("%s\t\t%s\t%d\t\t%s\n",
                    orderRequest.getSupplier().getName(),
                    orderRequest.getProduct().getName(),
                    orderRequest.getAmount(),
                    orderRequest.getOrderDate()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
