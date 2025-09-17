package com.project.uber.repositories;




import com.hritik.entity_service.model.Booking;
import com.hritik.entity_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    boolean existsByBooking(Booking booking);


}