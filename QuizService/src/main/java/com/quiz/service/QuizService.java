package com.quiz.service;

import com.quiz.entities.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {


    Quiz add(Quiz quiz);
    List<Quiz> getallquiz();
    Quiz  get (long id);


}
