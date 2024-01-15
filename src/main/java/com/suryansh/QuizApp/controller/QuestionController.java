package com.suryansh.QuizApp.controller;
import com.suryansh.QuizApp.model.Question;
import com.suryansh.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{cat}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("cat") String category){

        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String>  addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);

    }



}
