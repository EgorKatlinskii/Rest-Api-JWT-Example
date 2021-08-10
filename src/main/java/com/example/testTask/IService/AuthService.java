package com.example.testTask.IService;

import com.example.testTask.Model.User;

import java.util.Map;

public interface AuthService {

    User registry(User user);

    Map<Object,Object> login(String login, String password );
}
