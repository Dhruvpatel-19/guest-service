package com.example.guestservice.service;

import com.example.guestservice.entity.Property;
import com.example.guestservice.repository.PropertyReposiitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyReposiitory propertyReposiitory;

    public Property addProperty(Property property){

        property.setCreatedAt(LocalDateTime.now());

        return propertyReposiitory.save(property);
    }

    public Property getProperty(int id){
        return propertyReposiitory.findByPropertyId(id);
    }

    public List<Property> getAllProperty(){
        return propertyReposiitory.findAll();
    }

    public Property updateProperty(int id , Property updatedProperty){
        Property property = propertyReposiitory.findByPropertyId(id);

        property.setPrice(updatedProperty.getPrice());
        property.setImages(updatedProperty.getImages());
        property.setArea(updatedProperty.getArea());
        property.setAction(updatedProperty.getAction());
        property.setAgeYears(updatedProperty.getAgeYears());
        property.setFurnishing(updatedProperty.getFurnishing());
        property.setAvailableFrom(updatedProperty.getAvailableFrom());
        property.setAvailableTo(updatedProperty.getAvailableTo());
        property.setParkingAvailability(updatedProperty.getParkingAvailability());
        property.setSocietyAmenities(updatedProperty.getSocietyAmenities());
        property.setFlatAmenities(updatedProperty.getFlatAmenities());
        property.setCategory(updatedProperty.getCategory());
        property.setType(updatedProperty.getType());
        property.setAddress(updatedProperty.getAddress());

        return propertyReposiitory.save(property);
    }

    public String deleteProperty(int id){
        boolean isExist = propertyReposiitory.existsByPropertyId(id);

        if(isExist) {
            propertyReposiitory.deleteByPropertyId(id);
            return "Property deleted successfully";
        }else {
            return "Property doesn't exist";
        }
    }


}
