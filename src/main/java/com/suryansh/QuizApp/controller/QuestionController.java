package com.suryansh.QuizApp.controller;
import com.suryansh.QuizApp.TableMap.Question;
import com.suryansh.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestion(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{cat}")
    public List<Question> getQuestionByCategory(@PathVariable("cat") String category){

        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String  addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);


    }

}
