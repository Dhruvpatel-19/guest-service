package com.example.guestservice.controller;

import com.example.guestservice.entity.Property;
import com.example.guestservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/callGuestService/")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping(value = "/addProperty")
    public Property addProperty(@RequestBody Property property){
        return propertyService.addProperty(property);
    }

    @GetMapping(value = "/getProperty/{id}")
    public Property getProperty(@PathVariable("id")int id){
        return propertyService.getProperty(id);
    }

    @GetMapping(value = "/getAllProperty")
    public List<Property> getAllProperty(){
        return propertyService.getAllProperty();
    }

    @PutMapping(value = "/updateProperty/{id}")
    public Property updateProperty(@PathVariable("id") int id , @RequestBody Property updatedProperty){
       return propertyService.updateProperty(id , updatedProperty);
    }

    @DeleteMapping(value = "/deleteProperty/{id}")
    public String deleteProperty(@PathVariable("id") int id){
        return propertyService.deleteProperty(id);
    }


}
