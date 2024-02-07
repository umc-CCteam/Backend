package backend.CC.web.dto;


import lombok.*;

public class ProfileResponseDTO {
//    @Data -> setter 애노테이션 포함
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProfileDTO {
        Long profileId;
        String nickname;
        String email;
        String comment;
        String photo; // 수정 필요 url
        boolean googleAuth;
        boolean instaAuth;

    }
}
