package com.kodilla.testing.library;

import java.util.List;

public interface LibraryDatabase {
    List<Book> listBooksWithCondition(String titleFragment);
    List<Book> listBooksInHandsOf(LibraryUser libraryUser);
    boolean rentABook(LibraryUser libraryUser, String title);
    int returnBooks(LibraryUser libraryUser);

}
