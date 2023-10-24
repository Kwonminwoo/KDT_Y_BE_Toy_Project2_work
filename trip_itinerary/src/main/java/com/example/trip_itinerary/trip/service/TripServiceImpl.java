package com.example.trip_itinerary.trip.service;

import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import com.example.trip_itinerary.trip.dto.response.TripFindResponse;
import com.example.trip_itinerary.trip.repository.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<TripFindResponse> findAllTrips(){
        List<Trip> foundTripList = tripRepository.findAll();

        List<TripFindResponse> tripFindResponseList = new ArrayList<>();
        for (int i = 0;i < foundTripList.size();i++) {
            Trip trip = foundTripList.get(i);
            Itinerary itinerary = trip.getItineraryList().get(i);

            TripFindResponse tripFindResponse = TripFindResponse.builder()
                    .id(trip.getId())
                    .name(trip.getName())
                    .startDate(trip.getStartDate())
                    .endDate(trip.getEndDate())
                    .isDomestic(trip.isDomestic())
                    .itineraryName(itinerary.getName())
                    .build();

            tripFindResponseList.add(tripFindResponse);
        }

        return tripFindResponseList;
    }
}
