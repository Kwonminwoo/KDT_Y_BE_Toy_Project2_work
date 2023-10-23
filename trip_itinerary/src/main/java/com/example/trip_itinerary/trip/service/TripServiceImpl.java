package com.example.trip_itinerary.trip.service;

import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import com.example.trip_itinerary.trip.repository.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TripServiceImpl implements TripService{
    private final TripRepository tripRepository;


    public TripServiceImpl(TripRepository tripRepository){
        this.tripRepository = tripRepository;
    }

    @Override
    public Trip saveTrip(TripSaveRequest tripSaveRequest) {
        Trip trip = tripSaveRequest.toEntity();
        return tripRepository.save(trip);
    }
}
