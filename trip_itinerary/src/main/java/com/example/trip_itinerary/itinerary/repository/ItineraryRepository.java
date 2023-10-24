package com.example.trip_itinerary.itinerary.repository;

import com.example.trip_itinerary.itinerary.domain.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
    @Query("select i from Itinerary i where i.trip.id = :tripid")
    List<Itinerary> searchItineraryByTripId(int tripId);
}
