package com.alphabit.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

//create getters and setters
@Data
//use this class to create ORM entity
@Entity
//default constructor
@NoArgsConstructor
//constructor with all the parameters
@AllArgsConstructor
@Table(name = "ROLE")
public class Role {

    //enum to set only the declared roles at runtime
    public enum RoleType {
        DRIVER,
        ASSISTANT
    }

    @Id
    //assumed length of NIC as 12
    @Column(length = 12)
    private String nic;

    @NotEmpty
    private String organization;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
