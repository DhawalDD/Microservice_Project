package com.quiz.controller;


import com.quiz.entities.Quiz;
import com.quiz.exception.IdNotFoundException;
import com.quiz.exception.TimeOutErrorException;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {


    private QuizService quizservice;

    @Autowired
    public QuizController(QuizService quizservice) {
        this.quizservice = quizservice;
    }


    @PostMapping("/savequiz")
    public ResponseEntity<Quiz> create(@RequestBody Quiz quiz)
    {


            Quiz quiz2 = quizservice.add(quiz);

         return new ResponseEntity<Quiz>(quiz2, HttpStatus.CREATED);
    }

    @GetMapping("/getquiz")
    public ResponseEntity<List<Quiz>> getquiz()
    {
        List<Quiz> quiz = quizservice.getallquiz();
        return new ResponseEntity<List<Quiz>>(quiz,HttpStatus.FOUND);

    }

    @GetMapping("/getquizbyid/{id}")
    public  ResponseEntity<Quiz> getquizbyid(@PathVariable ("id") long id)
    {

        Quiz quiz = quizservice.get(id);

        /*if (quiz.getQuizId() == null)
        {
            throw  new IdNotFoundException(" quizid not found with this "+id);

        }
         else*/
        // WE ALREADY HANDLE EXCEPTION IN SERVICE LAYER BECAUSE FINDBYID() RETURN OPTIONAL<> HENCE
         return new ResponseEntity<Quiz>(quiz,HttpStatus.FOUND);

    }

}
