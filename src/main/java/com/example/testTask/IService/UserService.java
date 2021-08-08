package com.example.testTask.IService;

import com.example.testTask.Model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User registry(User user);

    User login(User user);

    User findByLogin(String userName);

    User findById(int id);





}
