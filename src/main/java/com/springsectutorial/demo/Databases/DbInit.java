package com.springsectutorial.demo.Databases;

import com.springsectutorial.demo.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
  private UserRepository userRepository;

  @Autowired
  public DbInit(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    User pityu = new User("pityu", "nina", "USER", " ");
    User marta = new User("marta", "marta", "TEACHER", "ACCESS_TEST1");
    User admin = new User("admin", "admin", "ADMIN", "ACCESS_TEST1,ACCESS_TEST2");

    List<User> users = Arrays.asList(pityu, marta, admin);
    this.userRepository.saveAll(users);
  }
}
