package db.daos;

import db.ConnectionManager;
import db.IConnectionManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import pojo.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(Category.class);


    static {
        manager = ConnectionManager.getInstance();
        PropertyConfigurator.configure("resources/log4j.properties");


    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new  ArrayList<>();
        try {
            Statement statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM categories");

            while (resultSet.next()) {
                Category category = new Category(resultSet.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return categories;
    }


    @Override
    public Category getById(int id)  {
        Category category = null;

        try {
            PreparedStatement statement = manager.getConnection().
                    prepareStatement("SELECT * FROM categories WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                category = new Category(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return category;
    }
}
