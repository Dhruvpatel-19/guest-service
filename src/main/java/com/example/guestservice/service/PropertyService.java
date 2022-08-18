package com.example.guestservice.service;

import com.example.guestservice.entity.*;
import com.example.guestservice.repository.*;
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

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private FlatAmenitiesRepository flatAmenitiesRepository;

    @Autowired
    private SocietyAmenitiesRepository societyAmenitiesRepository;

    public Property addProperty(Property property){

        property.setCreatedAt(LocalDateTime.now());

        Category category = property.getCategory();
        Type type = property.getType();

        boolean categoryExists = categoryRepository.existsByCategory(category.getCategory());
        boolean typeExists = typeRepository.existsByType(type.getType());


        if(categoryExists)
            category = categoryRepository.findByCategory(category.getCategory());
        else
            category = categoryRepository.findByCategory("Other");

        if(typeExists)
            type = typeRepository.findByType(type.getType());
        else
            type = typeRepository.findByType("Other");

        property.setCategory(category);
        property.setType(type);


        List<FlatAmenities> flatAmenitiesList = property.getFlatAmenities();
        FlatAmenities flatAmenities ;
        for(int i=0 ; i<flatAmenitiesList.size() ; i++){
             flatAmenities = flatAmenitiesList.get(0);

            if(flatAmenitiesRepository.existsByName(flatAmenities.getName())){
                flatAmenities = flatAmenitiesRepository.findByName(flatAmenities.getName());
            }
            else{
                flatAmenities = flatAmenitiesRepository.findByName("Other");
            }
            flatAmenitiesList.add(flatAmenities);
        }

        List<SocietyAmenities> societyAmenitiesList = property.getSocietyAmenities();
        SocietyAmenities societyAmenities;
        for(int i=0 ; i<societyAmenitiesList.size() ; i++){
            societyAmenities = societyAmenitiesList.get(0);

            if(societyAmenitiesRepository.existsByName(societyAmenities.getName())){
                societyAmenities = societyAmenitiesRepository.findByName(societyAmenities.getName());
            }
            else{
                societyAmenities = societyAmenitiesRepository.findByName("Other");
            }
            societyAmenitiesList.add(societyAmenities);
        }

        property.setFlatAmenities(flatAmenitiesList);
        property.setSocietyAmenities(societyAmenitiesList);
        

        return propertyReposiitory.save(property);
    }

    public Property getProperty(int id){
        return propertyReposiitory.findById(id).orElse(null);
    }

    public List<Property> getAllProperty(){
        return propertyReposiitory.findAll();
    }

    public Property updateProperty(int id , Property updatedProperty){
        boolean propertyExists = propertyReposiitory.existsById(id);
        if(!propertyExists){
            return null;
        }

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


        boolean catagoryExists = categoryRepository.existsByCategory(updatedProperty.getCategory().getCategory());
        Category category;
        if(catagoryExists){
            category = categoryRepository.findByCategory(updatedProperty.getCategory().getCategory());
        }
        else{
            category = categoryRepository.findByCategory("Other");
        }
        property.setCategory(category);


        boolean typeExists = typeRepository.existsByType(updatedProperty.getType().getType());
        Type type;
        if(typeExists){
            type = typeRepository.findByType(updatedProperty.getType().getType());
        }else{
            type = typeRepository.findByType("Other");
        }
        property.setType(type);



        Address updatedAddress = updatedProperty.getAddress();
        boolean addressExists = addressRepository.existsByStreetLineAndAdditionalStreetAndCityAndStateAndPostCode(updatedAddress.getStreetLine() , updatedAddress.getAdditionalStreet() , updatedAddress.getCity() , updatedAddress.getState() , updatedAddress.getPostCode() );
        if(!addressExists){

            Address address = property.getAddress();

            address.setStreetLine(updatedAddress.getStreetLine());
            address.setAdditionalStreet(updatedAddress.getAdditionalStreet());
            address.setCity(updatedAddress.getCity());
            address.setState(updatedAddress.getState());
            address.setState(updatedAddress.getState());
            address.setPostCode(updatedAddress.getPostCode());

            addressRepository.save(address);
        }



        return propertyReposiitory.save(property);
    }

    public String deleteProperty(int id){
        boolean isExist = propertyReposiitory.existsById(id);

        if(isExist) {
            propertyReposiitory.deleteById(id);
            return "Property deleted successfully";
        }else {
            return "Property doesn't exist";
        }
    }


}
