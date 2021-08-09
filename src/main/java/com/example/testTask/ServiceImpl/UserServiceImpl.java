package com.example.testTask.ServiceImpl;

import com.example.testTask.Enums.UserRole;
import com.example.testTask.IService.UserService;
import com.example.testTask.Model.User;
import com.example.testTask.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;

   private final BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public User registry(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.USER);
        User registeredUser = userRepository.save(user);
        log.info("In register - user: {} successfully registered", registeredUser);
        return registeredUser;

    }

    /*!!!!!*/
    @Override
    public User login(User user) {
        return null;
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
