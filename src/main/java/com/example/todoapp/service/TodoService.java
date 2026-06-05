package com.example.todoapp.service;

import com.example.todoapp.exceptions.TodoNotFoundex;
import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TodoService {
    private final TodoRepository repo;

    public List<Todo> getAll(){//gets all todo
        return repo.findAll();
    }
    public Todo getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new TodoNotFoundex(id));
    }
    public Todo create (Todo todo) {//create new todo
        return repo.save(todo);
    }
    public Todo update(Long id, Todo update){
        Todo existing= getById(id);//find todo
        existing.setTitle(update.getTitle());
        existing.setCompleted(update.getCompleted());

        return repo.save(existing);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
