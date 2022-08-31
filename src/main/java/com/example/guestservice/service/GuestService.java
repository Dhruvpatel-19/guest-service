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

    public PropertyDTO getProperty(int id){
        Property property = propertyService.getProperty(id);
        return toPropertyDTO(property);
    }
    private AllPropertyDTO toAllPropertyDTO(Property property){
        if(property == null)
            return null;

        AllPropertyDTO allPropertyDTO = new AllPropertyDTO();
        AddressDTO addressDTO = toAddressDTO(property.getAddress());

        allPropertyDTO.setPropertyName(property.getPropertyName());
        allPropertyDTO.setPrice(property.getPrice());
        allPropertyDTO.setArea(property.getArea());
        allPropertyDTO.setImage(property.getImages().get(0).getImage());
        allPropertyDTO.setAddress(addressDTO);

        return allPropertyDTO;
    }

    private PropertyDTO toPropertyDTO(Property property){
        if(property == null)
            return null;

        PropertyDTO propertyDTO = new PropertyDTO();

        List<ImageDTO> imageDTOList = toImageDTOList(property.getImages());
        List<SocietyAmenitiesDTO> societyAmenitiesDTOList = toSocietyAmenitiesDTOList(property.getSocietyAmenities());
        List<FlatAmenitiesDTO> flatAmenitiesDTOList = toFlatAmenitiesDTOList(property.getFlatAmenities());
        CategoryDTO categoryDTO = toCategoryDTO(property.getCategory());
        TypeDTO typeDTO = toTypeDTO(property.getType());
        AddressDTO addressDTO = toAddressDTO(property.getAddress());

        propertyDTO.setPropertyName(property.getPropertyName());
        propertyDTO.setPrice(property.getPrice());
        propertyDTO.setArea(property.getArea());
        propertyDTO.setAction(property.getAction());
        propertyDTO.setAgeYears(property.getAgeYears());
        propertyDTO.setFurnishing(property.getFurnishing());
        propertyDTO.setAvailableFrom(property.getAvailableFrom());
        propertyDTO.setAvailableTo(property.getAvailableTo());
        propertyDTO.setParkingAvailability(property.getParkingAvailability());
        propertyDTO.setSold(property.isSold());
        propertyDTO.setCreatedAt(property.getCreatedAt());
        propertyDTO.setImages(imageDTOList);
        propertyDTO.setSocietyAmenities(societyAmenitiesDTOList);
        propertyDTO.setFlatAmenities(flatAmenitiesDTOList);
        propertyDTO.setCategory(categoryDTO);
        propertyDTO.setType(typeDTO);
        propertyDTO.setAddress(addressDTO);

        return propertyDTO;
    }

    private AddressDTO toAddressDTO(Address address){
        if(address == null)
            return null;

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreetLine(address.getStreetLine());
        addressDTO.setAdditionalStreet(address.getAdditionalStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setPostCode(address.getPostCode());
        return addressDTO;
    }

    private List<ImageDTO> toImageDTOList(List<Image> imageList){
        return imageList.stream().map(this::toImageDTO).collect(Collectors.toList());
    }
    private ImageDTO toImageDTO(Image image){
        if(image == null)
            return null;
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImage(image.getImage());
        return imageDTO;
    }

    private CategoryDTO toCategoryDTO(Category category){
        if(category==null)
            return null;
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategory(category.getCategory());
        return categoryDTO;
    }

    private TypeDTO toTypeDTO(Type type){
        if(type==null)
            return null;
        TypeDTO typeDTO = new TypeDTO();
        typeDTO.setType(type.getType());
        return typeDTO;
    }

    private List<FlatAmenitiesDTO> toFlatAmenitiesDTOList(List<FlatAmenities> flatAmenitiesList){
        return flatAmenitiesList.stream().map(this::toFlatAmenitiesDTO).collect(Collectors.toList());
    }
    private FlatAmenitiesDTO toFlatAmenitiesDTO(FlatAmenities flatAmenities){
        if(flatAmenities == null)
            return null;
        FlatAmenitiesDTO flatAmenitiesDTO = new FlatAmenitiesDTO();
        flatAmenitiesDTO.setName(flatAmenities.getName());
        return flatAmenitiesDTO;
    }

    private List<SocietyAmenitiesDTO> toSocietyAmenitiesDTOList(List<SocietyAmenities> societyAmenitiesList){
        return societyAmenitiesList.stream().map(this::toSocietyAmenitiesDTO).collect(Collectors.toList());
    }
    private SocietyAmenitiesDTO toSocietyAmenitiesDTO(SocietyAmenities societyAmenities){
        if(societyAmenities==null)
            return null;

        SocietyAmenitiesDTO societyAmenitiesDTO = new SocietyAmenitiesDTO();
        societyAmenitiesDTO.setName(societyAmenities.getName());
        return societyAmenitiesDTO;
    }
}
