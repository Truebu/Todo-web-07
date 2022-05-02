package dev.juadavid.crud_todo.business.service;

import dev.juadavid.crud_todo.model.dto.MessageDto;
import dev.juadavid.crud_todo.model.entities.Todo;
import dev.juadavid.crud_todo.model.repositories.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public ResponseEntity<MessageDto> newTodo(Todo todo) {
        todoRepository.save(todo);
        return new ResponseEntity(new MessageDto("Registro exitoso"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MessageDto> editTodo(Long id, Todo todo) {
        todo.setId(id);
        todoRepository.save(todo);
        return new ResponseEntity(new MessageDto("Se modificó correctamente"), HttpStatus.OK);
    }

    @Override
    public List<Todo> showTodo() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<MessageDto> deleteTodo(Long id) {
        todoRepository.deleteById(id);
        return new ResponseEntity(new MessageDto("Se eliminó correctamente"), HttpStatus.OK);
    }
}
