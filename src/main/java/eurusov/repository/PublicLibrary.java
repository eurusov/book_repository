package eurusov.repository;

import eurusov.service.AdminService;
import eurusov.service.LibrarianService;

public final class PublicLibrary {
    private static PublicLibrary instance;

    private BookRepository bookRepository;
    private UserRepository userRepository;
    private AdminService adminService;
    private LibrarianService librarianService;

    private PublicLibrary(BookRepository bookRepo,
                          UserRepository userRepo,
                          AdminService adminSrv,
                          LibrarianService librarianSrv) {
        bookRepository = bookRepo;
        userRepository = userRepo;
        adminService = adminSrv;
        librarianService = librarianSrv;
    }

    public static PublicLibrary getInstance(BookRepository bookRepository,
                                            UserRepository userRepository,
                                            AdminService adminService,
                                            LibrarianService librarianService) {
        if (instance == null) {
            instance = new PublicLibrary(bookRepository, userRepository, adminService, librarianService);
        }
        return instance;
    }

    public static PublicLibrary getInstance() {
        return instance;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public LibrarianService getLibrarianService() {
        return librarianService;
    }
}
