package com.springsectutorial.demo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false)
  private String userName;

  @Column(nullable = false)
  private String password;

  private int active;
  private String roles = " ";
  private String permissions = " ";

  public User(String userName, String password, String roles, String permissions) {
  this.userName = userName;
  this.password = password;
  this.roles = roles;
  this.permissions = permissions;
  this.active = 0;
  }

  protected User(){};

  public long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public int getActive() {
    return active;
  }

  public String getRoles() {
    return roles;
  }

  public List<String> getRoleList(){
    if (this.roles.length() > 0){
      return Arrays.asList(this.roles.split(","));
    }
    return new ArrayList<>();
  }

  public List<String> getPermissionList(){
    if (this.permissions.length() > 0){
      return Arrays.asList(this.permissions.split(","));
    }
    return new ArrayList<>();
  }
}
