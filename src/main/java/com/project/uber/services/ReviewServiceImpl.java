package com.project.uber.services;

import com.project.uber.dto.ReviewRequestDTO;
import com.project.uber.dto.ReviewResponseDTO;
import com.project.uber.model.Booking;
import com.project.uber.model.Review;
import com.project.uber.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookingService bookingService;
    private static final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);

    @Override
    public ReviewResponseDTO publishReview(ReviewRequestDTO requestDTO) {
        Booking booking = bookingService.findBookingById(requestDTO.getBookingId());

        Review review = Review.builder()
                .booking(booking)
                .content(requestDTO.getContent())
                .rating(requestDTO.getRating())
                .build();

        Review savedReview = reviewRepository.save(review);
        log.info("Published review {} for booking {}", savedReview.getId(), booking.getId());

        return mapToResponseDTO(savedReview);
    }

    private ReviewResponseDTO mapToResponseDTO(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .rating(review.getRating())
                .content(review.getContent())
                .build();
    }
}
