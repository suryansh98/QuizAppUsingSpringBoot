package com.suryansh.QuizApp.service;

import com.suryansh.QuizApp.DAO.QuestionDAO;
import com.suryansh.QuizApp.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getAllQuestions() {

        return questionDAO.findAll();

    }
}
