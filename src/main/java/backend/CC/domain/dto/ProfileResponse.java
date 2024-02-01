package backend.CC.domain.dto;

import lombok.Data;

public class ProfileResponse {
    @Data
    public static class Dto {
        private String name;

        private String photo;

        private String comment;

        private String platform;

        private long fan;
    }
}
