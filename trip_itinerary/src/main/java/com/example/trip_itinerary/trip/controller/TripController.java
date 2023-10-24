package com.example.trip_itinerary.trip.controller;


import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import com.example.trip_itinerary.trip.dto.response.TripFindResponse;
import com.example.trip_itinerary.trip.service.TripService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService){
        this.tripService = tripService;
    }

    @PostMapping
    public ResponseEntity saveTrip(TripSaveRequest tripSaveRequest) {

        Trip trip = tripService.saveTrip(tripSaveRequest);

        // 리다이렉트
        return new ResponseEntity(null);
    }

    @GetMapping
    public List<TripFindResponse> getAllTrips(){
       return tripService.findAllTrips();
    }
}
