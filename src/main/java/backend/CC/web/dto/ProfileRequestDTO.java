package backend.CC.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

public class ProfileRequestDTO {

    @Getter
    public static class createProfileDTO {

        @NotEmpty
        String nickname;
        @NotBlank
        String email;
        @NotBlank
        String comment;
        @NotEmpty
        String photo;
        Boolean googleAuth;
        Boolean instaAuth;


    }
}
