package com.springsectutorial.demo.Databases;

import com.springsectutorial.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUserName(String userName);
}
