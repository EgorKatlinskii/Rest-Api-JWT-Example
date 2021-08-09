package com.example.testTask.ServiceImpl;

import com.example.testTask.Enums.UserRole;
import com.example.testTask.IService.UserService;
import com.example.testTask.Model.AuthenticationRequestDto;
import com.example.testTask.Model.User;
import com.example.testTask.Repository.UserRepository;
import com.example.testTask.Security.JWT.JWTTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByLogin(String login) {
        User userResult = userRepository.findByLogin(login);
        if(userResult != null){
            log.info("In findByLogin - user: {} found by username: {}", userResult, login);
            return userResult;
        }
        return null;
    }

    @Override
    public User findById(int id) {
        User userResult = userRepository.findById(id).orElse(null);
        if(userResult== null){
            log.warn("In findById - no user found by id: {}", id);
            return null;
        }
        log.info("In findById - user: {} found by id: {}", userResult,id);
        return userResult;
    }
}
