package db.daos;

import pojo.User;

import java.util.List;

public interface UserDAO{
    User getUserByLoginAndPassword(String login, String password);
    Boolean createUser(User user);
    List<User> getAll();
}
