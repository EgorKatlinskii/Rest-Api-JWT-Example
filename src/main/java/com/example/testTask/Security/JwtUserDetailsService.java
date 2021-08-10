package com.example.testTask.Security;

import com.example.testTask.IService.UserService;
import com.example.testTask.Model.User;
import com.example.testTask.Security.JWT.JWTUser;
import com.example.testTask.Security.JWT.JWTUserFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }



    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findByLogin(login);

        if(user == null ){
            throw new UsernameNotFoundException("User not found: "+ login);
        }

        JWTUser jwtUser= JWTUserFactory.createJWTUser(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", login);

        return jwtUser;
    }
}
