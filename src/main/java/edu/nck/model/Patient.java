package edu.nck.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {
    private String patientId;
    private String name;
    private String age;
    private String bloodType;
    private String organ;
}
