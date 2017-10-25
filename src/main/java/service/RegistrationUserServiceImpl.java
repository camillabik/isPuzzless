package service;

import db.daos.UserDAO;
import db.daos.UserDAOImpl;
import org.apache.log4j.Logger;
import pojo.User;


public class RegistrationUserServiceImpl implements RegistrationUserService{

    private static final Logger logger = Logger.getLogger(RegistrationUserServiceImpl.class);
    private static UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registrationUser(User user) throws Exception {
        if (user.getLogin()==null||user.getPassword()==null||user.getName()==null) throw new Exception();
  //      UserDAO userDAO = new UserDAOImpl();
        userDAO.createUser(user);
    }

}
