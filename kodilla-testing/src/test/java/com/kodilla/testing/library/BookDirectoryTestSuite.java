package com.kodilla.testing.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    private BookLibrary bookLibrary;

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @BeforeEach
    public void setup(){
        bookLibrary = new BookLibrary(libraryDatabaseMock);
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        List<Book> resultListOfBooks = new ArrayList<>();
        resultListOfBooks.add(new Book("Secrets of Alamo","John Smith", 2008));
        resultListOfBooks.add(new Book("Secretaries and Directors","Dilbert Michigan", 2012));
        resultListOfBooks.add(new Book("Secret life of programmers","Steve Wolkowitz", 2016));
        resultListOfBooks.add(new Book("Secrets of Java","Ian Tenewitch", 2010));
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        List<Book> thelistOfBooks = bookLibrary.listBooksWithCondition("An");

        assertEquals(0, thelistOfBooks.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOf(){
        List<LibraryUser> libraryUsers = generateLibraryUsers(3);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUsers.get(0)))
                .thenReturn(new ArrayList<>());
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUsers.get(1)))
                .thenReturn(generateListOfNBooks(1));
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUsers.get(2)))
                .thenReturn(generateListOfNBooks(5));

        assertEquals(0, bookLibrary.listBooksInHandsOf(libraryUsers.get(0)).size());
        assertEquals(1, bookLibrary.listBooksInHandsOf(libraryUsers.get(1)).size());
        assertEquals(5, bookLibrary.listBooksInHandsOf(libraryUsers.get(2)).size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    private List<LibraryUser> generateLibraryUsers(int numberOfUsers) {
        List<LibraryUser> usersList = new ArrayList<>();
        for (int n = 1; n <= numberOfUsers; n++) {
            LibraryUser user = new LibraryUser("FirstName " + n, "LastName " + n, "1234567890"+ n);
            usersList.add(user);
        }
        return usersList;
    }
}