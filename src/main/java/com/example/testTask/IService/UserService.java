package com.example.testTask.IService;

import com.example.testTask.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {



    User findByLogin(String userName);

    User findById(int id);





}
