import db.daos.*;
import pojo.Answer;
import pojo.Category;
import pojo.Question;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws AnswerDAOImpl.AnswerDAOException {
//        CategoryDAO categoryDAO = new CategoryDAOImpl();
//        List<Category> categoryList = categoryDAO.getAll();
//        Category category= null;
//        try {
//             category= categoryDAO.getById(1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(categoryList);
//        System.out.println(category);

//        QuestionDAO questionDAO = new QuestionDAOImpl();
//        Category category = new Category(1);
//        List<Question> questionList = questionDAO.getByCategory(category);
//        Question question = null;
//        question = questionDAO.getById(1);
//
//        System.out.println(questionList);
//        System.out.println(question);

        AnswerDAO answerDAO = new AnswerDAOImpl();
        Question question = new Question(1);
        List<Answer> answerList = answerDAO.getByQuestion(question);


        System.out.println(answerList);

    }

}
