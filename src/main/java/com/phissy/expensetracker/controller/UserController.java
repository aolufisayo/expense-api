package com.phissy.expensetracker.controller;

import com.phissy.expensetracker.entity.User;
import com.phissy.expensetracker.entity.UserModel;
import com.phissy.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/profile")
    public ResponseEntity<User> readUser(){
        return new ResponseEntity<User>(userService.readUser(), HttpStatus.OK);
    }

    @DeleteMapping("/user/deactivate")
    public ResponseEntity<HttpStatus> deactivateUser(){
        userService.deleteUser();
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/user/profile")
    public ResponseEntity<User> updateUser(@RequestBody UserModel userModel){
        return new ResponseEntity<User>(userService.updateUser(userModel), HttpStatus.OK);
    }
}
