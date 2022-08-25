package com.example.guestservice.controller;

import com.example.guestservice.dto.AllPropertyDTO;
import com.example.guestservice.dto.PropertyDTO;
import com.example.guestservice.service.GuestService;
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

    @GetMapping(value = "/getAllProperty")
    public List<AllPropertyDTO> getAllProperty(){
        return guestService.getAllProperty();
    }

    @GetMapping(value = "/getProperty/{id}")
    public PropertyDTO getProperty(@PathVariable("id")int id){
        return guestService.getProperty(id);
    }
}
