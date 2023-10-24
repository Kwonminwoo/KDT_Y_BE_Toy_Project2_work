package com.example.trip_itinerary.trip.service;

import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import org.springframework.stereotype.Service;

public interface TripService {
    public Trip saveTrip(TripSaveRequest tripSaveRequest);
    
    public List<Trip> findAllTrips();


}
