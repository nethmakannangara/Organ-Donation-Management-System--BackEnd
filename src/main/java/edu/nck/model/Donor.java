package edu.nck.model;

import edu.nck.entity.OrganType;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Donor {
    private String donorId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    private String contactNo;
    private String email;
    private String streetAddressLine1;
    private String streetAddressLine2;
    private String city;
    private String province;
    private String postalCode;
    private String bloodType;

    private LocalDate dateOfRegistration;

    private Set<OrganType> organTypeList;
}
