package com.example.testTask.Config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}123")
                .roles("VIEWER")
                .and()
                .withUser("admin")
                .password("{noop}456")
                .roles("ADMIN");

    }
*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/appSensor").hasRole("ADMIN")
                    .antMatchers("/sensorTable").hasAnyRole("VIEWER", "ADMIN")
                .and()
                    .formLogin()
                /*.loginPage("/login") - собственная форма*/ // (5)
                    .permitAll()
                .and()
                    .logout() // (6)
                    .permitAll()
                .and()
                    .httpBasic();
    }

}
