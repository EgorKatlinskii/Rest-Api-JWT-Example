package com.example.testTask.Model;

import com.example.testTask.Enums.UserRole;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="User")
public class User {

    @Id
    @NotNull
    @Column(name = "login")
    private String login;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

}
