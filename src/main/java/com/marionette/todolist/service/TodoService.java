package com.marionette.todolist.service;

import com.marionette.todolist.model.Todo;
import java.util.List;

public interface TodoService {
    Todo addTodo(Todo todo);

    List<Todo> getAllTodos();

    Todo getTodoById(Long id);

    Todo updateTodo(Long id, Todo todo);

    void deleteTodoById(Long id);
}
