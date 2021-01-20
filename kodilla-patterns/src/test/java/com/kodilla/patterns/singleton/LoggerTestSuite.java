package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    void getLastLog() {
        Logger logger = Logger.INSTANCE;

        logger.log("10110010");

        assertEquals("10110010", logger.getLastLog());
    }
}
