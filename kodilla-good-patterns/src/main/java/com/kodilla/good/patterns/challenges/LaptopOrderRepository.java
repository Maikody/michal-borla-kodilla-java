package com.kodilla.good.patterns.challenges;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class LaptopOrderRepository implements OrderRepository {
    private static final String filename = "laptopOrders.txt";
    private static int orderNumber = 1;

    @Override
    public void createOrder(User user, LocalDateTime orderDate) {
        Path path = Paths.get(filename);

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write(String.format("%d\t%s\t%s",
                    orderNumber++,
                    user,
                    orderDate.toString()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
