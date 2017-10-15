package db.daos;


import pojo.Answer;

import java.util.List;

public interface AnswerDAO {
    List<Answer> getAll() throws AnswerDAOImpl.AnswerDAOException;
    boolean createAnswer(Answer answer);
}

