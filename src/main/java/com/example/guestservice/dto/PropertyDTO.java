package com.example.guestservice.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class PropertyDTO {

    private String propertyName;
    private String price;
    private String area;
    private int action;
    private int ageYears;
    private String furnishing;
    private Date availableFrom;
    private Date availableTo;
    private String parkingAvailability;
    private LocalDateTime createdAt;
    private List<ImageDTO> images;
    private List<SocietyAmenitiesDTO> societyAmenities;
    private List<FlatAmenitiesDTO> flatAmenities;
    private CategoryDTO category;
    private TypeDTO type;
    private AddressDTO address;

}
