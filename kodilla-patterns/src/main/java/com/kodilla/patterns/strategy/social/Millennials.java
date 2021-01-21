package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;

public class Millennials extends User {
    public Millennials(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
