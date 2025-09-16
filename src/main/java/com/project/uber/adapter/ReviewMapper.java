package com.project.uber.adapter;

import com.project.uber.dto.ReviewResponseDTO;
import com.project.uber.model.Review;
import org.springframework.stereotype.Component;

@Component
public interface ReviewMapper {
    ReviewResponseDTO toResponseDto(Review review);
}