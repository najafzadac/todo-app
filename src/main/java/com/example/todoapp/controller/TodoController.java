package com.example.todoapp.controller;
import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;
    @GetMapping
    public List<Todo> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Todo getOne(@PathVariable Long id) {
        return service.getById(id);
    }
    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return service.create(todo);
    }
    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        return service.update(id, todo);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}