package com.example.trip_itinerary.trip.service;

import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripPatchRequest;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import com.example.trip_itinerary.trip.dto.response.TripFindResponse;
import com.example.trip_itinerary.trip.dto.response.TripListFindResponse;
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
    public List<TripListFindResponse> findAllTrips(){
        List<Trip> foundTripList = tripRepository.findAll();

        List<TripListFindResponse> tripFindResponseList = new ArrayList<>();
        for (Trip foundTrip : foundTripList) {
            List<String> itineraryNameList = new ArrayList<>();

            for (Itinerary foundItinerary : foundTrip.getItineraryList()) {
                itineraryNameList.add(foundItinerary.getName());
            }

            TripListFindResponse tripListFindResponse = TripListFindResponse.builder()
                    .id(foundTrip.getId())
                    .startDate(foundTrip.getStartDate())
                    .endDate(foundTrip.getEndDate())
                    .isDomestic(foundTrip.isDomestic())
                    .itineraryNameList(itineraryNameList)
                    .build();

            tripFindResponseList.add(tripListFindResponse);
        }

        return tripFindResponseList;
    }

    @Override
    public TripFindResponse getTripById(Long id) {
        Optional<Trip> foundTripOptional = tripRepository.findById(id);
        Trip foundTrip = foundTripOptional.orElseThrow(NoSuchElementException::new);
        return TripFindResponse.fromEntity(foundTrip);
    }

    @Override
    public Long patchTrip(Long id, TripPatchRequest tripPatchRequest) {
        Trip foundTrip = tripRepository.findById(id).orElseThrow(NoSuchElementException::new);
        foundTrip.updateTrip(tripPatchRequest.getName(), tripPatchRequest.getStartDate(),
                tripPatchRequest.getEndDate(), tripPatchRequest.getIsDomestic());
        return foundTrip.getId();
    }

}
