package com.example.trip_itinerary.trip.service;

import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripPatchRequest;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TripService {
    public Trip saveTrip(TripSaveRequest tripSaveRequest);
    public Trip getTripById(Long id);
    Long patchTrip(Long id, TripPatchRequest tripPatchRequest);
}
