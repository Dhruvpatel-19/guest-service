package com.example.guestservice.service;

import com.example.guestservice.entity.FlatAmenities;
import com.example.guestservice.repository.FlatAmenitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlatAmenitiesService {

    @Autowired
    private FlatAmenitiesRepository flatAmenitiesRepository;

    public FlatAmenities addFlatAmenities(FlatAmenities flatAmenities){
        return flatAmenitiesRepository.save(flatAmenities);
    }

    public FlatAmenities getFlatAmenities(int id){
        return flatAmenitiesRepository.findById(id).orElse(null);
    }

    public List<FlatAmenities> getAllFlatAmenities(){
        return flatAmenitiesRepository.findAll();
    }

    public FlatAmenities updateFlatAmenities(int id , FlatAmenities updatedFlatAmenities){

        FlatAmenities flatAmenities = flatAmenitiesRepository.findById(id).orElse(null);

        flatAmenities.setName(updatedFlatAmenities.getName());

        flatAmenitiesRepository.save(flatAmenities);

        return flatAmenities;
    }

    public String deleteFlatAmenities(int id){

        FlatAmenities flatAmenities = flatAmenitiesRepository.findById(id).orElse(null);

        flatAmenitiesRepository.deleteById(id);

        return "FlatAmenities with name "+flatAmenities.getName()+" deleted successfully";
    }
}
