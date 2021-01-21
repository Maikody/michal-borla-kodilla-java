package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    void testDefaultInvestingStrategies() {
        User yGeneration = new YGeneration("Steven Jobs");
        User millennial = new Millennials("John Doe");
        User zGeneration = new ZGeneration("Tim Biden");

        assertEquals("sharing post on Twitter", yGeneration.sharePost());
        assertEquals("sharing post on Facebook", millennial.sharePost());
        assertEquals("sharing post on Snapchat", zGeneration.sharePost());
    }

    @Test
    void testIndividualInvestingStrategy() {
        User bob = new Millennials("Bob Brown");
        bob.setSocialPublisher(new SnapchatPublisher());

        assertEquals("sharing post on Snapchat", bob.sharePost());
    }
}
