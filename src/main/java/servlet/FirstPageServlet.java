package servlet;

import db.daos.UserDAO;
import db.daos.UserDAOImpl;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FirstPageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("windows-1251");
        UserDAO userDAO = new UserDAOImpl();
//        for (User user: userDAO.getAll())
//            resp.getWriter().println(user.toString());
        String login = req.getParameter("login");
        boolean flag = false;
                for (User user: userDAO.getAll()) {
                    if (user.getLogin().equals(login)) {
                        resp.getWriter().println(user.toString());
                        flag = true;
                    }
                }
                if (!flag)
                    resp.getWriter().println("Такого пользователя нет");

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAOImpl();
        List<User> users = userDAO.getAll();
        req.setAttribute("list",users);

        req.getRequestDispatcher("/hello.jsp")
                .forward(req,resp);
    }

}
