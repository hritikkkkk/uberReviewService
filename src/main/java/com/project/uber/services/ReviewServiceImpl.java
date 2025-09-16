package com.project.uber.services;

import com.project.uber.dto.ReviewRequestDTO;
import com.project.uber.model.Booking;
import com.project.uber.model.Review;
import com.project.uber.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookingService bookingService;

    @Override
    public Review publishReview(ReviewRequestDTO requestDTO) {
        Booking booking = bookingService.findBookingById(requestDTO.getBookingId());

        Review review = Review.builder()
                .booking(booking)
                .content(requestDTO.getContent())
                .rating(requestDTO.getRating())
                .build();

       return reviewRepository.save(review);
    }
}
