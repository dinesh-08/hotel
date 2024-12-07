package com.example.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hotel.model.Room;
import com.example.hotel.repository.RoomRepository;



public  abstract class RoomServiceImpl implements RoomService{


	

    @Autowired
    private RoomRepository roomRepository;

   
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

   
    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

   
    public List<Room> getRoomsByType(String type) {
        return roomRepository.findByType(type);
    }

   
    public List<Room> getRoomsByCapacity(Integer capacity) {
        return roomRepository.findByCapacityGreaterThanEqual(capacity);
    }


    public void addRoom(Room room) {
        roomRepository.save(room);
    }

   
    public void updateRoom(Long roomId, Room updatedRoom) {
        // Check if the room exists before updating
        Room existingRoom = roomRepository.findById(roomId).orElse(null);
        if (existingRoom != null) {
            updatedRoom.setRoom_id(roomId);
            roomRepository.save(updatedRoom);
        }
    }

   
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}

