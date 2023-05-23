package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can't be empty")
    @Size(min = 4,message = "the name sould be at least 4 character")
    @Column(columnDefinition ="varbinary (20) not null ")
    private String name;

    @NotEmpty(message = "username can't be empty")
    @Size(min = 4,message = "the username sould be at least 4 character")
    @Column(columnDefinition = "varbinary (20) not null ")
    private String username;

    @NotEmpty(message = "password can't be empty")
    @Column(columnDefinition = "varbinary(20) not null")
    private  String password;

    @Email(message = "write valid email")
    @NotEmpty(message = "email can't be empty")
    @Column(columnDefinition = " varbinary(20)not null unique ")
    private  String email;

    @NotEmpty(message = "role can't be empty")
    @Column(columnDefinition = "varbinary(20)not null check ( role='User' or 'Admin')")
    private String role;

    @NotNull(message = "age can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private Integer age;
}
