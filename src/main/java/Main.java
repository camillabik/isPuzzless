import db.daos.AnswerDAO;
import db.daos.AnswerDAOImpl;
import pojo.Answer;
import pojo.Question;

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
//
//        QuestionDAO questionDAO = new QuestionDAOImpl();
//        Category category1 = new Category(1);
//        List<Question> questionList = questionDAO.getByCategory(category);
//        Question question = null;
//        question = questionDAO.getById(1);
//
//        System.out.println(questionList);
//        System.out.println(question);
//
        AnswerDAO answerDAO = new AnswerDAOImpl();
        Question question1 = new Question(1);
        List<Answer> answerList = answerDAO.getByQuestion(question1);


        System.out.println(answerList);
//
    }
}
