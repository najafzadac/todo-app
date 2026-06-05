package com.example.todoapp.exceptions;

public class TodoNotFoundex extends RuntimeException{
    public TodoNotFoundex(Long id){
        super("todo not found with this id"+ id);
    }
}
