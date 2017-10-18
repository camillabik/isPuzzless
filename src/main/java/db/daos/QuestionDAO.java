package db.daos;

import pojo.Category;
import pojo.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> getByCategory(Category category);

    Question getById(int id);


}
