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
        String category1;
        @NotBlank
        String category2;
        @NotEmpty
        Integer youtube;
        @NotEmpty
        Integer insta;
        @NotEmpty
        Integer tictok;
        @NotBlank
        String content;
        @NotEmpty
        List<String> video;
    }
}
