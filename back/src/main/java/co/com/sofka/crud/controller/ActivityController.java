package co.com.sofka.crud.controller;

import co.com.sofka.crud.model.dto.ActivityUpdateRequest;
import co.com.sofka.crud.model.entity.Activity;
import co.com.sofka.crud.model.dto.ActivityRequestDTO;
import co.com.sofka.crud.model.entity.ListTodo;
import co.com.sofka.crud.service.ActivityService;
import co.com.sofka.crud.service.ListTodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ListTodoService listTodoService;

    private ModelMapper modelMapper;

    @PostMapping("/create/{id}")
    public ResponseEntity<Activity> createActivity(@PathVariable("id") Long id, @Valid @RequestBody ActivityRequestDTO activity) {
        ListTodo listodo = listTodoService.getListTodo(id);
        if (listodo==null){
            return ResponseEntity.notFound().build();
        }else{
            this.modelMapper = new ModelMapper();
            Activity data = this.modelMapper.map(activity, Activity.class);
            data.setListTodo(listodo);

            Activity activityCreate = activityService.creaActivity(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(activityCreate);
        }

    }

    @PutMapping("/update")
    public ResponseEntity<Activity> updateActivity(@Valid @RequestBody ActivityUpdateRequest activityUpdate){
        this.modelMapper = new ModelMapper();
        Activity data = this.modelMapper.map(activityUpdate, Activity.class);
        Activity activityupdate = activityService.upActivity(data);
        if(activityupdate==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(activityupdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Activity> deleteProduct(@PathVariable("id") Long id){
        Activity activityDelete = activityService.delActivity(id);
        if (activityDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(activityDelete);
    }







}
