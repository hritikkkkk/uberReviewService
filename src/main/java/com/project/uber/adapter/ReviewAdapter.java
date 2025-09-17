package com.project.uber.adapter;

import com.hritik.entity_service.model.Review;
import com.project.uber.dto.ReviewResponseDTO;

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
