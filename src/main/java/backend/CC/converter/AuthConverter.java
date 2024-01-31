package backend.CC.converter;

import backend.CC.domain.Member;
import backend.CC.web.dto.AuthRequestDTO;
import backend.CC.web.dto.AuthResponseDTO;
import backend.CC.security.JwtTokenProvider;
import java.time.LocalDateTime;

public class AuthConverter {
    private static final JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(); // TokenProvider 객체 생성

//    컨버트 이름 : to<만들려는 대상>
    // ===== 로그인 API (응답 데이터값 ) ========= //
//userEmail : 사용자가 입력한 이메일, loginSuccess : 로그인 성공 여부
    public static AuthResponseDTO.LoginResultDTO toLoginResultDTO(String userEmail, boolean loginSuccess){
        if (loginSuccess){
            String accessToken = jwtTokenProvider.createToken(userEmail); // 사용자가 입력한 이메일로 토큰 생성
            return AuthResponseDTO.LoginResultDTO.builder()
                    .access_token(accessToken)
                    .build();
        }else{
            return null; // 로그인 실패시 , null 반환
        }

    }
    // ========================= //


    // ==== 회원가입 응답 API ==== //
    public static AuthResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return AuthResponseDTO.JoinResultDTO.builder()
                .message("회원가입 성공"+member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // ----( 멤버 추가 ) ---- //
    public static Member toAuth(AuthRequestDTO.JoinDto request){
        return Member.builder()
                .email(request.getEmail())  // 이메일
                .passWord(request.getPassword()) // 비밀번호
                .googleAuth(request.isGoogleAuth()) // 구글 인증여부
                .instaAuth(request.isInstaAuth()) // 인스타 인증여부
                .build();
    }

    // ------------------------ //

}
