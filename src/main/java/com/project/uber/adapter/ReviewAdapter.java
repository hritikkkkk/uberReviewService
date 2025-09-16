package com.project.uber.adapter;

import com.project.uber.dto.ReviewResponseDTO;
import com.project.uber.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewAdapter implements ReviewMapper {
    @Override
    public ReviewResponseDTO toResponseDto(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .rating(review.getRating())
                .content(review.getContent())
                .bookingId(review.getBooking().getId())
                .build();
    }
}
