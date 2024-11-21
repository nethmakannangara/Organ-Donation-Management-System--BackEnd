package edu.nck.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {
    private String patientId;
    private String firstName;
    private String LastName;
    private String address;
    private String age;
    private String bloodType;
    private String organ;
}
