package db.daos;


import db.ConnectionManager;
import db.IConnectionManager;

import pojo.Question;
import pojo.User;

import java.sql.*;
import java.util.List;

public class QuestionDAOImpl implements QuestionDAO{
    private static IConnectionManager manager;

    static {
        manager = ConnectionManager.getInstance();
    }
    @Override
    public  List<Question> getAll() {
        List<Question> questionList = null;
        try {
            PreparedStatement statement = manager.getConnection().
                    prepareStatement("SELECT * FROM questions WHERE login = ? AND  password = ? ");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getString("name"),resultSet.getString("login"),
                        resultSet.getString("password"),  resultSet.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    }




//        Class.forName("org.postgresql.Driver");
//
//        //  Connection con = ConnectionManager.getConnection();
//        Connection con = DriverManager.getConnection(
//                "jdbc:postgresql://localhost:5432/puzzles.answers",
//                "postgres",
//                "root");
//        List<Question> questions = new ArrayList<>();
//        try (Statement statement = con.createStatement()) {
//            ResultSet resultSet =statement.executeQuery("SELECT * FROM questions;");
//
//            while (resultSet.next()){
//                Question question = new Question(resultSet.getInt("id"), (Category) resultSet.getObject("category"), resultSet.getString("name"), resultSet.getString("text"));
//                Answer answer = new Answer(question, resultSet.getString("answer"), resultSet.getBoolean("is_right"));
//              //  answer.setQuestion((Question) resultSet("question"));
//                //use another sets
//
//                questions.add(question);
//                System.out.println(question);
//            }
//        } catch (SQLException ex){
//            ex.printStackTrace();
//            //throw your own exception here
//        }
//
//        return questions;

    }
}


