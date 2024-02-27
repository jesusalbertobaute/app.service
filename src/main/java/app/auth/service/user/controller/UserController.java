package app.auth.service.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.auth.service.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService service;  

  @PostMapping("/register")
  public ResponseEntity<UserResponse> register(
      @RequestBody RegisterRequest  request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
    
}
