package eurusov.repository;

import eurusov.model.User;

public interface UserRepository {

    boolean addUser(User user);

    boolean isUserExist(String username);

}
