package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class LaptopOrderService implements OrderService {
    @Override
    public boolean order(User user, LocalDateTime orderDate) {
        System.out.println("Laptop order placed by: " + user.getUserName() + " " + user.getUserSurname()
                + " on: " + orderDate.toString());

        return true;
    }
}
