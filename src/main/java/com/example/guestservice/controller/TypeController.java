package com.example.guestservice.controller;

import com.example.guestservice.entity.Type;
import com.example.guestservice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/callGuestService/")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @PostMapping(value = "/addType")
    public Type addType(@RequestBody Type type){
        return typeService.addType(type);
    }

    @GetMapping(value = "/getTypeById/{id}")
    public Type getType(@PathVariable("id") int id){
        return typeService.getType(id);
    }

    @GetMapping(value = "/getAllType")
    public List<Type> getAllType(){
        return typeService.getAllType();
    }

    @PutMapping(value = "/updateType/{id}")
    public Type updateType(@PathVariable("id") int id , @RequestBody Type type){
        return typeService.updateType(id , type);
    }

    @DeleteMapping(value = "/deleteType/{id}")
    public String deleteType(@PathVariable("id") int id){
        return typeService.deleteType(id);
    }
}
