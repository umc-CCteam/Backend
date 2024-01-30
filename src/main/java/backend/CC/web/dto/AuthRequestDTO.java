package backend.CC.web.dto;
import lombok.Getter;

public class AuthRequestDTO {
    // ==== 로그인 API ==== //
    @Getter
    public static class LoginDto{
        String email; ///아이디
        String password; //비밀번호
    }


    // =================== //

//    ==== 회원가입 API ==== //
//        String userId; // 사용자 id
    @Getter
    public static class JoinDto{
        String email;
        String password;
        boolean googleAuth; // 구글 인증 여부
        boolean instaAuth; // 인스타 인증 여부


//        String access_token; //access 토큰은 제외
    }

    // ==================== //

}
