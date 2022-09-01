package com.example.guestservice.service;

import com.example.guestservice.dto.*;
import com.example.guestservice.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GuestService {

    @Autowired
    private PropertyService propertyService;

    public List<AllPropertyDTO> getAllProperty(){
        List<Property> propertyList = propertyService.getAllProperty();
        return propertyList.stream().map(this::toAllPropertyDTO).collect(Collectors.toList());
    }

    public Property getProperty(int id){
        return propertyService.getProperty(id);
    }
    private AllPropertyDTO toAllPropertyDTO(Property property){
        if(property == null)
            return null;

        AllPropertyDTO allPropertyDTO = new AllPropertyDTO();

        allPropertyDTO.setPropertyId(property.getPropertyId());
        allPropertyDTO.setPropertyName(property.getPropertyName());
        allPropertyDTO.setPrice(property.getPrice());
        allPropertyDTO.setArea(property.getArea());
        allPropertyDTO.setImage(property.getImages().get(0).getImage());
        allPropertyDTO.setAddress(property.getAddress());

        return allPropertyDTO;
    }

}
