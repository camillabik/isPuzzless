package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import db.daos.UserDAOImpl;
import org.apache.log4j.Logger;
import pojo.Answer;
import pojo.User;
import db.daos.UserDAO;
import service.RegistrationUserService;
import service.RegistrationUserServiceImpl;
import utils.PasswordEncoder;

public class RegistrationServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(User.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(name,login,password);

        RegistrationUserService registrationUserService = new RegistrationUserServiceImpl();
        try {
            registrationUserService.registrationUser(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }
}


