package com.geekbrains.repository;

import com.geekbrains.entity.ToDo;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ToDoRepository {

    private static HashMap<String, List<ToDo>> data = new HashMap<> ();

    public List<ToDo> getTaskListById(String userId){
        if (!data.containsKey (userId)){
            return null;
        }
        return data.get (userId);
    }

    public void remove (int todoId, String userId) {
        if (!data.containsKey (userId)){
            return;
        }
        List<ToDo> list = data.get (userId);
        list.remove (todoId);
        if (list.isEmpty ()){
            data.remove (userId);
        }
    }

    public void add(String userId, ToDo toDo){
        List<ToDo> list = getTaskListById (userId);
        if (list == null){
            list = new ArrayList<> ();
        }
        list.add (toDo);
    }
}
