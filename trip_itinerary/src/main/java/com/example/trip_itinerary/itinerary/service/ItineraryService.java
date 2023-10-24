package com.example.trip_itinerary.itinerary.service;

import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.itinerary.dto.request.ItinerarySearchRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItineraryService {

    public List<Itinerary> searchItineraryByTripId(int tripId);
}
