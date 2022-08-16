package com.example.guestservice.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class FlatAmenities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flatId;

    @Column(nullable = false)
    private String name;

    public FlatAmenities() {
    }

    public FlatAmenities(int flatId, String name) {
        this.flatId = flatId;
        this.name = name;
    }

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
