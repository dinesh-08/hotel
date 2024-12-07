package com.example.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.Feedback;


@Repository
public interface FeedBackRepository extends JpaRepository<Feedback, Long> {

	@Query("SELECT f FROM Feedback f WHERE f.booking.booking_id = :bookingId")
    Optional<Feedback> findByBookingId(Long bookingId);
}
