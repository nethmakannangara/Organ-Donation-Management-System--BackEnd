package edu.nck.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity(name = "donors")
@Table(name = "donors")
public class DonorEntity {
    @Id
    private String donorId;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private String gender;

    private String contactNo;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String streetAddressLine1;

    private String streetAddressLine2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String province;

    @Column(nullable = false)
    private String postalCode;

    private String bloodType;

    @Column(nullable = false)
    private LocalDate dateOfRegistration;

    @ElementCollection
    @CollectionTable(name = "organ_type", joinColumns = @JoinColumn(name = "donor_id"))
    private Set<OrganType> organTypeList;

    @OneToOne
    @JoinColumn(name = "login_info_email")
    private LoginInfoEntity donorLoginInfo;
}
