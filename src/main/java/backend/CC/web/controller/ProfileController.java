package backend.CC.web.controller;

import backend.CC.converter.ProfileConverter;
import backend.CC.apiResponse.ApiResponse;
import backend.CC.domain.Profile;
import backend.CC.service.ProfileService;
import backend.CC.web.dto.ProfileRequestDTO;
import backend.CC.web.dto.ProfileResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;
    /**
     * 프로필 조회
     */
    @GetMapping("/{profile-id}")
    public ApiResponse<ProfileResponseDTO.ProfileDTO> getProfile(
            @PathVariable("profile-id") Long profileId
    ) {
        Profile profile = profileService.getProfile(profileId);
        return ApiResponse.onSuccess(ProfileConverter.toProfile(profile));
    }

    /**
     * 프로필 작성
     */
    @PostMapping()
    public ApiResponse<ProfileResponseDTO.ProfileDTO> createProfile(@RequestBody ProfileRequestDTO requestDTO) {

        Profile profile = profileService.createProfile(requestDTO);
        return ApiResponse.onSuccess(ProfileConverter.toProfile(profile));
    }

    /**
     * 프로필 변경
     */
    @PutMapping("/{profile-id}")
    public ApiResponse<ProfileResponseDTO.ProfileDTO> updateProfile(
            @PathVariable("profile-id") Long profileId, ProfileRequestDTO requestDTO
    ) {
        Profile profile = profileService.updateProfile(profileId, requestDTO);
        return ApiResponse.onSuccess(ProfileConverter.toProfile(profile));
    }
}
