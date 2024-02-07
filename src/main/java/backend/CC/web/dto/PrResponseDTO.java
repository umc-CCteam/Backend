package backend.CC.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class PrResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class creatorPRDTO {
        Long creatorPrId;
        String nickname;
        String comment;
        String category;
        String email;
        boolean googleAuth;
        boolean instaAuth;
        String photo;
        String content;
        List<String> url;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class creatorPRListDTO{
        Long memberId;
        String nickname;
        String comment;
        String category;
        boolean googleAuth;
        boolean instaAuth;
        String photo;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class creatorPrFormDTO {
        String nickname;
        String comment;
        String email;
        boolean googleAuth;
        boolean instaAuth;
    }
}
