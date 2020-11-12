package co.com.sofka.crud.controller;

import co.com.sofka.crud.model.dto.ListTodoRequestDTO;
import co.com.sofka.crud.model.entity.ListTodo;
import co.com.sofka.crud.service.ListTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
public class ListTodoController {
    @Autowired
    private ListTodoService listTodoService;

    private ModelMapper modelMapper;

    @GetMapping("/getName/{name}")
    public ResponseEntity<List<ListTodo>> getListTodo(@PathVariable("name") String name){
        List<ListTodo> nameList = listTodoService.findByName(name);
        if(nameList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nameList);
    }

    @GetMapping("/getTodos")
    public List<ListTodo> getAllListTodo(){
        return listTodoService.listAllListTodo();
    }

    @PostMapping("/createTodos")
    public ResponseEntity<?> createListTodo(@Valid @RequestBody ListTodoRequestDTO listTodoDTO) {
        this.modelMapper = new ModelMapper();
        ListTodo listTodo = this.modelMapper.map(listTodoDTO, ListTodo.class);
        ListTodo listCreated = listTodoService.createListTodo(listTodo);
        if (listCreated==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(listCreated);
        }
    }

    @DeleteMapping("/deleteLisTodo/{id}")
    public ResponseEntity<ListTodo> deleteListTodo(@PathVariable("id") Long id){
        ListTodo listDelete = listTodoService.deleteListTodo(id);
        if (listDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listDelete);
    }
}
