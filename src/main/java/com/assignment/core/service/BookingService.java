package com.assignment.core.service;

import com.assignment.core.enums.Status;
import com.assignment.core.exception.LimitExceededException;
import com.assignment.core.exception.NotFoundException;
import com.assignment.core.model.Booking;
import com.assignment.core.model.Flight;
import com.assignment.core.pojo.BookingResponse;
import com.assignment.core.repository.BookingRepository;
import com.assignment.core.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    FlightService flightService;
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    public synchronized Integer saveFlightBooking(Booking booking) {
        Flight flight = flightService.getFlight(booking.getFlightNumber());
        int availableSeats = flight.getAvailableSeats();
        if (availableSeats <= 0) {
            logger.error("All flight tickets are full, available seats : {}", flight.getAvailableSeats());
            throw new LimitExceededException("Tickets full");
        }
        int allocatedSeatNumber = flight.getNoOfSeats() - availableSeats + 1;
        booking.setSeatNumber(allocatedSeatNumber);
        bookingRepository.save(booking);

        flight.setAvailableSeats(availableSeats - 1);
        flightService.saveFlight(flight);
        return allocatedSeatNumber;

    }
}
