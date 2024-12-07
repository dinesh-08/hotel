package com.example.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hotel.model.BookingDetails;
import com.example.hotel.repository.BookingDetailsRepository;


public abstract class BookingDetailsServiceImpl implements BookingDetailsService {



    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @Override
    public List<BookingDetails> getAllBookings() {
        return bookingDetailsRepository.findAll();
    }

    @Override
    public BookingDetails getBookingById(Long bookingId) {
        return bookingDetailsRepository.findById(bookingId).orElse(null);
    }

    

    @Override
    public List<BookingDetails> getBookingsStartingAfter(String date) {
        return bookingDetailsRepository.findByStartDateAfter(date);
    }

   

    @Override
    public void bookRoom(BookingDetails bookingDetails) {
        bookingDetailsRepository.save(bookingDetails);
    }

	@Override
	public List<BookingDetails> getBookingsByGuestName(String guestName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

