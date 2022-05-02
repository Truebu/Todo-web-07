package dev.juadavid.crud_todo.business.controller;

import dev.juadavid.crud_todo.business.service.TodoService;
import dev.juadavid.crud_todo.model.entities.Todo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/v1/todo")
public class TodoController {

    private final TodoService service;

    @GetMapping("/")
    public String showAllTodo(Model model){
        model.addAttribute("todos", service.showTodo());
        return "Todos";
    }

    @GetMapping("/register")
    public String newTodoForm(Model model){
        Todo newTodo = new Todo();
        model.addAttribute("newTodo", newTodo );
        return "NewTodo";
    }

    @PostMapping("/register")
    public String newTodo(@ModelAttribute("newTodo") Todo newTodo){
        service.newTodo(newTodo);
        return "redirect:/v1/todo/";
    }

    @GetMapping("/edit/{id}")
    public String editTodoForm(@PathVariable Long id, Model model){
        model.addAttribute("todo", service.getTodoById(id));
        return "EditTodo";
    }

    @PostMapping("/edit/{id}")
    public String editTodo(@PathVariable Long id, Model model, @ModelAttribute("editTodo") Todo editTodo){
        service.editTodo(id, editTodo);
        return "redirect:/v1/todo/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id){
        service.deleteTodo(id);
        return "redirect:/v1/todo/";
    }


}
