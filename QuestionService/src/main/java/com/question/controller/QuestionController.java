package com.question.controller;


import com.question.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.question.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {


   private QuestionService questionservice;



    @Autowired
    public QuestionController(QuestionService questionservice) {
        this.questionservice = questionservice;
    }

    @PostMapping("/savequestion")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question)
    {

          Question  question1 = questionservice.saveQuestion(question);
        return new ResponseEntity<>(question1, HttpStatus.CREATED);

    }

    @GetMapping("/getallquestion")
    public ResponseEntity<List<Question>> getAllQuestion()
    {

         List<Question> questions = questionservice.getAllQuestion();
        return new ResponseEntity<>(questions,HttpStatus.OK);


    }

    @GetMapping("/getquestionbyid/{id}")
    public ResponseEntity<Question> getAllQuestionById(@PathVariable Long id)
    {
         Question questions = questionservice.getQuestionById(id);
         return new ResponseEntity<>(questions,HttpStatus.OK);

    }

    @GetMapping("/quiz/getquestionbyquizid/{quizId}")
    public ResponseEntity<List<Question>> getQuestionByQuizId(@PathVariable Long quizId)
    {
        List<Question> questionList = questionservice.getQuestionByQuizId(quizId);

        return new ResponseEntity<>(questionList,HttpStatus.OK);


    }
}
