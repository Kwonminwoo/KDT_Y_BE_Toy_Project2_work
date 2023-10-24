package com.example.trip_itinerary.itinerary.service;

import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.itinerary.repository.ItineraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryServiceImpl implements ItineraryService {
    private final ItineraryRepository itineraryRepository;

    public ItineraryServiceImpl(ItineraryRepository itineraryRepository) {
        this.itineraryRepository  = itineraryRepository;
    }

    @Override
    public List<Itinerary> searchItineraryByTripId(int tripId) {
        return itineraryRepository.searchItineraryByTripId(tripId);
    }
}
