package com.kodilla.spring.reader;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ReaderTestSuite {
    @Test
    void testRead() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        Reader reader = context.getBean(Reader.class);

        reader.read();
    }

    @Test
    void testConditional() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);

        boolean book2Exists = context.containsBean("book2");

        System.out.println("Book 2 was found in the container: " + book2Exists);
    }
}
