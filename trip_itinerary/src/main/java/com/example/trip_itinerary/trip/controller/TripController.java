package com.example.trip_itinerary.trip.controller;


import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import com.example.trip_itinerary.trip.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService){
        this.tripService = tripService;
    }

    @PostMapping
    public ResponseEntity saveTrip(TripSaveRequest tripSaveRequest){

        Trip trip = tripService.saveTrip(tripSaveRequest);
        // 리다이렉트
        return new ResponseEntity(null);
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips(){
       return tripService.findAllTrips();

        //List<Trip> trips = tripService.findAllTrips();
        //return new ResponseEntity<>(trips, HttpStatus.OK);
    }
}
