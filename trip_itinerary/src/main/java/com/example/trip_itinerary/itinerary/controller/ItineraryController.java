package com.example.trip_itinerary.itinerary.controller;

import com.example.trip_itinerary.itinerary.domain.Accommodation;
import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.itinerary.domain.Stay;
import com.example.trip_itinerary.itinerary.domain.Transport;
import com.example.trip_itinerary.itinerary.dto.request.AccommodationSaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.ItinerarySaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.StaySaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.TransportSaveRequest;
import com.example.trip_itinerary.itinerary.service.ItineraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itineraries")
public class ItineraryController {

    private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService){
        this.itineraryService = itineraryService;
    }

    @PostMapping("/{id}")
    public ResponseEntity saveItinerary(ItinerarySaveRequest itinerarySaveRequest){

        Itinerary itinerary = itineraryService.saveItinerary(itinerarySaveRequest);

        // 리다이렉트
        return new ResponseEntity(null);
    }

    @PostMapping("/transport/{id}")

    public ResponseEntity saveItinerary(TransportSaveRequest transportSaveRequest) {
        Transport transport = itineraryService.saveTransport(transportSaveRequest);
        return TranspResponse;
    }







    @PostMapping("/{id}")
    public ResponseEntity saveAccommodation(AccommodationSaveRequest accommodationSaveRequest) {

        Accommodation accommodation = itineraryService.saveAccommodation(accommodationSaveRequest);
        // 리다이렉트
        return new ResponseEntity(null);
    }

    @PostMapping("/{id}")
    public ResponseEntity saveStay(StaySaveRequest staySaveRequest) {

        Stay stay = itineraryService.saveStay(staySaveRequest);
        // 리다이렉트
        return new ResponseEntity(null);
    }

    @PostMapping("/{id}")
    public ResponseEntity saveTransport(TransportSaveRequest transportSaveRequest) {

        Transport transport = itineraryService.saveTransport(transportSaveRequest);
        // 리다이렉트
        return new ResponseEntity(null);
    }
}
