package com.openhands.meetingbooking.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ERole name;

    public enum ERole {
        ROLE_USER,
        ROLE_ADMIN
    }
}