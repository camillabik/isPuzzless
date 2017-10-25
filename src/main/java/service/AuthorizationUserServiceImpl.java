package service;

import db.daos.UserDAO;
import db.daos.UserDAOImpl;
import org.apache.log4j.Logger;
import pojo.User;
import utils.PasswordEncoder;

public class AuthorizationUserServiceImpl implements AuthorizationUserService {
    private static final Logger logger = Logger.getLogger(RegistrationUserServiceImpl.class);

    @Override
    public User authorization(String login, String password) throws Exception {
        if (login==null||password==null) throw new Exception();
        UserDAO userDAO = new UserDAOImpl();

        User user = null;
        try {
            user = userDAO.getUserByLoginAndPassword(login, PasswordEncoder.encode(password));
        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return user;

    }
}
