package backend.CC.web.dto;

import backend.CC.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PrResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class creatorPRDTO {
        String nickname;
        String comment;

        boolean googleAuth;

        boolean instaAuth;
        Category category;
    }
}
