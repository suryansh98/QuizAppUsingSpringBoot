package com.suryansh.QuizApp.service;

import java.util.*;
import com.suryansh.QuizApp.DAO.QuestionDAO;
import com.suryansh.QuizApp.DAO.QuizDao;
import com.suryansh.QuizApp.model.Question;
import com.suryansh.QuizApp.model.QuestionWrapper;
import com.suryansh.QuizApp.model.Quiz;
import com.suryansh.QuizApp.model.Response;
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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz = quizDao.findById(id);

        List<Question> questionFromDB = quiz.get().getQuestions();

        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q: questionFromDB)
        {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption2(), q.getOption3(), q.getOption4());

            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        Quiz quiz = quizDao.findById(id).get();

        List<Question> questions = quiz.getQuestions();

        int right = 0;
        int i = 0;
        for(Response response: responses)
        {
            if(response.getResponse().equals(questions.get(i).getCorrectAnswer()))
                    right++;
            i++;
        }

    return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
