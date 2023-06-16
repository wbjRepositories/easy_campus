package com.wbj.Utils;

import io.jsonwebtoken.Jwts;

public class ParseUtils {
    public static void parseToken(String token){
        Jwts.parser().setSigningKey("easy_campus").parseClaimsJwt(token).getBody();
    }
}
