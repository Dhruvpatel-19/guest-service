package com.example.guestservice.service;

import com.example.guestservice.entity.Category;
import com.example.guestservice.entity.Property;
import com.example.guestservice.entity.Type;
import com.example.guestservice.repository.CategoryRepository;
import com.example.guestservice.repository.PropertyReposiitory;
import com.example.guestservice.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyReposiitory propertyReposiitory;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TypeRepository typeRepository;

    public Property addProperty(Property property){

        property.setCreatedAt(LocalDateTime.now());

        Category category = property.getCategory();
        Type type = property.getType();

        boolean categoryExists = categoryRepository.existsByCategory(category.getCategory());
        boolean typeExists = typeRepository.existsByType(type.getType());

        Category category1 = null;
        Type type1 = null;

        if(categoryExists)
            category1 = categoryRepository.findByCategory(category.getCategory());
        else
            category1 = categoryRepository.findByCategory("Other");

        if(typeExists)
            type1 = typeRepository.findByType(type.getType());
        else
            type1 = typeRepository.findByType("Other");

        property.setCategory(category1);
        property.setType(type1);

        return propertyReposiitory.save(property);
    }

    public Property getProperty(int id){
        return propertyReposiitory.findById(id).orElse(null);
    }

    public List<Property> getAllProperty(){
        return propertyReposiitory.findAll();
    }

    public Property updateProperty(int id , Property updatedProperty){
        Property property = propertyReposiitory.findById(id).orElse(null);

        property.setPrice(updatedProperty.getPrice());
        property.setArea(updatedProperty.getArea());
        property.setAction(updatedProperty.getAction());
        property.setAgeYears(updatedProperty.getAgeYears());
        property.setFurnishing(updatedProperty.getFurnishing());
        property.setAvailableFrom(updatedProperty.getAvailableFrom());
        property.setAvailableTo(updatedProperty.getAvailableTo());
        property.setParkingAvailability(updatedProperty.getParkingAvailability());
        property.setImages(updatedProperty.getImages());
        property.setSocietyAmenities(updatedProperty.getSocietyAmenities());
        property.setFlatAmenities(updatedProperty.getFlatAmenities());

        //if(property.getCategory() != updatedProperty.getCategory()){

            property.setCategory(updatedProperty.getCategory());

        //}

        //if(property.getType() != updatedProperty.getType()){
            property.setType(updatedProperty.getType());
        //}

        //if(property.getAddress() != updatedProperty.getAddress()) {
            property.setAddress(updatedProperty.getAddress());
        //}

        return propertyReposiitory.save(property);
    }

    public String deleteProperty(int id){
        boolean isExist = propertyReposiitory.existsById(id);

        if(isExist) {
            System.out.println("Property exists .........");
            propertyReposiitory.deleteById(id);
            return "Property deleted successfully";
        }else {
            System.out.println("Property doen't exists .........");
            return "Property doesn't exist";
        }
    }


}
