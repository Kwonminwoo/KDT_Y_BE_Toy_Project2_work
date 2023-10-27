package com.example.trip_itinerary.itinerary.repository;

import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.trip.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
}
