package edu.nck.entity;

import edu.nck.model.Patient;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity(name = "announcement")
@Table(name = "announcement")
public class AnnouncementEntity {
    @Id
    private String announcementId;
    @Lob
    private String description;
    private String age;
    @Column(nullable = false)
    private String organ;
    private String status;

    @OneToOne
    @JoinColumn(name = "patient_patientId")
    private PatientEntity patient;
}
