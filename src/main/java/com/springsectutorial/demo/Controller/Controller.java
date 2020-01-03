package com.springsectutorial.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

  @GetMapping("free/index")
  public String anybodyIndex(){
    return "freeindex";
  }

  @GetMapping("user/index")
  public String userIndex(){
    return "userindex";
  }

  @GetMapping("teacher/index")
  public String teacherIndex(){
    return "teacherindex";
  }

  @GetMapping("admin/index")
  public String adminIndex(){
    return "adminindex";
  }
}
