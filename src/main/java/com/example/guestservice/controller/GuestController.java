package com.example.guestservice.controller;

import com.example.guestservice.entity.Property;
import com.example.guestservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestService/")
public class GuestController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = "/addProperty" , method = RequestMethod.POST)
    public Property addProperty(@RequestBody Property property){
        return propertyService.addProperty(property);
    }

    @RequestMapping(value = "/getProperty/{id}" , method = RequestMethod.GET)
    public Property getProperty(@PathVariable("id")int id){
        return propertyService.getProperty(id);
    }

    @RequestMapping(value = "/getAllProperty" , method = RequestMethod.GET)
    public List<Property> getAllProperty(){
        return propertyService.getAllProperty();
    }

    @RequestMapping(value = "/updateProperty/{id}" , method = RequestMethod.PUT)
    public Property updateProperty(@PathVariable("id") int id , @RequestBody Property updatedProperty){
       return propertyService.updateProperty(id , updatedProperty);
    }

    @RequestMapping(value = "/deleteProperty" , method = RequestMethod.DELETE)
    public String deleteProperty(int id){
        return propertyService.deleteProperty(id);
    }


}
