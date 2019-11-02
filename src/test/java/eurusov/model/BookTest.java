package eurusov.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private static Book[] books;
    private static String titlePrefix = "Title";
    private static String authorPrefix = "Author";

    @BeforeAll
    static void setUpPreAll() {
        books = new Book[30];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(titlePrefix + (i + 1), authorPrefix + (i + 1));
        }
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void getId() {
        for (int i = 0; i < books.length; i++) {
            assertEquals(i + 1, books[i].getId());
        }
    }

    @Test
    void getTitleAndGetAuthor() {
        for (int i = 0; i < books.length; i++) {
//            System.out.println(books[i]);
            assertEquals(titlePrefix + (i + 1), books[i].getTitle());
            assertEquals(authorPrefix + (i + 1), books[i].getAuthor());
            assertEquals(titlePrefix + books[i].getId(), books[i].getTitle());
            assertEquals(authorPrefix + books[i].getId(), books[i].getAuthor());
        }
    }
}
