package edu.nck.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Announcement {
    private String patientId;
    private String description;
    private String age;
    private String organ;
    private String status;
}
