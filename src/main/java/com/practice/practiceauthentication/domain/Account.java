package com.practice.practiceauthentication.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblAccount")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullName")
    private String fullname;

    @Column(name = "isRole")
    private String role;

}
