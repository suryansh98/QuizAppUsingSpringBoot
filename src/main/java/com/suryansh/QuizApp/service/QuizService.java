package com.suryansh.QuizApp.service;

import java.util.*;
import com.suryansh.QuizApp.DAO.QuestionDAO;
import com.suryansh.QuizApp.DAO.QuizDao;
import com.suryansh.QuizApp.model.Question;
import com.suryansh.QuizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDAO questionDAO;


    public ResponseEntity<String> create(String category, int numQ, String title) {

        List<Question> questions = questionDAO.findRandomQuestionsByCategory(category, numQ);


        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}