package com.example.testpir.repository;

import com.example.testpir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);
}
