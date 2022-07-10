package com.at.base;

import com.alibaba.fastjson.JSON;
import com.at.base.pclass.User;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class JwtToken {

    private static final String signKey = "123456";

    public static String generalToken() {
        User user=new User("张三","123", 18);
        String userJson = JSON.toJSONString(user);//序列化user
        JwtBuilder jwtBuilder = Jwts.builder(); //获得JWT构造器
//        Map<String,Object> map=new Hashtable<>();
//        map.put("kay",userJson);
//        String token = jwtBuilder.setSubject("hello") //设置用户数据
//                .setIssuedAt(new Date()) //设置jwt生成时间  这些是default的claim
//                .setId("1") //设置id为token id
//                .setClaims(map) //通过map传值
//                .setExpiration(new Date(System.currentTimeMillis() + 5000)) //设置token有效期
//                .signWith(SignatureAlgorithm.HS256, signKey) //设置token加密方式和密码
//                .compact(); //生成token字符串

        Claims claims = Jwts.claims();
        claims.put("user", userJson);
        claims.put("kk", "123");
        String token = jwtBuilder.setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("ceshi")
                .setIssuer("wuzeen")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS256, signKey)
                .compact();
        return token;
    }

    public static void parse(String s) {
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJws = parser.setSigningKey(signKey).parseClaimsJws(s);
        System.out.println(claimsJws);

    }
    public static void main(String[] args) {
        String s = JwtToken.generalToken();
        System.out.println(s);
        JwtToken.parse(s);
    }
}
