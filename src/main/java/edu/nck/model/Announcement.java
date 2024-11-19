package edu.nck.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Announcement {
    private String announcementId;
    private String description;
    private String age;
    private String organ;
    private String status;
    private String patientId;
}
