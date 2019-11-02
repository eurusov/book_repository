package eurusov.repository;

import eurusov.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBookCollectionTest {
    final static int TEST_ARRAY_SIZE = 2;
    private static Book[] books = new Book[TEST_ARRAY_SIZE];
    private static String titlePrefix = "Title";
    private static String authorPrefix = "Author";
    private static BookCollection bookCollection;
    private static Random randGen = new Random(TEST_ARRAY_SIZE);


    @BeforeEach
    void setUp() {
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(titlePrefix + i, authorPrefix + i);
        }
        bookCollection = new SimpleBookCollection();
        for (Book book : books) {
            bookCollection.add(book);
        }
    }

    @Test
    void add() {
        System.out.println(bookCollection);
        assertEquals(books.length, bookCollection.getSize());
        bookCollection.remove(3);
        System.out.println(bookCollection);
//        for (int i = 0; i < 33; i++) {
//            bookCollection.remove(randGen.nextInt(books.length - i - 1));
//        }
//        System.out.println(bookCollection);
//        assertEquals(books.length - 33, bookCollection.getSize());
    }

    @Test
    void getAll() {
    }
}
