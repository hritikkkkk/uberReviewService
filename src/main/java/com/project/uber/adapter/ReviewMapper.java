package com.project.uber.adapter;

import com.hritik.entity_service.model.Review;
import com.project.uber.dto.ReviewResponseDTO;

import org.springframework.stereotype.Component;

@Component
public interface ReviewMapper {
    ReviewResponseDTO toResponseDto(Review review);
}