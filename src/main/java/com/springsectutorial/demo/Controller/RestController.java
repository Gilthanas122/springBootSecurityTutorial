package com.springsectutorial.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/public")
@org.springframework.web.bind.annotation.RestController
public class RestController {

  @GetMapping("test1")
  public String test1(){
    return "test1";
  }

  @GetMapping("test2")
  public String test2(){
    return "test2";
  }
}
