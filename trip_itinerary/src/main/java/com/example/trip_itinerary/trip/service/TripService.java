package com.example.trip_itinerary.trip.service;

import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import com.example.trip_itinerary.trip.dto.response.TripFindResponse;

import java.util.List;

public interface TripService {
    public Trip saveTrip(TripSaveRequest tripSaveRequest);
    
    public List<TripFindResponse> findAllTrips();


}
