package com.example.trip_itinerary.itinerary.service;

import com.example.trip_itinerary.itinerary.domain.Accommodation;
import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.itinerary.domain.Stay;
import com.example.trip_itinerary.itinerary.domain.Transport;
import com.example.trip_itinerary.itinerary.dto.request.AccommodationSaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.ItinerarySaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.StaySaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.TransportSaveRequest;
import com.example.trip_itinerary.itinerary.repository.ItineraryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItineraryServiceImpl implements ItineraryService {

    private final ItineraryRepository itineraryRepository;

    public ItineraryServiceImpl(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    @Override
    public Itinerary saveItinerary(ItinerarySaveRequest itinerarySaveRequest) {
        Itinerary itinerary = itinerarySaveRequest.toEntity();
        return itineraryRepository.save(itinerary);
    }

    @Override
    public Accommodation saveAccommodation(AccommodationSaveRequest accommodationSaveRequest) {
        Accommodation accommodation = accommodationSaveRequest.toEntity();
        return itineraryRepository.save(accommodation);
    }

    @Override
    public Stay saveStay(StaySaveRequest staySaveRequest) {
        Stay stay = staySaveRequest.toEntity();
        return itineraryRepository.save(stay);
    }

    @Override
    public Transport saveTransport(TransportSaveRequest transportSaveRequest) {
        Transport transport = transportSaveRequest.toEntity();
        return itineraryRepository.save(transport);
    }
}
