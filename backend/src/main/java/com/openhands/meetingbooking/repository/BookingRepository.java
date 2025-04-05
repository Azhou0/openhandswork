package com.openhands.meetingbooking.repository;

import com.openhands.meetingbooking.model.Booking;
import com.openhands.meetingbooking.model.Room;
import com.openhands.meetingbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
    List<Booking> findByRoom(Room room);
    
    @Query("SELECT b FROM Booking b WHERE b.room = ?1 AND b.status = 'CONFIRMED' AND " +
           "((b.startTime BETWEEN ?2 AND ?3) OR (b.endTime BETWEEN ?2 AND ?3))")
    List<Booking> findConflictingBookings(Room room, LocalDateTime start, LocalDateTime end);
    
    List<Booking> findByUserAndStartTimeGreaterThanEqual(User user, LocalDateTime startTime);
}