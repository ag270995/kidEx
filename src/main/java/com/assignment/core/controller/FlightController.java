package com.assignment.core.controller;
import com.assignment.core.enums.Status;
import com.assignment.core.model.Booking;
import com.assignment.core.model.Flight;
import com.assignment.core.pojo.BookingResponse;
import com.assignment.core.pojo.FlightResponse;
import com.assignment.core.service.BookingService;
import com.assignment.core.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FlightController {
    @Autowired
    BookingService bookingService;
    @Autowired
    FlightService flightService;

    @GetMapping("/getAvailableSeats")
    public FlightResponse getAvailableSeats(@RequestParam(value = "flightNumber") String flightNumber) {
        return FlightResponse.getInstance(Status.SUCCESS.getValue(), flightService.getAvailableSeats(flightNumber));
    }

    @PostMapping("/ScheduleFlight")
    public FlightResponse scheduleFlight(@Valid @RequestBody Flight flight) {
        flightService.scheduleFlight(flight);
        return FlightResponse.getInstance(Status.SUCCESS.getValue());
    }

    @PostMapping("/bookSeat")
    public BookingResponse saveFlightBooking(@Valid @RequestBody Booking booking) {
        return BookingResponse.getInstance(Status.SUCCESS.getValue(), bookingService.saveFlightBooking(booking));
    }
}
