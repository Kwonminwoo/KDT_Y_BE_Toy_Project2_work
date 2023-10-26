package com.example.trip_itinerary.trip.controller;


import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.trip.dto.request.TripPatchRequest;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import com.example.trip_itinerary.trip.dto.response.TripFindResponse;
import com.example.trip_itinerary.trip.dto.response.TripListFindResponse;
import com.example.trip_itinerary.trip.exception.InvalidDateException;
import com.example.trip_itinerary.trip.exception.InvalidDateFormatException;
import com.example.trip_itinerary.trip.exception.TripErrorCode;
import com.example.trip_itinerary.trip.service.TripService;
import com.example.trip_itinerary.util.DateUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService){
        this.tripService = tripService;
    }

    @PostMapping
    public Long saveTrip(@RequestBody @Validated TripSaveRequest tripSaveRequest) {
        checkValidDateRange(tripSaveRequest.getStartDate(), tripSaveRequest.getEndDate());
        return tripService.saveTrip(tripSaveRequest);
    }

    @GetMapping
    public List<TripListFindResponse> getAllTrips(){
        return tripService.findAllTrips();
    }

    @GetMapping("/{id}")
    public TripFindResponse getDetailTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    @PatchMapping("/{id}")
    public Long patchTripById(@PathVariable Long id, @RequestBody TripPatchRequest tripPatchRequest){
        return tripService.patchTrip(id, tripPatchRequest);
    }

    private void checkValidDateRange(String startDate, String endDate) {
        if (DateUtil.toLocalDate(endDate).isBefore(DateUtil.toLocalDate(startDate))) {
            throw new InvalidDateException(TripErrorCode.INVALID_DATE_RANGE);
        }
    }
}