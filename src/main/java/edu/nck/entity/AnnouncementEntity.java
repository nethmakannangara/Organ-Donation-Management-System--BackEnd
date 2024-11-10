package edu.nck.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity(name = "announcement")
@Table(name = "announcement")
public class AnnouncementEntity {
    @Id
    private String patientId;
    @Lob
    private String description;
    private String age;
    @Column(nullable = false)
    private String organ;
    private String status;
}
