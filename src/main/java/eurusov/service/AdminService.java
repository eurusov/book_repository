package eurusov.service;

import eurusov.model.Book;
import eurusov.model.User;
import eurusov.model.UserRole;

public interface AdminService {

    Book giveOutBook(String title, String author, User user);

    void takeBackBook(Book book);

    boolean registerNewUser(String username, String password, UserRole userRole);

}
