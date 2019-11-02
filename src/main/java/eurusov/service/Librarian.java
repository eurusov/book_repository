package eurusov.service;

import eurusov.model.Book;
import eurusov.model.User;
import eurusov.model.UserRole;
import eurusov.repository.BookRepository;

public class Librarian extends User implements LibrarianService {

    private BookRepository bookRepository;

    public Librarian(String username, String password, BookRepository bookRepository) {
        super(username, password, UserRole.LIBRARIAN);
        this.bookRepository = bookRepository;
    }

    @Override
    public void receiveBook(Book book) {
        bookRepository.add(book);
    }

    @Override
    public void receiveBooks(Book[] books) {
        bookRepository.addBooks(books);
    }
}
