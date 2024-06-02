package com.Obalt.Spring_boot_crud.controller;


import com.Obalt.Spring_boot_crud.model.User;
import com.Obalt.Spring_boot_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List <User> getAllUsers (){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User>
    getUserById (@PathVariable(value="id")
                 Long userId){

    User user = userService.getUserById(userId)
            .orElseThrow(()-> new RuntimeException("User Not Found"));
    return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping ("/{id}")
    public ResponseEntity<User>
    updateUser(@PathVariable (value = "id")
               Long userId,
               @RequestBody User userDetails){
        User updatedUser = userService.updateUser(userId, userDetails);

        return
                ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    deleteUser(@PathVariable(value = "id")
               Long userId){
        userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }
}
