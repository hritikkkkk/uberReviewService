package com.project.uber.services;

import com.project.uber.model.Booking;
import com.project.uber.repositories.BookingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private static final Logger log = LoggerFactory.getLogger(BookingService.class);

    /**
     * Find a booking by its ID.
     * Throws EntityNotFoundException if booking does not exist.
     */
    public Booking findBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Booking with id {} not found", id);
                    return new EntityNotFoundException("Booking with id " + id + " not found");
                });
    }
}
