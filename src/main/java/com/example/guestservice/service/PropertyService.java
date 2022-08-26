package com.example.guestservice.service;

import com.example.guestservice.entity.*;
import com.example.guestservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

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

    @Autowired
    private ImageRepository imageRepository;


    public Property addProperty(Property property){
        return propertyRepository.save(property);
    }

    public Property getProperty(int id){
        return propertyRepository.findById(id).orElse(null);
    }

    public List<Property> getAllProperty(){
        return propertyRepository.findAll();
    }

    public Property updateProperty(int id , Property updatedProperty){

        Property property = propertyRepository.findById(id).orElse(null);

        property.setPrice(updatedProperty.getPrice());
        property.setPropertyName(updatedProperty.getPropertyName());
        property.setArea(updatedProperty.getArea());
        property.setAction(updatedProperty.getAction());
        property.setAgeYears(updatedProperty.getAgeYears());
        property.setFurnishing(updatedProperty.getFurnishing());
        property.setAvailableFrom(updatedProperty.getAvailableFrom());
        property.setAvailableTo(updatedProperty.getAvailableTo());
        property.setParkingAvailability(updatedProperty.getParkingAvailability());
        property.setSold(updatedProperty.isSold());


        if(!compareListsImages(property.getImages() , updatedProperty.getImages())  ) {
            imageRepository.deleteAllInBatch(property.getImages());
            property.setImages(updatedProperty.getImages());
        }


        if(!compareListsSocietyAmenities(property.getSocietyAmenities() , updatedProperty.getSocietyAmenities())) {
            property.setSocietyAmenities(updatedProperty.getSocietyAmenities());
        }


        if(!compareListsFlatAmenities(property.getFlatAmenities() , updatedProperty.getFlatAmenities())) {
            property.setFlatAmenities(updatedProperty.getFlatAmenities());
        }

        if(!property.getCategory().equals(updatedProperty.getCategory())) {
            Category   category = categoryRepository.findByCategory(updatedProperty.getCategory().getCategory());
            property.setCategory(category);
        }

        if(!property.getType().equals(updatedProperty.getType())){
             Type  type = typeRepository.findByType(updatedProperty.getType().getType());
            property.setType(type);
        }


        if(!property.getAddress().equals(updatedProperty.getAddress())) {
            Address updatedAddress = updatedProperty.getAddress();
            /*
                boolean addressExists = addressRepository.existsByStreetLineAndAdditionalStreetAndCityAndStateAndPostCode(updatedAddress.getStreetLine(), updatedAddress.getAdditionalStreet(), updatedAddress.getCity(), updatedAddress.getState(), updatedAddress.getPostCode());
                if (!addressExists) {
            }*/
            Address address = property.getAddress();
            address.setStreetLine(updatedAddress.getStreetLine());
            address.setAdditionalStreet(updatedAddress.getAdditionalStreet());
            address.setCity(updatedAddress.getCity());
            address.setState(updatedAddress.getState());
            address.setState(updatedAddress.getState());
            address.setPostCode(updatedAddress.getPostCode());

            addressRepository.save(address);
            property.setAddress(address);

        }

        return propertyRepository.save(property);
    }

    public String deleteProperty(int id){
        Property property = propertyRepository.findById(id).orElse(null);
        propertyRepository.deleteById(id);
        return "Property with name " +property.getPropertyName()+" deleted successfully";
    }

    private boolean compareListsImages(List<Image> prevList , List<Image> nextList){
        if(prevList.size()!=nextList.size())
            return false;

        for(int i=0 ; i<prevList.size() ; i++){
            if( !prevList.get(i).equals(nextList.get(i)) )
                return false;
        }

        return true;
    }

    private boolean compareListsSocietyAmenities(List<SocietyAmenities> prevList , List<SocietyAmenities> nextList){
        if(prevList.size()!=nextList.size())
            return false;

        for(int i=0 ; i<prevList.size() ; i++){
            if( !prevList.get(i).equals(nextList.get(i)) )
                return false;
        }

        return true;
    }
    private boolean compareListsFlatAmenities(List<FlatAmenities> prevList , List<FlatAmenities> nextList){
        if(prevList.size()!=nextList.size())
            return false;

        for(int i=0 ; i<prevList.size() ; i++){
            if( !prevList.get(i).equals(nextList.get(i)) )
                return false;
        }

        return true;
    }

}
