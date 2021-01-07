package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class PhoneOrderService implements OrderService {
    @Override
    public boolean order(User user, LocalDateTime orderDate) {
        System.out.println("Phone order placed by: " + user.getUserName() + " " + user.getUserSurname()
                + " on: " + orderDate.toString());

        return true;
    }
}
