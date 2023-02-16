package com.practice.practiceauthentication.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblUser")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(name = "address")
    private String address;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "phoneNumber")
    private String phone;

    @Column(name = "username")
    private String userName;

    @Column(name = "gender")
    private boolean gender;
}
