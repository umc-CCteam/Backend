package backend.CC.converter;

import backend.CC.domain.Profile;
import backend.CC.web.dto.ProfileResponseDTO;

public class ProfileConverter {

    public static ProfileResponseDTO.ProfileDTO toProfile(Profile profile) {
        return ProfileResponseDTO.ProfileDTO.builder()
                .profileId(profile.getId())
                .nickname(profile.getName())
                .email(profile.getEmail())
                .comment(profile.getComment())
                .photo(profile.getPhoto())
                .googleAuth(profile.isGoogleAuth())
                .instaAuth(profile.isInstaAuth())
                .build();

    }
}
