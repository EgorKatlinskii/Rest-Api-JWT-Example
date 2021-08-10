package com.example.testTask.Security.JWT;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JWTUser implements UserDetails {

    private final Integer userId;

    private final String login;

    private final String password;

    private final Collection<? extends GrantedAuthority>GrantedAuthority;

    public JWTUser(Integer userId, String login,
                   String password,
                   Collection<? extends GrantedAuthority> grantedAuthority) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        GrantedAuthority = grantedAuthority;
    }


    @JsonIgnore
    public Integer getId(){
        return userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return GrantedAuthority;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
