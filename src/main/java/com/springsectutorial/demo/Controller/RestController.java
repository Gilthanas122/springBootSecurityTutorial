package com.springsectutorial.demo.Controller;

import com.springsectutorial.demo.Databases.UserRepository;
import com.springsectutorial.demo.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/public")
@org.springframework.web.bind.annotation.RestController
public class RestController {
  private UserRepository userRepository;

  @Autowired
  public RestController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("test1")
  public String test1(){
    return "test1";
  }

  @GetMapping("test2")
  public String test2(){
    return "test2";
  }

  @GetMapping("users")
  public List<User> listAllUsers(){
    return this.userRepository.findAll();
  }
}
