package com.example.miniproject2team3.presentation;

import com.example.miniproject2team3.repository.QandARepository;
import com.example.miniproject2team3.service.Question;
import com.example.miniproject2team3.service.QuizGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GameController {

    @GetMapping("/quiz")
    public String questions(Model model, HttpSession session) {
        QuizGenerator generator = (QuizGenerator) session.getAttribute("gen");
        if (generator == null) {
            generator = new QuizGenerator();
        }

        Question q = generator.currentQuestion();
        model.addAttribute("question", q);
        session.setAttribute("gen", generator);
        return "gamepage";

    }

    @PostMapping("/answer")
    public String answer(Model model, HttpSession session, @RequestParam int answerNumber) {
        QuizGenerator generator = (QuizGenerator) session.getAttribute("gen");
        Question q = generator.currentQuestion();

        if (q.getCorrectAnswer() == answerNumber) {
            int score = generator.scoreIncrease();
            model.addAttribute("response", "Correct answer! score= " + score);
        } else {
            model.addAttribute("response", "Wrong answer! score= " + generator.getScore()
                    + "\n The correct answer is: " + q.getAnswers()[q.getCorrectAnswer()]);
        }

        if (generator.nextQuestion()) {
            if (generator.nextQuestion() && generator.getScore() >= 5) {
                model.addAttribute("finalscore", generator.getScore());
                session.invalidate();
                return "endofgamepass";
            } else {
                model.addAttribute("finalscore", generator.getScore());
                session.invalidate();
                return "endofgamefailed";
            }
        }  return "result";
    }
}
