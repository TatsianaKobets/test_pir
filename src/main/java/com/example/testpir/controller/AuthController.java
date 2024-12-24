package com.example.testpir.controller;

import com.example.testpir.entity.AuthenticationRequest;
import com.example.testpir.entity.User;
import com.example.testpir.repository.UserRepository;
import com.example.testpir.service.CustomUserDetailsService;
import com.example.testpir.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private CustomUserDetailsService userDetailsService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtUtil jwtUtil;
  @PostMapping("/register")
  public String registerUser(@RequestBody User user) {
    // Encode the user's password
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    // Save the user to the database
    userRepository.save(user);
    return "User registered successfully";
  }

  @PostMapping("/login")
  public String loginUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
    );

    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails);

    return jwt;
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello, World!";
  }
}
