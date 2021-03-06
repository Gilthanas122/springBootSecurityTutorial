package com.springsectutorial.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .inMemoryAuthentication()
            .withUser("admin")
            .password(passwordEncoder().encode("nyeff"))
            .roles("ADMIN").authorities("ACCESS_TEST1", "ACCESS_TEST2", "ROLE_ADMIN")
            .and()
            .withUser("pityu")
            .password(passwordEncoder().encode("nyeffento"))
            .roles("USER")
            .and()
            .withUser("teacher")
            .password(passwordEncoder().encode("teacheritis"))
            .roles("TEACHER").authorities("ACCESS_TEST1", "ROLE_TEACHER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/free/**").permitAll()
            .antMatchers("/user/**").authenticated()
            .antMatchers("/teacher/**").hasAnyRole("ADMIN", "TEACHER")
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
            .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
            .antMatchers("/api/public/users").hasRole("ADMIN")
            .and()
            .httpBasic();
  }

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
