package co.com.sofka.crud.repository;

import co.com.sofka.crud.model.entity.ListTodo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListTodoRepository extends JpaRepository<ListTodo, Long> {
    public List<ListTodo> findByName(String name);
}
