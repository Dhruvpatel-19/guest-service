package com.example.guestservice.repository;

import com.example.guestservice.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyReposiitory extends JpaRepository<Property , Integer> {
    Property findByPropertyId(int id);

    boolean existsByPropertyId(int id);

    void deleteByPropertyId(int id);
}
