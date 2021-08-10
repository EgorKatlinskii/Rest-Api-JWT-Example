package com.example.testTask.Security.JWT;

import com.example.testTask.Enums.UserRole;
import com.example.testTask.Model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public final  class JWTUserFactory {

    public JWTUserFactory() {
    }

    public static JWTUser createJWTUser(User user){
        return new JWTUser(user.getUserId(),
                user.getLogin(),
                user.getPassword(),
                Collections.singleton(getGrantedAuthority(user.getRole())));
    }

    public static SimpleGrantedAuthority getGrantedAuthority(UserRole role){
        return new SimpleGrantedAuthority(role.name());

    }
}
