package com.example.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.BookingDetails;
import com.example.hotel.model.Invoice;



@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	Optional<Invoice> findByBooking(BookingDetails booking);

	@Query("SELECT i FROM Invoice i WHERE i.booking.booking_id = :bookingId")
    Optional<Invoice> findByBookingId(Long bookingId);
}
