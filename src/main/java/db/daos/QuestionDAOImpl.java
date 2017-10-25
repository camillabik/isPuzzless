package db.daos;


import db.ConnectionManager;
import db.IConnectionManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import pojo.Category;
import pojo.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAOImpl implements QuestionDAO{
    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(Question.class);

    static {
        manager = ConnectionManager.getInstance();
        PropertyConfigurator.configure("resources/log4j.properties");

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
            logger.error(e.getMessage());
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
            logger.error(e.getMessage());
        }
        return question;
    }
}






















