package com.example.guestservice.service;

import com.example.guestservice.entity.Type;
import com.example.guestservice.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public Type addType(Type type){
        return typeRepository.save(type);
    }

    public Type getType(int id){
        return typeRepository.findById(id).orElse(null);
    }

    public List<Type> getAllType(){
        return typeRepository.findAll();
    }

    public Type updateType(int id , Type updatedType){

        Type type = typeRepository.findById(id).orElse(null);

        type.setType(updatedType.getType());

        return typeRepository.save(type);
    }

    public String deleteType(int id){
        Type type = typeRepository.findById(id).orElse(null);
        typeRepository.deleteById(id);
        return "Type with name "+type.getType()+" deleted successfully";
    }
}
