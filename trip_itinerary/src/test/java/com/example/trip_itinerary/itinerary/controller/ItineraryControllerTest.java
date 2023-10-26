package com.example.trip_itinerary.itinerary.controller;

import com.example.trip_itinerary.itinerary.domain.Accommodation;
import com.example.trip_itinerary.itinerary.service.ItineraryService;
import com.example.trip_itinerary.itinerary.service.ItineraryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
class ItineraryControllerTest {
//    @Autowired
//    MockMvc mvc;
//
//    @MockBean
//    ItineraryServiceImpl itineraryService;
//
//    @Test
//    void saveItinerary() throws Exception{
//        Long id = 1L;
//        given(itineraryService.saveItinerary(any(), any()))
//                .willReturn(id);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValueAsString(Accommodation.of("name", null, ))
//
//        mvc.perform(
//                post("/trips/" + id + "/itinerary")
////                        .content()
//        );
//
//    }
//
//    @Test
//    void patchItinerary() {
//    }
}