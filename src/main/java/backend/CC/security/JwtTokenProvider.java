package backend.CC.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenProvider {
    // -- 토큰생성 함수 -- //

    public String createToken(String email) {

        //Header 부분 설정
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        //payload 부분 설정
        Map<String, Object> payloads = new HashMap<>();
        payloads.put("email", email);
//        payloads.put("NickName","Erjuer");
//        payloads.put("Age","29");
//        payloads.put("TempAuth","Y");

        Long expiredTime = 1000 * 60L * 60L * 1L; // 토큰 유효 시간 (2시간)

        Date date = new Date(); // 토큰 만료 시간
        date.setTime(date.getTime() + expiredTime);

    Key key = Keys.hmacShaKeyFor("jla654ajsd=nalj32r087u0rwef41683@#$%31654316!#$%1#$%Tgsd64sd8f6f48724911c".getBytes(StandardCharsets.UTF_8));

        // 토큰 Builder
        String jwt = Jwts.builder()
                .setHeader(headers) // Headers 설정
                .setClaims(payloads) // Claims 설정
                .setSubject("Login") // 토큰 용도
                .setExpiration(date) // 토큰 만료 시간 설정
                .signWith(key, SignatureAlgorithm.HS256)
                .compact(); // 토큰 생성

        return jwt;

//        System.out.println(">> jwt : " + jwt);
    }

    // JWT에서 값 추출하는 함수
    // 프론트에서 JWT를 "X-ACCESS-TOKEN"이라는 이름의 Header에 담아 넘겨준 상황
    // -> 헤더에서 JWT 토큰 추출 가능
    public String getToken(HttpServletRequest request){
        //HttpServletRequest에서 "X-ACCESS-TOKEN" 헤더 값 추출
        String token = request.getHeader("X-ACCESS-TOKEN");

        // 추출한 토큰이 null이거나 빈 문자열인지 확인
        if (token == null || token.isEmpty()) {
            // 토큰이 없는 경우 예외처리 또는 적절한 처리를 해야한다.
            // 간단히 null을 반환하도록 처리
            return null;
        }
        // 헤더에서 추출한 토큰 반환
        return token;

    }

}

