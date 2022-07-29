package com.example.jwttest.jwtbase.service.Impl;

import com.example.jwttest.jwtbase.entity.FXUser;
import com.example.jwttest.jwtbase.entity.JwtAuthUser;
import com.example.jwttest.jwtbase.repository.FXUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private FXUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        FXUser user = userRepository.findByName(userName);
        if(user==null){

            throw new UsernameNotFoundException("not user!");
        }
        user.setRoles(userRepository.getRolesByUserName(userName));
        System.out.println("UserDetailsServiceImpl==>loadUserByUsername:"+user.toString());
        return new JwtAuthUser(user);
    }
}
