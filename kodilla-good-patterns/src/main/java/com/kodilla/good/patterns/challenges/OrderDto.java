package com.kodilla.good.patterns.challenges;

public class OrderDto {
    private User user;
    private boolean isAccepted;

    public OrderDto(User user, boolean isAccepted) {
        this.user = user;
        this.isAccepted = isAccepted;
    }

    public User getUser() { return user; }

    public boolean isAccepted() { return isAccepted; }

}
