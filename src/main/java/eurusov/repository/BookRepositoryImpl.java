package eurusov.repository;

public class BookRepositoryImpl extends SimpleBookCollection implements BookRepository {
    private static BookRepository bookRepository;

    private BookRepositoryImpl() {
    }

    public static BookRepository getInstance() {
        if (bookRepository == null) {
            bookRepository = new BookRepositoryImpl();
        }
        return bookRepository;
    }

}
