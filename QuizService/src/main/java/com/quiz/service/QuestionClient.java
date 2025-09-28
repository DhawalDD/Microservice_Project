package com.quiz.service;


import com.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


//when we were not using loadbalancer to communicate with service







//@FeignClient(url = "localhost:8091",value = "Question-Client")

//when we are using loadbalancer to communicate with service
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    // here we use feign client from which we call to question service to fetch question acc to quizid
    //17 line is responcible to call questions services method i.e getquestionbyquizid (method in quiz service)
    // then the List<> of questions is being set to field of quizservice to show questions acc to quiz id
    //please check next code in controller
    @GetMapping("/question/quiz/getquestionbyquizid/{quizid}")
    List<Question> getQuestionOfQuizUsingFeign(@PathVariable Long quizid);


}
