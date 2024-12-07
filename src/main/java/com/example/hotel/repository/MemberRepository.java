package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

 //   List<Invoice> findByBooking_BookingId(Long bookingId);
}

