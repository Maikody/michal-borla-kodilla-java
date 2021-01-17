package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LibraryTestSuite {
    @Autowired
    private Library library;

    @Test
    public void testLoadFromDb() {
        library.loadFromDb();
    }

    @Test
    public void testSaveToDb() {
        library.saveToDb();
    }
}
