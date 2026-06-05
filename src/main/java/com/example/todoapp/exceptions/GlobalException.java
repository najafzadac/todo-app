package com.example.todoapp.exceptions;
import  org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestControllerAdvice

public class GlobalException {
    @ExceptionHandler(TodoNotFoundex.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public ErrorResponse handleTodonotfound(TodoNotFoundex ex){
        return new ErrorResponse(404,ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

    public ErrorResponse handlegeneral(Exception ex){
        return  new ErrorResponse(500, "something went wrong"+ ex.getMessage());

    }
}
