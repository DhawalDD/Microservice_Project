package com.question.service.impl;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.question.repository.QuestionRepository;

import java.util.List;



@Service
public class QuestionServiceImpl implements QuestionService {



    private  QuestionRepository questionrepository;



    @Autowired
    public QuestionServiceImpl(QuestionRepository questionrepository) {
        this.questionrepository = questionrepository;
    }

    @Override
    public Question saveQuestion(Question question)
    {
        return questionrepository.save(question);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionrepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionrepository.findById(id).orElseThrow(()->new RuntimeException("Question with id"+id+"not found"));
    }

    @Override
    public List<Question> getQuestionByQuizId(Long quizId) {
        return questionrepository.findByQuizId(quizId);
    }
}
