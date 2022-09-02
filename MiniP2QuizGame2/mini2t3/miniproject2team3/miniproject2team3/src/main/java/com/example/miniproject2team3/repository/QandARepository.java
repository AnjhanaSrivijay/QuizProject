package com.example.miniproject2team3.repository;

import com.example.miniproject2team3.service.Question;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Repository
public class QandARepository {

    private List<Question> questions= new ArrayList<>();

    public QandARepository() {

        questions.add(new Question ("How many elements are in the periodic table?",  new String[] {"118", "117", "116"}, 0));
        questions.add(new Question ("How many ghosts chase Pac-Man at the start of each game?",  new String[] {"3", "5", "4"}, 2));
        questions.add(new Question ("Which planet in the Milky Way is the hottest?",  new String[] {"Mercury", "Venus", "Haumea"}, 1));
        questions.add(new Question ("What company was initially known as \"Blue Ribbon Sports\"? ",  new String[] {"Puma", "Adidas", "Nike"}, 2));
        questions.add(new Question ("In which ancient festival did Halloween originate from?",  new String[] {"Irish", "Danish", "American"}, 0));
        questions.add(new Question ("What software company is headquartered in Redmond, Washington?",  new String[] {"Apple", "Microsoft", "Amazon"}, 1));
        questions.add(new Question ("Which year was Intellij founded?",  new String[] {"1999", "2001", "2000"}, 2));
        questions.add(new Question ("What is the scientific name for the southern lights?",  new String[] {"Aurora Australis", "Aurora borealis", "Aurora Cabodehornos"}, 0));
        questions.add(new Question ("When was netflix founded?",  new String[] {"2000", "2005", "1997"}, 2));
        questions.add(new Question ("Which is the Northmost place humans live in the world ?",  new String[] {"Svalbard", "Nunavut", "Barantsburg"}, 0));
        questions.add(new Question ("How many World Heritage places are in Sweden ?",  new String[] {"17", "15", "20"}, 1));
        questions.add(new Question ("Which sea animal has three hearts?",  new String[] {"Squid", "Octopus", "JellyFish"}, 1));
        questions.add(new Question ("How many tails does a Manx cat have?",  new String[] {"One", "Split", "None"}, 2));
        questions.add(new Question ("What geometric shape is generally used for stop signs?",  new String[] {"Octagon", "Hexagon", "Round"}, 0));
        questions.add(new Question ("What is \"cynophobia\"?",  new String[] {"Fear of cynide", "Fear of chemicals", "Fear of dogs"}, 2));
        }

    public List<Question> getQuestions() {
        var t= LocalTime.now();
        var n=t.getNano();
        var r=new Random(n);
        Collections.shuffle(questions,r);
        return questions.subList(0,7);
    }
}













