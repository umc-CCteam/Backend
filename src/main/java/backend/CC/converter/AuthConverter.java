package backend.CC.converter;

import backend.CC.domain.Member;
import backend.CC.web.dto.AuthRequestDTO;
import backend.CC.web.dto.AuthResponseDTO;

import java.time.LocalDateTime;

public class AuthConverter {

//    컨버트 이름 : to<만들려는 대상>
    // ===== 로그인 API (응답 데이터값 ) ========= //
    public static AuthResponseDTO.LoginResultDTO toLoginResultDTO(){
        return AuthResponseDTO.LoginResultDTO.builder()
                .access_token("this is access_token!")
                .build();
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
                .email(request.getEmail())
                .passWord(request.getPassword())
                .googleAuth(!request.isGoogleAuth())
                .instaAuth(!request.isInstaAuth())
                .build();
    }

    // ------------------------ //

}
