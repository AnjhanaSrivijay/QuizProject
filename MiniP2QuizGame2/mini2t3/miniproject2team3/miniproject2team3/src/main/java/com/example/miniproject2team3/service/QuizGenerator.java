package com.example.miniproject2team3.service;


import com.example.miniproject2team3.repository.QandARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizGenerator {

    private QandARepository repository;
    List<Question> questionList;
    int score=0;
    int currentQuestion=0;


    public QuizGenerator() {
        this.repository = new QandARepository();
        this.questionList= repository.getQuestions();
    }

    public Question currentQuestion(){
        return questionList.get(currentQuestion);
    }
    public  boolean nextQuestion(){
       currentQuestion++;
       return currentQuestion >=questionList.size();

    }

    public List<Question> displayQuestions(){
        return repository.getQuestions();

    }

    public int scoreIncrease() {
        score++;
        return score;

    }

    public int getScore() {
        return score;
    }
    // public String checkAnswer(QandARepository questions){
     //   if(correctAnswer[] == userrinput)
   // }


}
