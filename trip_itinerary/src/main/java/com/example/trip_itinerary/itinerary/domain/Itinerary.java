package com.example.trip_itinerary.itinerary.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(name = "trip_id", nullable = false)
    private Long tripId;

    private String type;

    protected Itinerary(){
    }

    private Itinerary(Long id, String name, Long tripId) {
        this.id = id;
        this.name = name;
        this.tripId = tripId;
    }

    public static Itinerary of(Long id, String name, Long trip_id) {
        return new Itinerary(id, name, trip_id);
    }

}

