package dao;

import entity.Quiz;
import exceptions.QuizNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizDAO {

    List<Quiz> quizzes = new ArrayList<>();

    public Quiz getQuizById(int id) throws QuizNotFoundException {
        try {
            return quizzes.get(id - 1);
        } catch (Exception e) {
            throw new QuizNotFoundException();
        }
    }

    public List<Quiz> getAll() {
        return quizzes;
    }

    public void save(Quiz quiz) {
        int id = quizzes.size() + 1;
        quiz.setId(id);
        quizzes.add(quiz);
    }
}
