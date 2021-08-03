package com.example.testTask.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/logins")
    public String user(){
        return "login";
    }

    @GetMapping("/sensorTable")
    public String sensorTable(){
        return "sensorTable";
    }

    @GetMapping("/appSensor")
    public String admin(){
        return "admin";
    }
}
