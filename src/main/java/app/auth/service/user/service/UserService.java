package app.auth.service.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.auth.service.user.controller.RegisterRequest;
import app.auth.service.user.controller.UserResponse;
import app.auth.service.user.model.User;
import app.auth.service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    
    public UserResponse register(RegisterRequest request) {
	    var user = User.builder()
	        .userName(request.getUserName())
	        .password(passwordEncoder.encode(request.getPassword()))
	        .role(request.getRole())
	        .build();
	    var savedUser = repository.save(user);
	    var userResponse= UserResponse.builder().userName(savedUser.getUsername()).build();
        return userResponse;
   }
    
}
