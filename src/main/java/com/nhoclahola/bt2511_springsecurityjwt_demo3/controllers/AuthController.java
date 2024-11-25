package com.nhoclahola.bt2511_springsecurityjwt_demo3.controllers;

import com.nhoclahola.bt2511_springsecurityjwt_demo3.entities.Role;
import com.nhoclahola.bt2511_springsecurityjwt_demo3.entities.User;
import com.nhoclahola.bt2511_springsecurityjwt_demo3.models.LoginDto;
import com.nhoclahola.bt2511_springsecurityjwt_demo3.models.SignUpDto;
import com.nhoclahola.bt2511_springsecurityjwt_demo3.repositories.RoleRepository;
import com.nhoclahola.bt2511_springsecurityjwt_demo3.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController
{
    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully", HttpStatus.OK);
    }

    @PostMapping("signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto)
    {
        if (userRepository.existsByUsername(signUpDto.getUsername()))
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        if (userRepository.existsByEmail(signUpDto.getUsername()))
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);

        User user = User.builder()
                .name(signUpDto.getName())
                .username(signUpDto.getUsername())
                .email(signUpDto.getEmail())
                .enabled(signUpDto.isEnabled())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .build();

        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singleton(roles));
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
