package com.example.depropdemo.Controller;


import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController implements ErrorController {
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

//    @ExceptionHandler(ErrorProperties.Whitelabel)
//    public String NotFound(Exception e){
//        e.printStackTrace();
//        return "user/404";
//    }
    @RequestMapping("/error")
    public String handleError() {
        // Your custom error handling logic goes here
        return "user/404"; // Return the name of your custom error page
    }

    public String getErrorPath() {
        return "user/404";
    }

}
