package com.example.jwttest.jwtbase.controller;

import com.example.jwttest.jwtbase.entity.FXUser;
import com.example.jwttest.jwtbase.service.IFXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class FXUserController {
    @Autowired
    IFXUserService userService;

    @GetMapping("/{userName}")
    public FXUser getUser(@PathVariable String userName){
        FXUser user = userService.findByUserName(userName);
        user.setRoles(userService.getRolesByUserName(userName));
        return user;
    }
}
