package com.example.jwttest.jwtbase.filter;



import com.alibaba.fastjson.JSON;

import com.example.jwttest.jwtbase.common.ResultEnum;
import com.example.jwttest.jwtbase.common.ResultVO;
import com.example.jwttest.jwtbase.entity.JwtAuthUser;
import com.example.jwttest.jwtbase.model.LoginUser;
import com.example.jwttest.jwtbase.utils.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class JwtLoginAuthFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private ThreadLocal<Boolean> rememberMe = new ThreadLocal<>();
    public JwtLoginAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/auth/login");
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        LoginUser loginUser = new LoginUser();
        loginUser.setUsername(request.getParameter("username"));
        loginUser.setPassword(request.getParameter("password"));
        loginUser.setRememberMe(Boolean.parseBoolean(request.getParameter("rememberMe")));
        System.out.println(loginUser.toString());
        rememberMe.set(loginUser.getRememberMe());
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword(), new ArrayList<>())
        );
    }
        @Override
        protected void successfulAuthentication(HttpServletRequest request,
                HttpServletResponse response,
                FilterChain chain,
                Authentication authResult) throws IOException, ServletException {

            JwtAuthUser jwtUser = (JwtAuthUser) authResult.getPrincipal();
            System.out.println("JwtAuthUser:" + jwtUser.toString());
            boolean isRemember = rememberMe.get();
            List<String> roles = new ArrayList<>();
            Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
            for (GrantedAuthority authority : authorities){
                roles.add(authority.getAuthority());
            }
            System.out.println("roles:"+roles);
            String token = JwtTokenUtils.createToken(jwtUser.getUsername(), roles, isRemember);
            System.out.println("token:"+token);

            response.sendRedirect("/home?token="+token);
        }

        @Override
        protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGIN_FAILED,false)));
        }
}
