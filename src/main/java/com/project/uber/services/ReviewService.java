package com.project.uber.services;

import com.project.uber.model.Booking;
import com.project.uber.model.BookingStatus;
import com.project.uber.model.Review;
import com.project.uber.repositories.BookingRepository;
import com.project.uber.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************");
        Review r = Review.builder()
                .content("Amazing ride quality")
                .rating(5.0).build(); // code to create plain java object


        Booking b = Booking.builder()
                .review(r)
                .startTime(new Date())
                .bookingStatus(BookingStatus.SCHEDULED)
                .endTime(new Date())
                .build();



        bookingRepository.save(b);

        Optional<Booking> booking=bookingRepository.findById(8L);
        if(booking.isPresent()){
            bookingRepository.delete(booking.get());
        }


//        System.out.println(r);
//        reviewRepository.save(r); // this code executes sql query
//
//        List<Review> reviews = reviewRepository.findAll();
//        List<Review> sortedStudents = reviewRepository.findAll(Sort.by("rating").ascending());
//        System.out.println("sortedStudents:"+sortedStudents);
//
//        for(Review review : reviews) {
//            System.out.println(review);
//        }

    }
}