package db.daos;


import pojo.Answer;
import pojo.Question;

import java.util.List;

public interface AnswerDAO {
    List<Answer> getByQuestion(Question question) throws AnswerDAOImpl.AnswerDAOException;
    Answer getById() throws AnswerDAOImpl.AnswerDAOException;

}

