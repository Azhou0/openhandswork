package com.openhands.meetingbooking.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer capacity;

    private String description;

    @Column(nullable = false)
    private Boolean isAvailable = true;

    private String facilities;  // Comma-separated list of facilities
}