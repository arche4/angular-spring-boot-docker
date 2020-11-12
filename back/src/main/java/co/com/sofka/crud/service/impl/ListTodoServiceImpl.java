package co.com.sofka.crud.service.impl;

import co.com.sofka.crud.model.entity.ListTodo;
import co.com.sofka.crud.repository.ListTodoRepository;
import co.com.sofka.crud.service.ListTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTodoServiceImpl implements ListTodoService {

    @Autowired
    private ListTodoRepository listTodoRepository;

    @Override
    public List<ListTodo> listAllListTodo() {
        return   listTodoRepository.findAll();  }

    @Override
    public ListTodo getListTodo(Long id) {
        return listTodoRepository.findById(id).orElse(null);
    }

    @Override
    public ListTodo createListTodo(ListTodo listTodo) {
        return listTodoRepository.save(listTodo);
    }

    @Override
    public ListTodo deleteListTodo(Long id) {
        ListTodo listTodo = getListTodo(id);
        if(listTodo==null){
            return null;
        }else{
            listTodoRepository.delete(listTodo);
        }
        return listTodo;
    }

    @Override
    public List<ListTodo> findByName(String name) {
        return listTodoRepository.findByName(name);
    }
}
