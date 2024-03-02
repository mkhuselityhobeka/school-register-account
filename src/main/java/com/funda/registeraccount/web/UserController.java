package com.funda.registeraccount.web;

import com.funda.registeraccount.dto.UserDTO;
import com.funda.registeraccount.entity.User;
import com.funda.registeraccount.serviceImpl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("user/create")
    public UserDTO createUserAccount(@RequestBody UserDTO userDTO){
        return new ResponseEntity<UserDTO>(userService.createAccount(userDTO), HttpStatus.CREATED).getBody();
    }
    @GetMapping("/user/{username}")
    public UserDTO getUserBbyUsername(@PathVariable String username){
        return new ResponseEntity<UserDTO>(userService.findUserByUsername(username), HttpStatus.OK).getBody();
    }

    @PutMapping("user/update")
    public UserDTO updateUserDetails(@RequestBody  UserDTO userDTO){
        return new ResponseEntity<UserDTO>(userService.updateUser(userDTO),HttpStatus.OK).getBody();
    }

    @DeleteMapping("user/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.removeUser(id);
    }

    @PatchMapping("user/update/{status}/{id}")
    public void userStatusUpdate(@PathVariable String status, @PathVariable Long id){
        userService.updateStatus(status,id);
    }
    @GetMapping("user/getUsers")
    public Page<User> findAllUsers(Pageable pageable){
        return new ResponseEntity<Page>(userService.returnAllUsers(pageable),HttpStatus.OK).getBody();
    }
}
