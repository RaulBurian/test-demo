package com.example.demo.controller;

import com.example.demo.domain.AppUser;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    AppUser getTest(@RequestBody UserDto userDto){
        var user = AppUser
                .builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();

        var appUser=userRepo.save(user);

        return appUser;
    }
}
