package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);

    User getUserById(long id);

    void update(long oldId,User user);

    void deleteUserById(long id);
}
