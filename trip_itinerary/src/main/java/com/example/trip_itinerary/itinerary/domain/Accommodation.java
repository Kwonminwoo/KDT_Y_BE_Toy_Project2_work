package com.example.trip_itinerary.itinerary.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue("accommodation")
public class Accommodation extends Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(name = "check_in",nullable = false, length = 20)
    private String checkIn;

    @Column(name = "check_out", nullable = false, length = 20)
    private String checkOut;

    protected Accommodation() {
    }

    private Accommodation(Long id, String name, String checkIn, String checkOut) {
        this.id = id;
        this.name = name;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public static Accommodation of(Long id, String name, String checkIn, String checkOut) {
        return new Accommodation(id, name, checkIn, checkOut);
    }
}
