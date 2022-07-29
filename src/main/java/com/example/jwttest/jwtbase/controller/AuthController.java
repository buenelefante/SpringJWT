package com.example.jwttest.jwtbase.controller;

import com.example.jwttest.jwtbase.entity.FXUser;
import com.example.jwttest.jwtbase.service.IFXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IFXUserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        String userName=registerUser.get("username");
        String password=registerUser.get("password");
        FXUser user=userService.insert(userName,password);
        if(user==null){
            return "no create new user";
        }
        return user.toString();
    }
}
