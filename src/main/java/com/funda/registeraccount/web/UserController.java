package com.funda.registeraccount.web;

import com.funda.registeraccount.dto.UserDTO;
import com.funda.registeraccount.serviceImpl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("create")
    public UserDTO createUserAccount(@RequestBody UserDTO userDTO){
        return new ResponseEntity<UserDTO>(userService.createAccount(userDTO), HttpStatus.CREATED).getBody();
    }
}
