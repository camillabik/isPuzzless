package db.daos;

import pojo.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDAO {
    List<Category> getAll();
    Category getById(int id) throws SQLException;
}
