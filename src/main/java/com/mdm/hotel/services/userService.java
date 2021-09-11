package com.mdm.hotel.services;

import com.mdm.hotel.controllers.userController;
import com.mdm.hotel.entities.user;
import com.mdm.hotel.repos.userRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;

@Service("userService")
public class userService {

    @Autowired
    private userRepository repository;

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void register (user user) throws Exception {
        
        if (checkIfUserExist(user)) { // check if user exist
           throw new UsernameNotFoundException("User Already exists for this Number"); 
        } else {
            if (!userController.isValid(user.getEmail())) {
                throw new Exception("invalid email");
            }
            String encodePassword = bCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(encodePassword);
            repository.save(user);
        }
        
    }

    private boolean checkIfUserExist(user user) {
        user tempUser;
        if (userController.isValid(user.getEmail())) {
            tempUser = repository.findByEmail(user.getEmail());
        } else {
            Long phoneNo = user.getPhoneno();
            tempUser = repository.findByPhoneno(phoneNo);
        }

        if (tempUser != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPassword(String enteredPassword, String password) {
       return bCryptPasswordEncoder().matches(enteredPassword, password);
    }

   }
