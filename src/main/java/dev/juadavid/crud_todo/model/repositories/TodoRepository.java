package dev.juadavid.crud_todo.model.repositories;

import dev.juadavid.crud_todo.model.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
