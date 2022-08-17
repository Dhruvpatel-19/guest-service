package com.example.guestservice.controller;

import com.example.guestservice.entity.Type;
import com.example.guestservice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestService/")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/addType" , method = RequestMethod.POST)
    public Type addType(@RequestBody Type type){
        return typeService.addType(type);
    }

    @RequestMapping(value = "/getTypeById/{id}" , method = RequestMethod.GET)
    public Type getType(@PathVariable("id") int id){
        return typeService.getType(id);
    }

    @RequestMapping(value = "/getAllType" , method = RequestMethod.GET)
    public List<Type> getAllType(){
        return typeService.getAllType();
    }

    @RequestMapping(value = "/updateType/{id}" , method = RequestMethod.PUT)
    public Type updateType(@PathVariable("id") int id , @RequestBody Type type){
        return typeService.updateType(id , type);
    }

    @RequestMapping(value = "/deleteType/{id}" , method = RequestMethod.DELETE)
    public String deleteType(@PathVariable("id") int id){
        return typeService.deleteType(id);
    }
}
