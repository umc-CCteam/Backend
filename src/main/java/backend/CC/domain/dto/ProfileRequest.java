package backend.CC.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

public class ProfileRequest {
    @Data
    public static class RegisterDto {
        @NotEmpty
        private String name;
        private String photo;
        @NotEmpty
        private String comment;
        private String platform;
        private long fan;
    }

//    static class UpdateDto {
//
//    }
}
