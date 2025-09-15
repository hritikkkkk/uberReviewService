package com.project.uber.controller;

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

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> publishReview(@Valid @RequestBody ReviewRequestDTO requestDTO) {
        ReviewResponseDTO response = reviewService.publishReview(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
