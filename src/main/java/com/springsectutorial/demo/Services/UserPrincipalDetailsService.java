package com.springsectutorial.demo.Services;

import com.springsectutorial.demo.Databases.UserRepository;
import com.springsectutorial.demo.Models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserPrincipalDetailsService implements UserDetailsService {
  private UserRepository userRepository;

  public UserPrincipalDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = this.userRepository.findByUserName(username);
    UserPrincipal userPrincipal = new UserPrincipal(user);

    return userPrincipal;
  }
}
