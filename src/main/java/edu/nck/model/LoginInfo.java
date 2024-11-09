package edu.nck.model;

import edu.nck.entity.DonorEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginInfo {
    private String email;
    private String password;
    private String role;
}
