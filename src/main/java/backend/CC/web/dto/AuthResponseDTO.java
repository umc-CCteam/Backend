package backend.CC.web.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//DTO란,  "Data Transfer Object"의 약자로, 데이터 전송 객체
public class AuthResponseDTO {
    // === 로그인 API ==== //
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginResultDTO{
        String access_token;

    }

    // ===================== //

    // ==== 회원가입 API ==== //
    // Response했을때 받을 객체 형태
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        String message; // 회원가입 성공 메세지
        LocalDateTime createdAt;
    }
    // ===================== //
}
