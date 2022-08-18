package com.example.guestservice.repository;

import com.example.guestservice.entity.SocietyAmenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocietyAmenitiesRepository extends JpaRepository<SocietyAmenities , Integer> {
    boolean existsByName(String name);

    SocietyAmenities findByName(String name);
}
