package servlet;

import db.daos.UserDAO;
import db.daos.UserDAOImpl;
import org.apache.log4j.Logger;
import pojo.Answer;
import pojo.User;
import service.AuthorizationUserService;
import service.AuthorizationUserServiceImpl;
import service.RegistrationUserService;
import service.RegistrationUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationServlet extends HttpServlet{
    private static final Logger logger = Logger.getLogger(Answer.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        AuthorizationUserService authorizationUserService = new AuthorizationUserServiceImpl();
        try {
           User user = authorizationUserService.authorization(login, password);
            req.getSession().setAttribute("authorized", true);
            req.getSession().setAttribute("user", user);

        } catch (Exception e) {
            logger.error(e.getMessage());
        }


        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("windows-1251");
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }
}

