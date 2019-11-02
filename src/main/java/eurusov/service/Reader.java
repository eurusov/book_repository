package eurusov.service;

import eurusov.model.Book;
import eurusov.model.User;
import eurusov.model.UserRole;
import eurusov.repository.PublicLibrary;

public class Reader extends User implements ReaderService {


    private PublicLibrary publicLibrary;

    public Reader(String username, String password, PublicLibrary publicLibrary) {
        super(username, password, UserRole.READER);
        this.publicLibrary = publicLibrary;
    }

    @Override
    public void takeBook(String title, String author) {
        publicLibrary.getAdminService().giveOutBook(title, author, this);
    }

    @Override
    public void returnBook(Book book) {

    }
}
