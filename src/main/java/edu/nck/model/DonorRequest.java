package edu.nck.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DonorRequest {
    private String donorEmail;
    private String donorFirstName;
    private String donorLastName;
    private String donorPhone;
    private String donorBloodType;
    private String patientFirstName;
    private String patientLastName;
    private String patientAge;
    private String patientOrgan;
    private String patientBloodType;
}
