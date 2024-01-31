package backend.CC.web.controller;

import backend.CC.apiResponse.ApiResponse;
import backend.CC.converter.AuthConverter;
import backend.CC.domain.Member;
import backend.CC.service.AuthCommandService;
import backend.CC.web.dto.AuthRequestDTO;
import backend.CC.web.dto.AuthResponseDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth") // 기준이 되는 주소
public class AuthController {

    private final AuthCommandService authCommandService;

    // ===== 로그인 API ===== //
    @PostMapping("")
    public ApiResponse<AuthResponseDTO.LoginResultDTO> loginAPI(
            @RequestBody @Valid AuthRequestDTO.LoginDto request) {
        boolean isTrue = authCommandService.loginAuth(request);
        if (isTrue) {
                    //userEmail : 사용자가 입력한 이메일, loginSuccess : 로그인 성공 여부
            return ApiResponse.onSuccess(AuthConverter.toLoginResultDTO(request.getEmail(), true));
        }else {
            return ApiResponse.onFailure("404","비밀번호또는 아이디가 잘못되었습니다.",AuthConverter.toLoginResultDTO(request.getEmail(), false));
        }

    }

    // ======================= //

    // ===== 회원가입 API ===== //
    @PostMapping("/join")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201",description = "OK, 회원가입 성공"),
    })
    public ApiResponse<AuthResponseDTO.JoinResultDTO> joinAPI(
            @RequestBody @Valid AuthRequestDTO.JoinDto request){
        Member auth = authCommandService.joinAuth(request);

        return ApiResponse.onSuccess(AuthConverter.toJoinResultDTO(auth));

    }

    // ======================= //
}
