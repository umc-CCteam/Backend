package backend.CC.apiResponse.code;


import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ReasonDTO {

    private String message;
    private String code;
    private boolean isSuccess;
    private HttpStatus httpStatus;

}
