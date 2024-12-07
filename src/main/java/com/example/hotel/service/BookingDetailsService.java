package com.example.hotel.service;

import java.util.List;

import com.example.hotel.model.BookingDetails;

public interface BookingDetailsService {
	
	 List<BookingDetails> getAllBookings();
	    BookingDetails getBookingById(Long bookingId);
	    List<BookingDetails> getBookingsByGuestName(String guestName);
	    List<BookingDetails> getBookingsStartingAfter(String date);
	    List<BookingDetails> getBookingsEndingBefore(String date);
	    
	    void bookRoom(BookingDetails bookingDetails);
	}


