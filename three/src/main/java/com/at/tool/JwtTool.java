package com.at.tool;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.lang.Assert;
import org.apache.logging.log4j.ThreadContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTool {

    public static void main(String[] args) {
        Map<String, Object> claims = new HashMap();
        claims.put("sub", "wze");
        claims.put("created", new Date());
        claims.put("app_id", "daep");
        DefaultJwtBuilder defaultJwtBuilder = new DefaultJwtBuilder();
        JwtBuilder jwtBuilder = defaultJwtBuilder
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "ZGF0YS1tYW5hZ2VtZW50LWFkbWluLXNlY3JldA==");
//        ZGF0YS1tYW5hZ2VtZW50LWFkbWluLXNlY3JldA==
//        eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3emUiLCJjcmVhdGVkIjoxNjkwMDA3NDk1NTc2LCJhcHBfaWQiOiJkYWVwIn0.sYzR87ynFcEO1X_wm2_dD5vgiJvQrzHHcIixMMyLAPN7ZNg2fvUraBZGNWHVSGxEg1YoMKmbPSo7u144Wq0j3w

        // 传入base64
//        eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3emUiLCJjcmVhdGVkIjoxNjkwMDA3OTMzNDAyLCJhcHBfaWQiOiJkYWVwIn0.eyR_OD62sgsyjsZx7PyAjt7EjrydlPaLBrUwLBMLjTwh6k0p3doxMbr9_ZNIoQ97gbiqy0b5SMbAcq7wysiO0A
        System.out.println(jwtBuilder.compact());
    }
}
