package com.quiz.exception;

public class TimeOutErrorException extends RuntimeException {


    public TimeOutErrorException(String mgs)
    {
               super(mgs);
    }
}
