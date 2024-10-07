package com.marionette.todolist.service;

import com.marionette.todolist.model.Todo;
import com.marionette.todolist.repository.TodoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRespository todoRespository;

    @Autowired
    public TodoServiceImpl(TodoRespository todoRespository) {
        this.todoRespository = todoRespository;
    }

    @Override
    public Todo addTodo(Todo todo) {
        return todoRespository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRespository.findAll();
    }

    @Override
    public Optional<Todo> getTodoById(Long id) {
        return todoRespository.findById(id);
    }

    @Override
    public Todo updateTodo(Long id, Todo updateTodo) {
        Optional<Todo> todoOptional = todoRespository.findById(id);
        if (todoOptional.isPresent()) {
            Todo existingTodo = todoOptional.get();
            existingTodo.setTitle(updateTodo.getTitle());
            existingTodo.setDescription(updateTodo.getDescription());
            existingTodo.setCompleted(updateTodo.isCompleted());
            return todoRespository.save(existingTodo);
        }
        return null;
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRespository.deleteById(id); 
    }
}
