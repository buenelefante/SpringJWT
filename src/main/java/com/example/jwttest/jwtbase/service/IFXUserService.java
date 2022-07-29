package com.example.jwttest.jwtbase.service;

import com.example.jwttest.jwtbase.entity.FXUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface IFXUserService {
    FXUser findByUserName(String username);
    List<String> getRolesByUserName(String userName);
    FXUser insert(String userName,String password);

}
