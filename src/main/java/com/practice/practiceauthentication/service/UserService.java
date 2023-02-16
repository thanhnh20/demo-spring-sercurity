package com.practice.practiceauthentication.service;

import com.practice.practiceauthentication.domain.User;
import java.util.List;


public interface UserService {

    List<User> getUsers();

    User getUserByID(Long userID);

    void createUser(User userCreate);
}
