package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.BookingMember;



@Repository
public interface BookingMemberRepository extends JpaRepository<BookingMember, Integer> {

 //   List<Invoice> findByBooking_BookingId(Long bookingId);
}
