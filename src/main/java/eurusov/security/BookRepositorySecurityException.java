package eurusov.security;

public class BookRepositorySecurityException extends RuntimeException {
    public BookRepositorySecurityException(String e) {
        System.out.println(e);
        printStackTrace();
        System.exit(-1);
    }
}
