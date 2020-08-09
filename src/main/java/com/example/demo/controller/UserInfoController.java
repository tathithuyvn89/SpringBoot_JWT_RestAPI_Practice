package com.example.demo.controller;

import com.example.demo.exception.ValidationException;
import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
  public class UserInfoController {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @PostMapping("/user")
    public Boolean create(@RequestBody Map<String,String> body) {
        String usename = body.get("username");
        if (userInfoRepository.existsByUsername(usename)) {
            throw new ValidationException("User name already existed");
        }
        String password = body.get("password");
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        String fullname = body.get("fullname");
        userInfoRepository.save(new UserInfo(usename,encodedPassword,fullname));
        return true;
    }

}