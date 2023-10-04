package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void addUser(User user);

    void removeUserById(long id);

    User getUserById(long id);

    void update(long oldId, User user);

}
