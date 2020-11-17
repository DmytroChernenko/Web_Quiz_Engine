package dao;

import entity.Quiz;
import exceptions.QuizNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class QuizDAO {

    List<Quiz> quizzes = new ArrayList<>();

    public Quiz getQuizById(int id) throws QuizNotFoundException {
        try {
            return quizzes.get(id);
        } catch (Exception e) {
            throw new QuizNotFoundException();
        }
    }

    public List<Quiz> getAll() {
        return quizzes;
    }

}
