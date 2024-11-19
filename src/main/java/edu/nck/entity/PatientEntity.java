package edu.nck.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity(name ="patient")
@Table(name ="patient")
public class PatientEntity {
    @Id
    private String patientId;
    private String name;
    private String age;
    private String bloodType;
    private String organ;

}
