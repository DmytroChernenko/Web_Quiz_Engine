package controller;

import dao.QuizDAO;
import entity.Quiz;
import entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuizDAO quizDAO;

//    @GetMapping("/api/quiz")
//    public Quiz getQuiz() {
//        return new Quiz(1, "The Java Logo", "What is depicted on the Java logo?", new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"}, 2);
//    }

//    @PostMapping("/api/quiz")
//    public Response postQuiz(int answer) {
//        if (answer == 2) {
//            return new Response(true,"Congratulations, you're right!");
//        } else {
//            return new Response(false, "Wrong answer! Please, try again.");
//        }
//    }

    @GetMapping("/api/quizzes/{id}")
    public Quiz getQuizById(@PathVariable int id) {
        return quizDAO.getQuizById(id);
    }

    @PostMapping("/api/quizzes")
    @ResponseBody
    public Quiz postQuiz(@RequestBody Quiz quiz) {
        quizDAO.save(quiz);
        return quizDAO.getQuizById(quizDAO.getAll().size());
    }

    @GetMapping("/api/quizzes")
    public List<Quiz> getQuizzes() {
        return quizDAO.getAll();
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public Response solve(@PathVariable int id, int answer) {
        int quizAnswer = quizDAO.getQuizById(id).getAnswer();
        if (answer == quizAnswer) {
            return new Response(true,"Congratulations, you're right!");
        } else {
            return new Response(false, "Wrong answer! Please, try again.");
        }
    }
}