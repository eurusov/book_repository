package eurusov.service;

import eurusov.model.Book;

public interface LibrarianService {

    void receiveBook(Book book);

    void receiveBooks(Book[] books);
}
