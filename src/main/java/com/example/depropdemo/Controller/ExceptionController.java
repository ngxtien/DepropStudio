package com.example.depropdemo.Controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController{
    @ExceptionHandler(NullPointerException.class)
    public String nullPointer(Exception e){
        e.printStackTrace();
        return "user/404";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String IllegalArgumentException(Exception e){
        e.printStackTrace();
        return "user/404";
    }
}
