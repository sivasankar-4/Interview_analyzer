package com.sivacodes.interview_analyzer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivacodes.interview_analyzer.model.User;
import com.sivacodes.interview_analyzer.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RequiredArgsConstructor
@RestController
@RequestMapping("/Users")

public class UserController {
    


    private final UserService userService;

     @GetMapping
     public List<User> getAllUsers() {
         return userService.getAllUsers();
     }
     @GetMapping("/getUser/{id}")
     public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
     }
    @PostMapping("/createUser")
    public User createUser(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }
    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/deleteUser/{id}")
      public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
      }
        @GetMapping("/getNoUser/{id}")
      public User getNoUser(@PathVariable Long id) {
        return userService.getNouser(id);
      }

}
