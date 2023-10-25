package com.example.trip_itinerary.itinerary.service;

import com.example.trip_itinerary.itinerary.domain.Accommodation;
import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.itinerary.domain.Stay;
import com.example.trip_itinerary.itinerary.domain.Transport;
import com.example.trip_itinerary.itinerary.dto.request.AccommodationSaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.ItinerarySaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.StaySaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.TransportSaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.update.AccommodationPatchRequest;
import com.example.trip_itinerary.itinerary.dto.request.update.ItineraryPatchRequest;
import com.example.trip_itinerary.itinerary.dto.request.update.StayPatchRequest;
import com.example.trip_itinerary.itinerary.dto.request.update.TransportPatchRequest;
import com.example.trip_itinerary.itinerary.repository.ItineraryRepository;
import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.repository.TripRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class ItineraryServiceImpl implements ItineraryService {

    private final ItineraryRepository itineraryRepository;
    private final TripRepository tripRepository;

    public ItineraryServiceImpl(ItineraryRepository itineraryRepository, TripRepository tripRepository) {
        this.itineraryRepository = itineraryRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    public Long saveItinerary(Long id, ItinerarySaveRequest itinerarySaveRequest) {
        Trip foundTrip = tripRepository.findById(id).orElseThrow(NoSuchElementException::new);

        if(itinerarySaveRequest instanceof TransportSaveRequest){
            Transport savedTransport = itineraryRepository.save(((TransportSaveRequest)itinerarySaveRequest).toEntity(foundTrip));
            return savedTransport.getId();
        } else if (itinerarySaveRequest instanceof AccommodationSaveRequest){
            Accommodation savedAccommodation = itineraryRepository.save(((AccommodationSaveRequest)itinerarySaveRequest).toEntity(foundTrip));
            return savedAccommodation.getId();
        } else{
            Stay savedStay = itineraryRepository.save(((StaySaveRequest) itinerarySaveRequest).toEntity(foundTrip));
            return savedStay.getId();
        }
    }
    
    @Override
    public Long patchItinerary(Long id, ItineraryPatchRequest itineraryPatchRequest) {
        Itinerary foundItinerary = itineraryRepository.findById(id).orElseThrow(NoSuchElementException::new);

        if(itineraryPatchRequest instanceof TransportPatchRequest){
            patchTransport((Transport) foundItinerary, (TransportPatchRequest)itineraryPatchRequest);
        }else if(itineraryPatchRequest instanceof AccommodationPatchRequest){
            patchAccommodation((Accommodation) foundItinerary, (AccommodationPatchRequest)itineraryPatchRequest);
        }else if(itineraryPatchRequest instanceof StayPatchRequest){
            patchStay((Stay) foundItinerary, (StayPatchRequest)itineraryPatchRequest);
        }

        return id;
    }

    private void patchTransport(Transport transport, TransportPatchRequest transportPatchRequest) {
        transport.updateTransport(transportPatchRequest.getName(), transportPatchRequest.getTransportation(),
                transportPatchRequest.getStartLocation(), transportPatchRequest.getEndLocation(),
                transportPatchRequest.getStartDate(), transportPatchRequest.getEndDate());
    }
    private void patchAccommodation(Accommodation accommodation, AccommodationPatchRequest accommodationPatchRequest) {
        accommodation.updateAccommodation(accommodationPatchRequest.getName(),accommodationPatchRequest.getAccommodationName(),
                accommodationPatchRequest.getCheckIn(), accommodationPatchRequest.getCheckOut());
    }


    private void patchStay(Stay stay, StayPatchRequest stayPatchRequest) {
        stay.updateStay(stayPatchRequest.getName(), stayPatchRequest.getLocation(),
                stayPatchRequest.getStartDate(), stayPatchRequest.getEndDate());
    }

}
