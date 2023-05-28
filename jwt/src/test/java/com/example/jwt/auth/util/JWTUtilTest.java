package com.example.jwt.auth.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class JWTUtilTest {

    @Autowired
    private JWTUtil jwtUtil;

    @Test
    public void testGenerate() {
        Map<String, Object> claimMap = Map.of("mid", "ABCDE");
        String jwtStr = jwtUtil.generateToken(claimMap, 1);
        log.info(jwtStr);
    }

    @Test
    // 유효기간이 지난 토큰
    public void testValidate() {
        String jwtStr = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzkxMjIxNjYsIm1pZCI6IkFCQ0RFIiwiaWF0IjoxNjc5MTIyMTA2fQ.XHe_KB_NLo-uEJh3gRQWfqDy8bRSg86KytT6vVgMB1o";
        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);
        log.info(claim);
    }

    @Test
    public void testAll() {
        String jwtStr = jwtUtil.generateToken(Map.of("mid", "AAAA", "email", "aaa@bbb.com"), 1);

        log.info(jwtStr);
        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);
        log.info("MID: " + claim.get("mid"));
        log.info("EMAIL: " + claim.get("email"));

    }
    
}