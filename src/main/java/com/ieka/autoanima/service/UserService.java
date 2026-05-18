package com.ieka.autoanima.service;

import com.ieka.autoanima.controller.dto.request.UserRegisterRequest;
import com.ieka.autoanima.domain.User;
import com.ieka.autoanima.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

    public void register(@Valid UserRegisterRequest request) {
        if(this.userRepository.findByEmail(request.email()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(request.password());

        User newUser = new User();
        newUser.setRole(request.role());
        newUser.setEmail(request.email());
        newUser.setPassword(encryptedPassword);
        newUser.setName(request.name());

        userRepository.save(newUser);
    }
}
