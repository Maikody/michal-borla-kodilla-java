package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        Library library = new Library("Library 1");
        for (int i = 1; i < 11; i++) {
            library.books.add(new Book("Book " + i, "Author " + i, LocalDate.now().plusDays(i)));
        }

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Library deeplyClonedLibrary = null;
        try {
            deeplyClonedLibrary = library.deepCopy();
            deeplyClonedLibrary.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        library.getBooks().clear();

        assertEquals(0, library.getBooks().size());
        assertEquals(0, clonedLibrary.getBooks().size());
        assertEquals(10, deeplyClonedLibrary.getBooks().size());
    }

}
