package com.project.uber.services;


import com.project.uber.dto.ReviewRequestDTO;
import com.project.uber.dto.ReviewResponseDTO;
import org.springframework.stereotype.Service;


@Service
public interface ReviewService {

    public ReviewResponseDTO publishReview(ReviewRequestDTO reviewRequestDTO);


}