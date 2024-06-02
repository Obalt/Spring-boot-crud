package com.Obalt.Spring_boot_crud.service;

import com.Obalt.Spring_boot_crud.model.User;
import com.Obalt.Spring_boot_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public Optional<User>
    getUserById(Long id){

    return
            userRepository.findById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);

    }

    public User updateUser(Long id, User userDetails){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
