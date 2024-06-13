package com.example.api.services;


import com.example.api.entities.Todo;
import com.example.api.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo updateTodo(Todo todoDetails, Long id) {
        Todo todo = getTodoById(id);
        todo.setTitle(todoDetails.getTitle());
        todo.setCompleted(todoDetails.isCompleted());
        return todoRepository.save(todo);
    }
}
