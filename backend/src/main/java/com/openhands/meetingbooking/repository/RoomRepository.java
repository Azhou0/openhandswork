package com.openhands.meetingbooking.repository;

import com.openhands.meetingbooking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByIsAvailable(Boolean isAvailable);
    List<Room> findByCapacityGreaterThanEqual(Integer capacity);
}