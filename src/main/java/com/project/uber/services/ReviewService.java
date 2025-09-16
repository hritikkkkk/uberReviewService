package com.project.uber.services;

import com.project.uber.dto.ReviewRequestDTO;
import com.project.uber.model.Review;
import org.springframework.stereotype.Service;


@Service
public interface ReviewService {

    public Review publishReview(ReviewRequestDTO reviewRequestDTO);


}