package eurusov.repository;

import eurusov.model.User;

import java.util.Arrays;
import java.util.stream.IntStream;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepository instance;

    private User[] users = new User[10];
    private int size;

    private UserRepositoryImpl() {
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    @Override
    public boolean addUser(User user) {
        if (!isUserExist(user.getUsername())) {
            if (size == users.length) {
                users = Arrays.copyOf(users, users.length * 2);
            }
            users[size++] = user;
            return true;
        }
        return false;
    }

    @Override
    public boolean isUserExist(String username) {
        return IntStream.range(0, size).anyMatch(i -> users[i].getUsername().equals(username));
    }
}
