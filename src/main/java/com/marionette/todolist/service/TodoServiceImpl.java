package com.marionette.todolist.service;

import com.marionette.todolist.model.Todo;
import com.marionette.todolist.repository.TodoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marionette.todolist.exception.*;

import java.util.List;

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
    public Todo getTodoById(Long id) {
        return todoRespository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @Override
    public Todo updateTodo(Long id, Todo updateTodo) {
        Todo existingTodo = todoRespository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));

        existingTodo.setTitle(updateTodo.getTitle());
        existingTodo.setDescription(updateTodo.getDescription());
        existingTodo.setCompleted(updateTodo.isCompleted());
        return todoRespository.save(existingTodo);
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRespository.deleteById(id);
    }
}
