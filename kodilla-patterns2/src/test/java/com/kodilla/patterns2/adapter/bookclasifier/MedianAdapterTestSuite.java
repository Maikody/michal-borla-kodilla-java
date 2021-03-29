package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedian() {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Secrets of Alamo","John Smith", 2008, "AB1b2C3"));
        bookSet.add(new Book("Secretaries and Directors","Dilbert Michigan", 2012, "AC1b2C3"));
        bookSet.add(new Book("Secret life of programmers","Steve Wolkowitz", 2016, "AD1b2C3"));
        bookSet.add(new Book("Secrets of Java","Ian Tenewitch", 2010, "AE1b2C3"));
        bookSet.add(new Book("Effective Java","Joshua Bloch", 2018, "AE1b2C3"));

        MedianAdapter medianAdapter = new MedianAdapter();
        int publicationYearMedian = medianAdapter.publicationYearMedian(bookSet);

        assertEquals(2012, publicationYearMedian);
    }
}