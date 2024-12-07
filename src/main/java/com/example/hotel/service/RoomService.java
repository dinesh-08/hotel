package com.example.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hotel.model.Room;




@Service
public interface RoomService {


	List<Room> getAllRooms();
    
	   
    Room getRoomById(Long roomId);
    List<Room> getRoomsByType(String type);
    List<Room> getRoomsByCapacity(Integer capacity);
//    List<Room> getRoomsByAmenity(String amenity);
    void addRoom(Room room);
    void updateRoom(Long roomId, Room room);
    
}