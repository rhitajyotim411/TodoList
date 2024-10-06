package com.marionette.todolist.repository;

import com.marionette.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// The @Repository annotation tells Spring that this interface is a repository layer component.
@Repository
public interface TodoRespository extends JpaRepository<Todo, Long> {
    // No need to define any methods. JpaRepository provides common CRUD methods out
    // of the box.
}
