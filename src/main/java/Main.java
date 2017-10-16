import db.daos.CategoryDAO;
import db.daos.CategoryDAOImpl;
import pojo.Category;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        List<Category> categoryList = categoryDAO.getAll();
        Category category= null;
        try {
             category= categoryDAO.getById(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(categoryList);
        System.out.println(category);


    }

}
