package com.example.jwttest.jwtbase.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class JwtTokenUtils {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    private static final String PRIMARY_KEY = "jwtsecreTdemo2561125FOFAN45611833Wertolet33099";

    private static final String ISS = "Iosif.St";

    private static final String ROLE_CLAIMS = "role";

    private static final long EXPIRATION = 3600L;

    private static final long EXPIRATION_REMEMBER = 604800L;

    public static String createToken(String username, List<String> roles, boolean isRememberMe) {
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        HashMap<String, Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, roles);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, PRIMARY_KEY)
                .setClaims(map)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    public static String getUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    public static List<String> getUserRole(String token) {
        return (List<String>) getTokenBody(token).get(ROLE_CLAIMS);
    }

    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(PRIMARY_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
