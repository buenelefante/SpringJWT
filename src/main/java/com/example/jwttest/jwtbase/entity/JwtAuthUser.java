package com.example.jwttest.jwtbase.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class JwtAuthUser implements UserDetails {
    private Integer id;
    private String userName;
    private String password;
    private List<String> roles;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtAuthUser(FXUser user){
        this.id=user.getId();
        this.userName=user.getName();
        this.password=user.getPassword();
        this.roles=user.getRoles();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        if (roles!=null) {
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
        }
        System.out.println("authorities:"+authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "JwtAuthUser{" +
                "id=" + id +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + roles +
                '}';
    }
}
