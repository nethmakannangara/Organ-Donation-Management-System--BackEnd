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
    private String firstName;
    private String LastName;
    private String address;
    private String bloodType;
    private String organ;

}
