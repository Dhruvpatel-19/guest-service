package com.example.guestservice.mapstruct;

import com.example.guestservice.dto.AllPropertyDTO;
import com.example.guestservice.entity.Property;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    AllPropertyDTO propertyToAllPropertyDto(Property property);
}
