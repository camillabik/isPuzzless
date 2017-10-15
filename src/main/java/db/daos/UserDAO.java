package db.daos;


import pojo.User;

public interface UserDAO {
    User getUserByLoginAndPassword(String login, String password);
    Boolean createUser(User user);
}
