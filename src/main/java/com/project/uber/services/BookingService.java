package com.project.uber.services;

import com.hritik.entity_service.model.Booking;
import com.project.uber.exception.ResourceNotFoundException;
import com.project.uber.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private static final Logger log = LoggerFactory.getLogger(BookingService.class);

    public Booking findBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Booking with id {} not found", id);
                    return new ResourceNotFoundException("Booking with id " + id + " not found");
                });
    }
}
