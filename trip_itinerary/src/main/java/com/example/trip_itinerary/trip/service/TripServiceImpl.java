package com.example.trip_itinerary.trip.service;

import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.itinerary.domain.Transport;
import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripPatchRequest;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import com.example.trip_itinerary.trip.dto.response.TripFindResponse;
import com.example.trip_itinerary.trip.repository.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

            ItineraryFindResponse itineraryFindResponse = ItineraryFindResponse.builder()
                    .name(itinerary.getName())
                    .build();

            TripFindResponse tripFindResponse = TripFindResponse.builder()
                    .id(trip.getId())
                    .name(trip.getName())
                    .startDate(trip.getStartDate())
                    .endDate(trip.getEndDate())
                    .isDomestic(trip.isDomestic())
//                    .itineraryFindResponse(itineraryFindResponse)
                    .build();

            tripFindResponseList.add(tripFindResponse);
        }

        return tripFindResponseList;
    }

    @Override
    public Trip getTripById(Long id) {
        return null;
    }

    @Override
    public Long patchTrip(Long id, TripPatchRequest tripPatchRequest) {
        Trip foundTrip = tripRepository.findById(id).orElseThrow(NoSuchElementException::new);
        foundTrip.updateTrip(tripPatchRequest.getName(), tripPatchRequest.getStartDate(),
                tripPatchRequest.getEndDate(), tripPatchRequest.getIsDomestic());
        return foundTrip.getId();
    }

}
