package com.example.guestservice.service;

import com.example.guestservice.dto.*;
import com.example.guestservice.entity.*;
import com.example.guestservice.mapstruct.MapStructMapper;
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

    @Autowired
    private MapStructMapper mapStructMapper;

    public List<AllPropertyDTO> getAllProperty(){
        List<Property> propertyList = propertyService.getAllProperty();
        return propertyList.stream().map(property -> mapStructMapper.propertyToAllPropertyDto(property)).collect(Collectors.toList());
    }

    public Property getProperty(int id){
        return propertyService.getProperty(id);
    }

}
