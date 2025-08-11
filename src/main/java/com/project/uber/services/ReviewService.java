package com.project.uber.services;

import com.project.uber.model.Review;
import com.project.uber.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************");
        Review r = Review.builder()
                .content("Amazing ride quality")
                .rating(4.0).build(); // code to create plain java object

        System.out.println(r);
        reviewRepository.save(r); // this code executes sql query

        List<Review> reviews = reviewRepository.findAll();

        for(Review review : reviews) {
            System.out.println(review);
        }
        reviewRepository.deleteById(1L);
    }
}