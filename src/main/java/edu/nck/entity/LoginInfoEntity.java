package edu.nck.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "login_info")
@Table(name = "login_info")
public class LoginInfoEntity {
    @Id
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @OneToOne(mappedBy = "donorLoginInfo")
    private DonorEntity donorEntity;
}
