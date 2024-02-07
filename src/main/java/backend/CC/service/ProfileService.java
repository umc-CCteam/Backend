package backend.CC.service;

import backend.CC.domain.Profile;
import backend.CC.web.dto.ProfileRequestDTO;

public interface ProfileService {

    public Profile getProfile(Long profileId);
    public Profile createProfile(ProfileRequestDTO requestDTO);
    public Profile updateProfile(Long profileId, ProfileRequestDTO requestDTO);
}
