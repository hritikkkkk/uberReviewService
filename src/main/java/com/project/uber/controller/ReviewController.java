package com.project.uber.controller;

import com.hritik.entity_service.model.Review;
import com.project.uber.adapter.ReviewAdapter;
import com.project.uber.dto.ReviewRequestDTO;
import com.project.uber.dto.ReviewResponseDTO;
import com.project.uber.services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewAdapter reviewAdapter;

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> publishReview(
            @Valid @RequestBody ReviewRequestDTO requestDTO) {

        Review savedReview = reviewService.publishReview(requestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reviewAdapter.toResponseDto(savedReview));
    }


}
