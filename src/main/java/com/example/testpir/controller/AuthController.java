package com.example.testpir.controller;

import com.example.testpir.entity.AuthenticationRequest;
import com.example.testpir.entity.User;

public interface AuthController {

  String registerUser(User user);

  String loginUser(AuthenticationRequest authenticationRequest) throws Exception;

  String hello();
}
