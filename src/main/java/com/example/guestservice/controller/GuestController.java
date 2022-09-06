package com.example.guestservice.controller;

import com.example.guestservice.dto.AllPropertyDTO;
import com.example.guestservice.entity.Property;
import com.example.guestservice.service.GuestService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guestService/")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Operation(summary = "Get All Property With Just Less Information",description = "This method is used to get all the property listed", tags = {"GuestController"})
    @GetMapping(value = "/getAllProperty")
    public List<AllPropertyDTO> getAllProperty(){
        return guestService.getAllProperty();
    }

    @Operation(summary = "Get The Property By Id Without Owner Details",description = "This method is used to get property without owner information", tags = {"GuestController"})
    @GetMapping(value = "/getProperty/{id}")
    public Property getProperty(@PathVariable("id")int id){
        return guestService.getProperty(id);
    }
}
