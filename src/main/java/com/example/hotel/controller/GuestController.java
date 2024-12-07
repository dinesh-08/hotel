package com.example.hotel.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.model.BookingDetails;
import com.example.hotel.model.Room;
import com.example.hotel.repository.BookingDetailsRepository;
import com.example.hotel.service.BookingDetailsService;
import com.example.hotel.service.RoomService;

	


@RestController
@RequestMapping("/api/guest")
@CrossOrigin
public class GuestController {


    @Autowired
    BookingDetailsRepository bookingDetailsRepository;

   @Autowired 
   RoomService roomService;
   
   @Autowired 
   BookingDetailsService bookingService;
   

    // Sample data for booking
    @PostMapping("/book-room")
    public ResponseEntity<String> bookRoom(@RequestBody BookingDetails bookingDetails) {
        Long bookingId = bookingDetails.getBooking_id();
        if (bookingDetailsRepository.existsById(bookingId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Room with Booking ID " + bookingId + " already exists.");
        }
        bookingDetailsRepository.save(bookingDetails);
        return ResponseEntity.ok("Room booked successfully");
    }

    @GetMapping("/view-booked-rooms")
    public ResponseEntity<List<BookingDetails>> viewBookedRooms() {
        List<BookingDetails> bookedRooms = bookingDetailsRepository.findAll();
        // Return the list of booked rooms for the guest
        return ResponseEntity.ok(bookedRooms);
    }

    // Sample data for providing feedback
    private List<Feedback> feedbackList = new ArrayList<>();

    @PostMapping("/provide-feedback")
    public ResponseEntity<String> provideFeedback(@RequestBody Feedback guestFeedback) {
        // Logic to store guest feedback
        feedbackList.add(guestFeedback);
        return ResponseEntity.ok("Feedback submitted successfully");
    }

    @GetMapping("/get-feedback")
    public ResponseEntity<List<Feedback>> getFeedback() {
        // Return the list of feedback provided by the guest
        return ResponseEntity.ok(feedbackList);
    }
    
    @GetMapping("/filter-rooms")
    public ResponseEntity<List<Room>> filterRooms(@RequestParam(required = false) String type,
                                                  @RequestParam(required = false) Integer capacity,
                                                  @RequestParam(required = false) Double price,
                                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
    	
        List<Room> availableRooms = roomService.getAllRooms();
        bookingDetailsRepository.updateIsDeletedStatus();
        List<Room> filteredRooms = availableRooms.stream()
                .filter(room -> type == null || room.getType().equals(type))
                .filter(room -> capacity == null || room.getCapacity() >= capacity)
                .filter(room -> price == null || room.getPrice() <= price)
                .filter(room -> isRoomAvailable(room, startDate, endDate)) // Check room availability
                .collect(Collectors.toList());
                



        return ResponseEntity.ok(new ArrayList<>(filteredRooms));
    }

    private boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate) {
        
      List<BookingDetails> bookings = bookingDetailsRepository.findByRoomAndStartDateBetweenAndEndDateBetween(room, startDate, endDate);

        // If there are no bookings for the room within the specified date range, it is available
        return bookings.isEmpty();
    }
   
  
}


