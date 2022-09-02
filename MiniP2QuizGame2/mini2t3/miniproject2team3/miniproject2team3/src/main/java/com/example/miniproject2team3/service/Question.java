package com.example.miniproject2team3.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Question {

    String prompt;
    String [] answers;
    int correctAnswer;

    public Question() {
    }

    public Question(String prompt, String [] answers , int correctAnswer) {
        this.prompt = prompt;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return  prompt  + "\n" +
              "  \n Options : " + Arrays.toString(answers) ;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}





