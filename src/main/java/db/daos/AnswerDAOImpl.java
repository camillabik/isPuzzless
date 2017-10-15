package db.daos;

import db.ConnectionManager;
import db.IConnectionManager;
import pojo.Answer;
import pojo.Category;
import pojo.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAOImpl implements AnswerDAO{


    public static class AnswerDAOException extends Exception{}

    private static IConnectionManager manager;

    static {
        manager = ConnectionManager.getInstance();
        }

    @Override
    public List<Answer> getAll() throws AnswerDAOException {

       // Connection con = ConnectionManager.getConnection();

        List<Answer> answers = new ArrayList<>();
        try (Statement statement = manager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM answers;");

            while (resultSet.next()){
                Question question = new Question(resultSet.getInt("id"), (Category) resultSet.getObject("category"), resultSet.getString("name"), resultSet.getString("text"));
                Answer answer = new Answer(question, resultSet.getString("answer"), resultSet.getBoolean("is_right"));
                answer.setAnswer(resultSet.getString("answer"));
                answers.add(answer);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new  AnswerDAOException();
        }
        return answers;
    }
    @Override
    public boolean createAnswer(Answer answer) {
        return false;
    }


}


//public static class StudentDAOException extends Exception {
//}
//
//    private static IConnectionManager manager;
//
//static {
//        manager = ConnectionManagerPostresSQL.getInstance();
//        }
//
//public static List<Student> getAll() throws StudentDAOException {
//        List<Student> studentList = new ArrayList<>();
//
//        try {
//        Statement statement = manager.getConnection().createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
//
//        while (resultSet.next()) {
//        Student student = new Student(
//        (short) resultSet.getInt("id"),
//        resultSet.getString("first_name"),
//        resultSet.getString("second_name"),
//        resultSet.getString("last_name"),
//        resultSet.getDate("birth_date").toLocalDate().toEpochDay());
//
//        studentList.add(student);
//        }
//        } catch (SQLException e) {
//        e.printStackTrace();
//        throw new StudentDAOException();
//        }
//        return studentList;
//        }