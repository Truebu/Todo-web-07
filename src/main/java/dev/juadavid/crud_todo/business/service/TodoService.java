package dev.juadavid.crud_todo.business.service;

import dev.juadavid.crud_todo.model.dto.MessageDto;
import dev.juadavid.crud_todo.model.entities.Todo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoService {

    public ResponseEntity<MessageDto> newTodo(Todo todo);
    public ResponseEntity<MessageDto> editTodo(Long id, Todo todo);
    public List<Todo> showTodo();
    public Todo getTodoById(Long id);
    public ResponseEntity<MessageDto> deleteTodo(Long id);
}
