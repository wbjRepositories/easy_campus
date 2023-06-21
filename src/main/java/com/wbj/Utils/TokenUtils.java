package com.wbj.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class TokenUtils {
    /**
     * 生成token
     * @param claims
     * @return
     */
    public static String createToken(Map<String,Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, "easy_campus")
                .setExpiration(new Date(System.currentTimeMillis() + 3 * 24 * 3600 * 1000))
                .compact();
    }


    /**
     * 解析token
     *
     * @param token
     */
    public static void parseToken(String token) {
        Jwts.parser().setSigningKey("easy_campus").parseClaimsJws(token).getBody();
    }
}
