package com.practice.practiceauthentication.service.implement;

import com.practice.practiceauthentication.domain.User;
import com.practice.practiceauthentication.repository.UserRepository;
import com.practice.practiceauthentication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class UserServiceImplement implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        log.info("get all user ");
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(Long userID){
        log.info("get user by id: " + userID);
        return userRepository.findById(userID).orElseThrow(() ->
                new RuntimeException("Can not find user with id = " + userID));
    }

    @Override
    public void createUser(User userCreate) {
        log.info("create new user" );
        userRepository.save(userCreate);
    }
}
