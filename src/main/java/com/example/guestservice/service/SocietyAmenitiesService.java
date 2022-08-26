package com.example.guestservice.service;

import com.example.guestservice.entity.SocietyAmenities;
import com.example.guestservice.repository.SocietyAmenitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietyAmenitiesService {

    @Autowired
    private SocietyAmenitiesRepository societyAmenitiesRepository;

    public SocietyAmenities addSocietyAmenities(SocietyAmenities societyAmenities){
        return societyAmenitiesRepository.save(societyAmenities);
    }

    public SocietyAmenities getSocietyAmenities(int id){
        return societyAmenitiesRepository.findById(id).orElse(null);
    }

    public List<SocietyAmenities> getAllSocietyAmenities(){
        return societyAmenitiesRepository.findAll();
    }

    public SocietyAmenities updateSocietyAmenities(int id , SocietyAmenities updateSocietyAmenities){

        SocietyAmenities societyAmenities = societyAmenitiesRepository.findById(id).orElse(null);

        societyAmenities.setName(updateSocietyAmenities.getName());

        societyAmenitiesRepository.save(societyAmenities);

        return societyAmenities;
    }

    public String deleteSocietyAmenities(int id){

        SocietyAmenities societyAmenities = societyAmenitiesRepository.findById(id).orElse(null);

        societyAmenitiesRepository.deleteById(id);

        return "SocietyAmenities with name "+societyAmenities.getName()+" deleted successfully";
    }
}
