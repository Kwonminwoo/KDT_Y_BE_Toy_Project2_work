package com.example.trip_itinerary.itinerary.controller;

import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.itinerary.dto.request.ItinerarySearchRequest;
import com.example.trip_itinerary.itinerary.service.ItineraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ItineraryController {


    private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService){
        this.itineraryService = itineraryService;
    }

    @GetMapping("/{tripId}")
    public ResponseEntity<List<Itinerary>> searchItinerary(@PathVariable int tripId) {
        List<Itinerary> itineraries = itineraryService.searchItineraryByTripId(tripId);
        return ResponseEntity.ok(itineraries);
    }
}
