package bg.softuni.comments_project.controller;

import bg.softuni.comments_project.exception.CommentNotFoundException;
import bg.softuni.comments_project.model.ErrorClass;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalNotFoundExceptionHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({CommentNotFoundException.class, ObjectNotFoundException.class})
    public ErrorClass onErrorNotFound ( Exception ex) {
        return new ErrorClass(
                ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class, NumberFormatException.class})
    public ErrorClass onErrorBadRequest(Exception ex) {
        return new ErrorClass( ex.getMessage()+"Custom error message");
    }
//        "timestamp": "2025-04-03T16:26:40.198+00:00",
//                "status": 405,
//                "error": "Method Not Allowed",
//                "path": "/1"
//}


}
