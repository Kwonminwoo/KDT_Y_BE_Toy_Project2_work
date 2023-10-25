package com.example.trip_itinerary.itinerary.service;

import com.example.trip_itinerary.itinerary.domain.Accommodation;
import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.itinerary.domain.Stay;
import com.example.trip_itinerary.itinerary.domain.Transport;
import com.example.trip_itinerary.itinerary.dto.request.AccommodationSaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.ItinerarySaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.StaySaveRequest;
import com.example.trip_itinerary.itinerary.dto.request.TransportSaveRequest;

public interface ItineraryService {
    public Itinerary saveItinerary(ItinerarySaveRequest itinerarySaveRequest);
    public Accommodation saveAccommodation(AccommodationSaveRequest accommodationSaveRequest);
    public Stay saveStay(StaySaveRequest staySaveRequest);
    public Transport saveTransport(TransportSaveRequest transportSaveRequest);
}
