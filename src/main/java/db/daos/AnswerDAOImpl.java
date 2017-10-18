package db.daos;

import db.ConnectionManager;
import db.IConnectionManager;
import pojo.Answer;
import pojo.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAOImpl implements AnswerDAO {


    public static class AnswerDAOException extends Exception {
    }

    private static IConnectionManager manager;

    static {
        manager = ConnectionManager.getInstance();
    }

    @Override
    public List<Answer> getByQuestion(Question question) throws AnswerDAOException {

        ArrayList<Answer> answersByQuestion = new ArrayList<>();
        Answer answer = null;
        try {
            PreparedStatement statement = manager.getConnection().
                    prepareStatement("SELECT\n" +
                            "answers.*,\n" +
                            "questions.id AS question_id\n" +
                            "FROM answers\n" +
                            "JOIN questions\n" +
                            "ON answers.question = questions.id\n" +
                            "WHERE answers.question = ?");
            statement.setInt(1, question.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                Question question1 = new Question(resultSet.getInt("question_id"));

                answer = new Answer(question1, resultSet.getString("text"), resultSet.getBoolean("text"));
                answersByQuestion.add(answer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answersByQuestion;
}

    @Override
    public Answer getById() throws AnswerDAOException {
        return null;
    }
}

//
//    @Override
//    public List<Answer> getAll() throws AnswerDAOException {
//
//        // Connection con = ConnectionManager.getConnection();
//
//        List<Answer> answers = new ArrayList<>();
//        try (Statement statement = manager.getConnection().createStatement()) {
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM answers;");
//
//            while (resultSet.next()){
//                Question question = new Question(resultSet.getInt("id"),  (Category) resultSet.getObject("category"), resultSet.getString("name"), resultSet.getString("text"));
//                Answer answer = new Answer(question, resultSet.getString("answer"), resultSet.getBoolean("is_right"));
//                answer.setAnswer(resultSet.getString("answer"));
//                answers.add(answer);
//            }
//        } catch (SQLException ex){
//            ex.printStackTrace();
//            throw new  AnswerDAOException();
//        }
//        return answers;
//    }
//    @Override
//    public boolean createAnswer(Answer answer) {
//        return false;
//    }