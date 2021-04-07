package com.assignment.core.service;

import com.assignment.core.exception.ConflictException;
import com.assignment.core.exception.NotFoundException;
import com.assignment.core.model.Flight;
import com.assignment.core.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    public int getAvailableSeats(String flightNumber) {
        Flight flight = getFlight(flightNumber);
        return flight.getAvailableSeats();
    }

    public void scheduleFlight(Flight newFlight) {
        Optional<Flight> flightById = flightRepository.findById(newFlight.getFlightNumber());
        if (flightById.isPresent()) {
            logger.error("Flight : {} already exists", newFlight.getFlightNumber());
            throw new ConflictException("Flight already exists");
        }
        newFlight.setAvailableSeats(newFlight.getNoOfSeats());
        saveFlight(newFlight);
    }

    public Flight getFlight(String flightNumber) {
        Optional<Flight> flightById = flightRepository.findById(flightNumber);
        if (!flightById.isPresent()) {
            logger.error("No such flight found with number : {}", flightNumber);
            throw new NotFoundException("No such flight found with number " + flightNumber);
        }
        return flightById.get();
    }

    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }


}
