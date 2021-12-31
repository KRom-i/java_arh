package com.geekbrains.service;

import com.geekbrains.entity.ToDo;
import com.geekbrains.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository repository;

    public ToDoService (ToDoRepository repository) {
        this.repository = repository;
    }

    public List<ToDo> getTaskListBySession(HttpSession session){
        return repository.getTaskListById (session.getId ());
    }

    public void remove (int todoId, HttpSession session) {
        repository.remove(todoId, session.getId ());
    }

    public void add (HttpSession session, ToDo toDo) {
        repository.add (session.getId (), toDo);
    }
}
