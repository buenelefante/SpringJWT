package com.example.jwttest.jwtbase.handler;

import com.alibaba.fastjson.JSON;
import com.example.jwttest.jwtbase.common.ResultEnum;
import com.example.jwttest.jwtbase.common.ResultVO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnAuthorizedEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_NEED_AUTHORITIES,false)));
    }
}
