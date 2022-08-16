package com.example.guestservice.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class SocietyAmenities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int societyId;
    @Column(nullable = false)
    private String name;

    public SocietyAmenities() {
    }

    public SocietyAmenities(int societyId, String name) {
        this.societyId = societyId;
        this.name = name;
    }

    public int getSocietyId() {
        return societyId;
    }

    public void setSocietyId(int societyId) {
        this.societyId = societyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
