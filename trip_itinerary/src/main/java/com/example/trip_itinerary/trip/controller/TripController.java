package com.example.trip_itinerary.trip.controller;


import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripPatchRequest;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import com.example.trip_itinerary.trip.dto.response.TripFindResponse;
import com.example.trip_itinerary.trip.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/test/3"));
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
        // Rest API로 반환을 하는데, 여기서도 리다이렉트 요청을 보낼 수 있나? 많이 사용되는 방식인가?
        // 헤더 값 변경해서 보낼 수 있던데 써도 되는건가?
        // 리다이렉트
        저장 -> id 반환 -> "trips/2"
        return new ResponseEntity(null);
    }

    @GetMapping
    public List<TripFindResponse> getAllTrips(){
       return tripService.findAllTrips();
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<Itinerary>> getDetailTrip(@PathVariable Long id) {
        Trip tripById = tripService.getTripById(id);
//        List<Itinerary> itineraries = itineraryService.searchItineraryByTripId(id);
//        return ResponseEntity.ok(itineraries);
        return null;
    public Long patchTripById(@PathVariable Long id, @RequestBody TripPatchRequest tripPatchRequest){
        return tripService.patchTrip(id, tripPatchRequest);
    }
}
