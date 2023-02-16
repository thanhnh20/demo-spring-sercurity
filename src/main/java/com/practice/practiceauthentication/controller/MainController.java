package com.practice.practiceauthentication.controller;

import com.practice.practiceauthentication.domain.User;
import com.practice.practiceauthentication.dto.ResponseDTO;;
import com.practice.practiceauthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/api/v1/users", method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> getUser(){
        List<User> listUser = userService.getUsers();
        ResponseDTO response = ResponseDTO.success();
        response.setData(listUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(path = "/api/v1/user/{userID}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> getUserByID(@PathVariable Long userID){
        try {
            User user = userService.getUserByID(userID);
            ResponseDTO response = ResponseDTO.success();
            response.setData(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (RuntimeException e){
            ResponseDTO response = ResponseDTO.badRequest();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

//    @RequestMapping(path = "api/v1/createUser", method = RequestMethod.POST)
    @PostMapping(path = "/api/v1/user/create")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody User userCreate){
        userService.createUser(userCreate);
        ResponseDTO responseDTO = ResponseDTO.success();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
