package com.example.todoapp.controller;
import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
@Tag(name="todo", description="manage todo items")
public class TodoController {
    private final TodoService service;
    @GetMapping
    @Operation(summary="get all todos", description="returns list of all todos")
    @ApiResponse(responseCode = "200", description="succesful")

    public List<Todo> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    @Operation(summary = "get todo by id", description = "return single todo")
    public Todo getOne(@PathVariable Long id) {
        return service.getById(id);
    }
    @PostMapping
    @Operation(summary = "create new table", description = "create a todo items")
    public Todo create(@RequestBody Todo todo) {
        return service.create(todo);
    }
    @PutMapping("/{id}")
    @Operation(summary = "update todo", description = "update existinf data")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        return service.update(id, todo);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "delete todo", description = "deletes todo")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}