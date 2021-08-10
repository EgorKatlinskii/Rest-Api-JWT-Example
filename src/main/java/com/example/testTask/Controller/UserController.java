package com.example.testTask.Controller;


import com.example.testTask.Model.AuthenticationRequestDto;
import com.example.testTask.Model.User;
import com.example.testTask.ServiceImpl.AuthServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class UserController {

    private final AuthServiceImpl authService;

    @Autowired
    public UserController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping("/registry")
    @ResponseBody
    public ResponseEntity<?> registry(@RequestBody User user){
        User newUser = authService.registry(user);
        return newUser!=null
               ? new ResponseEntity<>(HttpStatus.OK)
               : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<?,?>> login(@RequestBody AuthenticationRequestDto requestDto){
        Map<Object,Object> response= authService.login(requestDto.getLogin(),requestDto.getPassword());
        return !response.isEmpty()
                ? ResponseEntity.status(HttpStatus.OK).body(response)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
