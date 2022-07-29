package com.example.jwttest.jwtbase.handler;

import com.example.jwttest.jwtbase.entity.JwtAuthUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse, Authentication authentication)
            throws IOException, ServletException {
        JwtAuthUser userDetails = (JwtAuthUser) authentication.getPrincipal();
    }
}
