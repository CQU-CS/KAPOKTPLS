package com.cqu.kapok.kapoktpls.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
    // 签名随意写，但复杂性越高，安全性越高
    public static final String SING = "114514";

    /**
     * 生成token
     */
    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 30);
        // 创建JWT builder
        JWTCreator.Builder builder = JWT.create();

        // payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        // 指定令牌的过期时间
        String token = builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(SING));// 签名
        // System.out.println(token);
        return token;
    }

    /**
     * 验证token合法性
     */
    public static DecodedJWT verifier(String token) {
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }

    /**
     * 获取token信息
     */
    public static DecodedJWT getTokenInfo(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
        return verify;
    }

    // date转化字符串
    public static String dateToString(Date date) {
        String dateStr = "";
        // format的格式可以任意
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            dateStr = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return dateStr;
        }
    }


    public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SING);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            String sName = jwt.getClaim("name").asString();
            String sPassword = jwt.getClaim("pwd").asString();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}