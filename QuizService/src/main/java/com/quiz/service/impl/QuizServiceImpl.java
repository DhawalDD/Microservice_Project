package com.quiz.service.impl;

import com.quiz.entities.Quiz;
import com.quiz.exception.IdNotFoundException;
import com.quiz.exception.TimeOutErrorException;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class QuizServiceImpl implements QuizService {


    private QuizRepository quizrepository;

    private QuestionClient questionclient;

    @Autowired
    public QuizServiceImpl(QuizRepository quizrepository, QuestionClient questionclient) {
        this.quizrepository = quizrepository;
        this.questionclient = questionclient;
    }

    


    @Override
    public Quiz add(Quiz quiz) {
        return quizrepository.save(quiz);
    }

    @Override
    public List<Quiz> getallquiz() {

        List<Quiz> quizzes =  quizrepository.findAll();

        List<Quiz> quizwithquestion =  quizzes.stream().
                map(q->{q.setQuestionsList(questionclient.getQuestionOfQuizUsingFeign(q.getQuizId()));
                    return q;
                }).collect(Collectors.toList());

               return quizwithquestion;


    }

    @Override
    public Quiz get(long id) {

        Quiz quiz = quizrepository.findById(id).orElseThrow(()->new IdNotFoundException("id not found "));
       // Quiz quiz = quiz1.get(); // to unbox optional type to normal one


      // Quiz quiz =  quizrepository.findById(id).orElseThrow(()->new IdNotFoundException ("quiz with id :"+id+" :not found"));
       // if you dont  want to throw exception here then have to use of optional but if you dont want to use optional
        //then but it is alos not good way
      //  Quiz quiz = quizrepository.findById(id).orElse(null);

       quiz.setQuestionsList(questionclient.getQuestionOfQuizUsingFeign(quiz.getQuizId()));


       return  quiz;
    }
}
