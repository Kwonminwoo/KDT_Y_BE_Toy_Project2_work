package com.example.trip_itinerary.itinerary.controller;

import com.example.trip_itinerary.itinerary.dto.request.*;
import com.example.trip_itinerary.itinerary.dto.request.update.AccommodationPatchRequest;
import com.example.trip_itinerary.itinerary.dto.request.update.ItineraryPatchRequest;
import com.example.trip_itinerary.itinerary.dto.request.update.StayPatchRequest;
import com.example.trip_itinerary.itinerary.dto.request.update.TransportPatchRequest;
import com.example.trip_itinerary.itinerary.service.ItineraryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
public class ItineraryController {

    private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService){
        this.itineraryService = itineraryService;
    }

    @PostMapping("/{id}/transport")
    public Long saveItinerary(@RequestBody TransportSaveRequest transportSaveRequest, @PathVariable Long id){
        return itineraryService.saveItinerary(id, transportSaveRequest);
    }

    @PostMapping("/{id}/accommodation")
    public Long saveItinerary(@RequestBody AccommodationSaveRequest accommodationSaveRequest, @PathVariable Long id){
        return itineraryService.saveItinerary(id, accommodationSaveRequest);
    }

    @PostMapping("/{id}/stay")
    public Long saveItinerary(@RequestBody StaySaveRequest staySaveRequest, @PathVariable Long id){
        return itineraryService.saveItinerary(id, staySaveRequest);
    }

    @PatchMapping("/itineraries/{id}")
    public Long patchItinerary(@PathVariable Long id, @RequestBody ItineraryPatchRequest itineraryPatchRequest){
        return itineraryService.patchItinerary(id, itineraryPatchRequest);
    }
}
