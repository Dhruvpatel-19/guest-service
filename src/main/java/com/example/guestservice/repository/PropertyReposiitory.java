package com.example.guestservice.repository;

import com.example.guestservice.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyReposiitory extends JpaRepository<Property , Integer> {
}
