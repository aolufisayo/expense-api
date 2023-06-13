package com.phissy.expensetracker.service;

import com.phissy.expensetracker.entity.User;
import com.phissy.expensetracker.entity.UserModel;
import com.phissy.expensetracker.exception.UserNotFoundException;
import com.phissy.expensetracker.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserModel user) {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new UserNotFoundException("User already exists for email "+user.getEmail());
        }
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);

    }

    @Override
    public User updateUser(UserModel user) {
        Long userId = getLoggedInUser().getId();
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found for id "+userId));
        existingUser.setName(user.getName() != null? user.getName() : existingUser.getName());
        existingUser.setEmail(user.getEmail() != null? user.getEmail() : existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null? passwordEncoder.encode(user.getPassword()) : existingUser.getPassword());
        existingUser.setAge(user.getAge() != null? user.getAge() : existingUser.getAge());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser() {
        User user = readUser();
        userRepository.delete(user);
    }

    @Override
    public User readUser() {
        Long userId = getLoggedInUser().getId();
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found for id "+userId));
    }

    @Override
    public User getLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found for email "+email));
    }
}
