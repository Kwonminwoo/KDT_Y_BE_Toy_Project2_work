package com.example.trip_itinerary.trip.service;

import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripPatchRequest;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import com.example.trip_itinerary.trip.dto.response.TripFindResponse;

import java.util.List;

import java.util.List;

public interface TripService {
    public Trip saveTrip(TripSaveRequest tripSaveRequest);
    public Trip getTripById(Long id);
    Long patchTrip(Long id, TripPatchRequest tripPatchRequest);
    public List<TripFindResponse> findAllTrips();
}
