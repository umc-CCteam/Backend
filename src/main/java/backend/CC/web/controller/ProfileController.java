package backend.CC.web.controller;

import backend.CC.converter.ProfileConverter;
import backend.CC.apiResponse.ApiResponse;
import backend.CC.web.dto.ProfileResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {

    /**
     * 프로필 조회
     */
    @GetMapping("/{profile-id}")
    public ApiResponse<ProfileResponseDTO.ProfileDTO> getProfile(
            @PathVariable("profile-id") Long profileId
    ) {

        return ApiResponse.onSuccess(ProfileConverter.toProfile());
    }

    /**
     * 프로필 작성
     */
    @PostMapping()
    public ApiResponse<ProfileResponseDTO.ProfileDTO> createProfile() {

        return ApiResponse.onSuccess(ProfileConverter.toProfile());
    }

    /**
     * 프로필 변경
     */
    @PutMapping("/{profile-id}")
    public ApiResponse<ProfileResponseDTO.ProfileDTO> updateProfile(
            @PathVariable("profile-id") Long profileId
    ) {

        return ApiResponse.onSuccess(ProfileConverter.toProfile());
    }
}
