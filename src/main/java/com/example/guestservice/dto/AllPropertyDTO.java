package com.example.guestservice.dto;

import com.example.guestservice.entity.Address;
import com.example.guestservice.entity.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AllPropertyDTO {

    private int propertyId;
    private String propertyName;
    private String price;
    private String area;
    private List<Image> images;
    private boolean isSold;
    private Address address;

}
