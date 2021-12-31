package com.geekbrains.controller;

import com.geekbrains.entity.ToDo;
import com.geekbrains.service.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/to-do")
public class ToDoController {

    private final ToDoService service;

    public ToDoController (ToDoService service) {
        this.service = service;
    }


    @GetMapping("/list")
    public String getList(Model model, HttpSession session){
        List<ToDo> list  = service.getTaskListBySession (session);
        if (list == null){
            model.addAttribute ("message", "To-do list is empty");
            return "message";
        }
        model.addAttribute ("list", list);
        return "list";
    }

    @GetMapping("/form")
    public String getForm(){
        return "form";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id, HttpSession session){
        service.remove(id, session);
        return "redirect:/to-do/list";
    }

    @RequestMapping("/process-form")
    public String processForm(@ModelAttribute("todo") ToDo toDo, HttpSession session) {
        service.add(session, toDo);
        return "redirect:/to-do/list";
    }
}
