package bg.softuni.comments_project.controller;

import bg.softuni.comments_project.exception.CommentNotFoundException;
import bg.softuni.comments_project.model.ErrorClass;
import org.antlr.v4.runtime.atn.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class GlobalNotFoundExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CommentNotFoundException.class)
    public ErrorClass onErrorNotFound(CommentNotFoundException ex){
        return new ErrorClass("url",ex.getMessage()    );
    }

}
