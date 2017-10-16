package db.daos;

import db.ConnectionManager;
import db.IConnectionManager;
import pojo.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private static IConnectionManager manager;

    static {
        manager = ConnectionManager.getInstance();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return category;
    }
}
