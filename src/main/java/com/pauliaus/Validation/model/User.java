package com.pauliaus.Validation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //user name should not be null or empty
    //user name should have atleast 2characters
    @Column(name = "name", nullable = false)
    @NotEmpty
    @Size(min = 2,message = "user name should have atleast 2characters")
    private String name;

    //email should be a valid email format[validation.packet]
    //email should not be null or empty
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 8,message = "Must have atleast 8 characters")
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
