package com.project.uber.services;

import com.project.uber.model.Booking;
import com.project.uber.model.BookingStatus;
import com.project.uber.model.Driver;
import com.project.uber.model.Review;
import com.project.uber.repositories.BookingRepository;
import com.project.uber.repositories.DriverRepository;
import com.project.uber.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    private final DriverRepository driverRepository;

    public void run(String... args) throws Exception {

//        Review r = Review.builder()
//                .content("Amazing ride quality")
//                .rating(5.0).build();
//
//
//        Booking b = Booking.builder()
//                .review(r)
//                .startTime(new Date())
//                .bookingStatus(BookingStatus.SCHEDULED)
//                .endTime(new Date())
//                .build();
//
//
//        bookingRepository.save(b);

        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L));
        List<Driver> drivers = driverRepository.findAllByIdIn(driverIds);
        for (Driver d : drivers) {
            System.out.println("***********");
            System.out.println(d.getName());
            System.out.println(d.getBookings().stream().count());
            System.out.println("**********");
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