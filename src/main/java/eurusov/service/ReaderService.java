package eurusov.service;

import eurusov.model.Book;

public interface ReaderService {

    void takeBook(String title, String author);

    void returnBook(Book book);

}
