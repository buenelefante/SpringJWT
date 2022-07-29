package com.example.jwttest.jwtbase.service.Impl;

import com.example.jwttest.jwtbase.repository.FXUserRepository;
import com.example.jwttest.jwtbase.repository.FXUserRoleRepository;
import com.example.jwttest.jwtbase.service.IFXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.jwttest.jwtbase.entity.FXUser;

import java.util.ArrayList;
import java.util.List;

@Service
public class FXUserServiceImpl implements IFXUserService {
    @Autowired
    FXUserRepository userRepository;

    @Autowired
    private FXUserRoleRepository userRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public FXUser findByUserName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public List<String> getRolesByUserName(String userName) {
        return userRepository.getRolesByUserName(userName);
    }

    @Override
    public FXUser insert(String userName, String password) {
        FXUser user = new FXUser();
        user.setName(userName);

        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        user.setRoles(roles);

        FXUser result = userRepository.save(user);
        if (result.getName()!=null){

            userRoleRepository.save(result.getName(),"ROLE_USER");
            result.setRoles(roles);
            return result;
        }
        return null;
    }

}
