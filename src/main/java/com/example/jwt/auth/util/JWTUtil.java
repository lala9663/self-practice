package com.example.jwt.auth.util;

import io.jsonwebtoken.JwtException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Log4j2
public class JWTUtil {

    @Value("${jwt.secretKey}")
    private String key;

    public String generateToken(Map<String, Object> valueMap, int days) {
        log.info("generateKey..."+key);

        // 헤더 부분
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        // payload 부분설정
        Map<String, Object> payloads = new HashMap<>();
        payloads.putAll(valueMap);

        // 테스트 시에는  짧은 유효기간
        int time = (60 * 24) * days; // 테스트는 분단위로 나중에 60*24 (일)단위 변경
                                // 1 * days

        // 테스트시에는 짧은 유효기간이 유용하기 때문에 plusMinutes 로 했지만 개발이 완료되면 plusDays 로 바꾸는게 좋다.
        return Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
                .setExpiration(Date.from(ZonedDateTime.now().plusDays(time)
                        .toInstant()))
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                        .compact();
    }
    public Map<String, Object> validateToken(String token)throws JwtException {
        Map<String, Object> claim = null;

        claim = Jwts.parser()
                .setSigningKey(key.getBytes()) // Set Key
                .parseClaimsJws(token)  // 파싱 및 검증, 실패 시 에러
                .getBody();
        return claim;
    }



}
