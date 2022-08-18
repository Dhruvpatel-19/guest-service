package com.example.guestservice.controller;

import com.example.guestservice.entity.FlatAmenities;
import com.example.guestservice.service.FlatAmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestService/")
public class FlatAmenitiesController {

    @Autowired
    private FlatAmenitiesService flatAmenitiesService;

    @PostMapping(value = "/addFlatAmenities")
    public FlatAmenities addFlatAmenities(@RequestBody FlatAmenities flatAmenities){
        return flatAmenitiesService.addFlatAmenities(flatAmenities);
    }

    @GetMapping(value = "/getFlatAmenitiesById/{id}")
    public FlatAmenities getFlatAmenities(@PathVariable("id") int id){
        return flatAmenitiesService.getFlatAmenities(id);
    }

    @GetMapping(value = "/getAllFlatAmenities")
    public List<FlatAmenities> getAllFlatAmenities(){
        return flatAmenitiesService.getAllFlatAmenities();
    }

    @PutMapping(value = "/updateFlatAmenities/{id}")
    public FlatAmenities updateFlatAmenities(@PathVariable("id") int id , @RequestBody FlatAmenities flatAmenities){
       return flatAmenitiesService.updateFlatAmenities(id , flatAmenities);
    }

    @DeleteMapping(value = "/deleteFlatAmenities/{id}")
    public String deleteFlatAmenities(@PathVariable("id") int id){
        return flatAmenitiesService.deleteFlatAmenities(id);
    }
}
