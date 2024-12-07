package com.example.hotel.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name = "bookings")
public class BookingDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booking_id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    

    @ManyToMany
    @JoinTable(
            name = "booking_member",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "memid")
    )
    private List<Member> members;

    

    
   
	private LocalDate startDate;
    
   
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;
    
    
    private LocalDate bookedDate;
    
    
    
    
    
    
    public LocalDate getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(LocalDate bookedDate) {
		this.bookedDate = bookedDate;
	}
	private boolean isdeleted;
    
    
	
	
	public boolean isIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	public Long getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
   
   
}
