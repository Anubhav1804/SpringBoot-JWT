package com.springboot.jwt.Spring_Boot_JWT_MongoDB.service;

import com.springboot.jwt.Spring_Boot_JWT_MongoDB.model.User;
import com.springboot.jwt.Spring_Boot_JWT_MongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private TokenService tokenService;

    public UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User getUser(int id) {

        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(optionalUser::get);

       // return userRepository.findOne(id).orElse(null);
    }

    public String saveUser(User user) {
        User savedUser = userRepository.save(user);
        return tokenService.createToken(savedUser.getId());

//        userRepository.save(user);
//        return "saved user";
    }
}
