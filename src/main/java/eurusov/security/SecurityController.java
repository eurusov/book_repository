package eurusov.security;

import eurusov.service.AdminService;
import eurusov.service.Admin;
import eurusov.service.LibrarianService;
import eurusov.service.Librarian;
import eurusov.model.User;
import eurusov.model.UserRole;
import eurusov.repository.BookRepository;

public class SecurityController {
    private static LibrarianService instance;

    public static LibrarianService getLibrarianControllerInstance(BookRepository bookRepository, User principal) throws IllegalAccessException {
        if (!principal.getUserRole().equals(UserRole.LIBRARIAN)) {
            throw new IllegalAccessException("Not a librarian trying to get librarian rights!");
        }
        return null;
    }

    public static AdminService getAdminControllerInstance(BookRepository bookRepository, User principal) {
        if (!principal.getUserRole().equals(UserRole.ADMIN)) {
            throw new BookRepositorySecurityException("Not admin trying to get admin rights!");
        }
        return null;
    }
}
