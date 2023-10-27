package com.example.trip_itinerary.trip.controller;


import com.example.trip_itinerary.trip.dto.request.TripPatchRequest;
import com.example.trip_itinerary.trip.dto.request.TripSaveRequest;
import com.example.trip_itinerary.trip.dto.response.TripFindResponse;
import com.example.trip_itinerary.trip.dto.response.TripListFindResponse;
import com.example.trip_itinerary.trip.service.TripService;
import com.example.trip_itinerary.util.DateUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService){
        this.tripService = tripService;
    }

    @ApiOperation(value = "여행 저장", notes = "여행 정보를 입력받아 저장한다")
    @ApiResponses(
            @ApiResponse(code = 200, message = "저장 성공")
    )
    @ApiImplicitParam(
            name = "여행 정보",
            value = "이름, 시작 날짜, 종료 날짜, 국내외 여부"
    )
    @PostMapping
    public Long saveTrip(@RequestBody @Validated TripSaveRequest tripSaveRequest) {
        return tripService.saveTrip(tripSaveRequest);
    }

    @GetMapping
    public List<TripListFindResponse> getAllTrips(){
        return tripService.findAllTrips();
    }

    @GetMapping("/{id}")
    public TripFindResponse getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    @PatchMapping("/{id}")
    public Long updateTripById(@PathVariable Long id, @RequestBody TripPatchRequest tripPatchRequest){
        return tripService.updateTrip(id, tripPatchRequest);
    }


}
