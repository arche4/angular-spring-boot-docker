package co.com.sofka.crud.service;

import co.com.sofka.crud.model.entity.ListTodo;

import java.util.List;

public interface ListTodoService {

    public List<ListTodo> listAllListTodo();
    public ListTodo getListTodo(Long id);
    public ListTodo createListTodo(ListTodo listTodo);
    public ListTodo deleteListTodo(Long id);
    public List<ListTodo> findByName(String name);
}
