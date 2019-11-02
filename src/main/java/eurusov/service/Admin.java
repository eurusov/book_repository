package eurusov.service;

import eurusov.model.Book;
import eurusov.model.User;
import eurusov.model.UserRole;
import eurusov.repository.BookRepository;
import eurusov.repository.UserRepository;

public class Admin extends User implements AdminService {
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public Admin(String username, String password, BookRepository bookRepository) {
        super(username, password, UserRole.ADMIN);
        this.bookRepository = bookRepository;
    }

    @Override
    public Book giveOutBook(String title, String author, User user) {
        if (!userRepository.isUserExist(user.getUsername())) {
            userRepository.addUser(user);
        }
        Book book = bookRepository.giveToReader(title, author);
        if (book != null) {
            book.setAvailable(false);
            return book;
        }
        return null;
    }

    @Override
    public void takeBackBook(Book book) {
        bookRepository.getById(book.getId()).setAvailable(true);
    }

    @Override
    public boolean registerNewUser(String username, String password, UserRole userRole) {
        return userRepository.addUser(new User(username, password, userRole));
    }
}
