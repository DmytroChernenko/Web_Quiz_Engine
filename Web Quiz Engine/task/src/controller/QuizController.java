package controller;

import entity.Quiz;
import entity.Response;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {

    @GetMapping("/api/quiz")
    public Quiz getQuiz() {
        return new Quiz("The Java Logo", "What is depicted on the Java logo?", new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"});
    }

    @PostMapping("/api/quiz")
    public Response postQuiz(int answer) {
        if (answer == 2) {
            return new Response(true,"Congratulations, you're right!");
        } else {
            return new Response(false, "Wrong answer! Please, try again.");
        }
    }
}