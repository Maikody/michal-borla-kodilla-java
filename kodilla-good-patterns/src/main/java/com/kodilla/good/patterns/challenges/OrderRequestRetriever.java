package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("John", "Wayne");
        LocalDateTime orderDate = LocalDateTime.now();

        return new OrderRequest(user, orderDate);
    }

}
