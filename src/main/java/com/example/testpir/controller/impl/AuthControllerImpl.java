package com.example.testpir.controller.impl;

import com.example.testpir.controller.AuthController;
import com.example.testpir.entity.AuthenticationRequest;
import com.example.testpir.entity.User;
import com.example.testpir.repository.UserRepository;
import com.example.testpir.service.impl.CustomUserDetailsServiceImpl;
import com.example.testpir.util.JwtUtil;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthControllerImpl implements AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private CustomUserDetailsServiceImpl userDetailsService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtUtil jwtUtil;

  @Hidden
  @Override
  @PostMapping("/register")
  public String registerUser(@RequestBody User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
    return "User registered successfully";
  }

  @Hidden
  @Override
  @PostMapping("/login")
  public String loginUser(@RequestBody AuthenticationRequest authenticationRequest)
      throws Exception {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
            authenticationRequest.getPassword())
    );

    final UserDetails userDetails = userDetailsService.loadUserByUsername(
        authenticationRequest.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails);

    return jwt;
  }

  @Override
  @GetMapping("/hello")
  public String hello() {
    return "Hello, World!";
  }
}