package db.daos;


import db.ConnectionManager;
import db.IConnectionManager;
import pojo.Category;
import pojo.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAOImpl implements QuestionDAO{
    private static IConnectionManager manager;
    static {
        manager = ConnectionManager.getInstance();
    }

    @Override
    public List<Question> getByCategory(Category category) {
        ArrayList<Question> questionsByCategory = new ArrayList<>();
        Question question = null;
        try {
            PreparedStatement statement = manager.getConnection().
                    prepareStatement("SELECT \n" +
                            "\tquestions.*, \n" +
                            "    categories.name AS category_name\n" +
                            "FROM questions\n" +
                            "JOIN categories\n" +
                            "ON questions.category = categories.id\n" +
                            "WHERE questions.category = ?");
            statement.setInt(1, category.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                Category category1 = new Category(resultSet.getString("category_name"));

                question = new Question(category, resultSet.getString("name"), resultSet.getString("text"));
                questionsByCategory.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionsByCategory;
    }

    @Override
    public Question getById(int id) {
        Question question = null;

        try {
            PreparedStatement statement = manager.getConnection().
                    prepareStatement("SELECT \n" +
                            "\tquestions.*, \n" +
                            "    categories.name AS category_name\n" +
                            "FROM questions\n" +
                            "JOIN categories\n" +
                            "ON questions.category = categories.id\n" +
                            "WHERE questions.id = ?\n");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                Category category = new Category(resultSet.getString("category_name"));

                question = new Question(category, resultSet.getString("name"), resultSet.getString("text"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }
}






















