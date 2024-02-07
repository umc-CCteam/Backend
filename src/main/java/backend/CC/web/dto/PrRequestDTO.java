package backend.CC.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.util.List;

public class PrRequestDTO {

    @Getter
    public static class createCreatorPrDTO{
        @NotEmpty
        String photo;
        @NotBlank
        String categoryField;
        @NotBlank
        String categoryPurpose;
        @NotBlank
        String content;
        @NotEmpty
        List<String> video;
    }
}
