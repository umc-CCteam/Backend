package backend.CC.service;

import backend.CC.domain.Profile;
import backend.CC.domain.dto.ProfileRequest;
import backend.CC.domain.dto.ProfileResponse;
import backend.CC.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    // pr 프로필 등록
    public void register(ProfileRequest.RegisterDto requestDto) {

        Profile profile = new Profile(requestDto.getName(), requestDto.getPlatform(), requestDto.getComment());
        profileRepository.save(profile);
    }

    // pr 프로필 조회
    public ProfileResponse.Dto findOne(Long ProfileId){
        Profile profile = profileRepository.findOne(ProfileId);

        ProfileResponse.Dto profileResponse = new ProfileResponse.Dto();
        profileResponse.setComment(profile.getComment());
        profileResponse.setPlatform(profile.getPlatform());
        profileResponse.setName(profile.getNickname());

        return profileResponse;

    }

    // pr 프로필 변경
    // name, photo, comment, platform
    public void modify(Long ProfileId, ProfileRequest.RegisterDto updateDto) {
        // 변경할 내용을 받아옴
        Profile profile = profileRepository.findOne(ProfileId);

        profile.update(updateDto);
    }
}
