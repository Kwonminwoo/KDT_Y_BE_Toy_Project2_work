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
import com.example.trip_itinerary.itinerary.exception.InvalidDateTimeException;
import com.example.trip_itinerary.itinerary.exception.ItineraryErrorCode;
import com.example.trip_itinerary.itinerary.exception.ItineraryNotFoundException;
import com.example.trip_itinerary.itinerary.repository.ItineraryRepository;
import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.exception.InvalidDateException;
import com.example.trip_itinerary.trip.exception.TripErrorCode;
import com.example.trip_itinerary.trip.repository.TripRepository;
import com.example.trip_itinerary.util.DateUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        Trip foundTrip = tripRepository.findById(id).orElseThrow(() -> new ItineraryNotFoundException(ItineraryErrorCode.ITINERARY_NOT_FOUND));
        if(itinerarySaveRequest instanceof TransportSaveRequest transportSaveRequest){
            return saveTransport(transportSaveRequest, foundTrip).getId();
        } else if (itinerarySaveRequest instanceof AccommodationSaveRequest accommodationSaveRequest){
            return saveAccommodation(accommodationSaveRequest, foundTrip).getId();
        } else {
            return saveStay((StaySaveRequest) itinerarySaveRequest, foundTrip).getId();
        }
    }

    private Transport saveTransport(TransportSaveRequest request, Trip trip){
        checkValidDateTimeRange(request.getStartDate(), request.getEndDate());
        return itineraryRepository.save(request.toEntity(trip));
    }

    private Accommodation saveAccommodation(AccommodationSaveRequest request, Trip trip){
        checkValidDateTimeRange(request.getCheckIn(), request.getCheckOut());
        return itineraryRepository.save(request.toEntity(trip));
    }

    private Stay saveStay(StaySaveRequest request, Trip trip){
        checkValidDateTimeRange(request.getEndDate(), request.getStartDate());
        return itineraryRepository.save(request.toEntity(trip));
    }

    @Override
    public Long patchItinerary(Long id, ItineraryPatchRequest itineraryPatchRequest) {
        Itinerary foundItinerary = itineraryRepository.findById(id).orElseThrow(() -> new ItineraryNotFoundException(ItineraryErrorCode.ITINERARY_NOT_FOUND));

        if(itineraryPatchRequest instanceof TransportPatchRequest transportPatchRequest ){
            checkValidDateTimeRange(transportPatchRequest.getStartDate(), transportPatchRequest.getEndDate());
            patchTransport((Transport) foundItinerary, transportPatchRequest);
        }else if(itineraryPatchRequest instanceof AccommodationPatchRequest accommodationPatchRequest){
            checkValidDateTimeRange(accommodationPatchRequest.getCheckIn(), accommodationPatchRequest.getCheckOut());
            patchAccommodation((Accommodation) foundItinerary, accommodationPatchRequest);
        }else if(itineraryPatchRequest instanceof StayPatchRequest stayPatchRequest){
            checkValidDateTimeRange(stayPatchRequest.getEndDate(), stayPatchRequest.getStartDate());
            patchStay((Stay) foundItinerary, stayPatchRequest);
        }

        return id;
    }

    private void checkValidDateTimeRange(String startDate, String endDate) {
        if (DateUtil.toLocalDateTime(endDate).isBefore(DateUtil.toLocalDateTime(startDate))) {
            throw new InvalidDateTimeException(ItineraryErrorCode.INVALID_DATE_TIME_RANGE);
        }
    }

    private void patchTransport(Transport transport, TransportPatchRequest transportPatchRequest) {
        transport.updateTransport(transportPatchRequest.getName(), transportPatchRequest.getTransportation(),
                transportPatchRequest.getStartLocation(), transportPatchRequest.getEndLocation(),
                DateUtil.toLocalDateTime(transportPatchRequest.getStartDate()), DateUtil.toLocalDateTime(transportPatchRequest.getEndDate()));
    }
    private void patchAccommodation(Accommodation accommodation, AccommodationPatchRequest accommodationPatchRequest) {
        accommodation.updateAccommodation(accommodationPatchRequest.getName(), accommodationPatchRequest.getAccommodationName(),
                DateUtil.toLocalDateTime(accommodationPatchRequest.getCheckIn()), DateUtil.toLocalDateTime(accommodationPatchRequest.getCheckOut()));
    }


    private void patchStay(Stay stay, StayPatchRequest stayPatchRequest) {
        stay.updateStay(stayPatchRequest.getName(), stayPatchRequest.getLocation(),
                DateUtil.toLocalDateTime(stayPatchRequest.getStartDate()), DateUtil.toLocalDateTime(stayPatchRequest.getEndDate()));
    }

}
