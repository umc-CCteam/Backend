package backend.CC.service;

import backend.CC.security.GoogleOAuth2User;
import backend.CC.web.dto.GoogleResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OAuth2UserService extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("new OAuth2User loaded : {} ", oAuth2User.getName());

        /*
        @registrationID = request target platform(ex. google, instagram)
         */
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        if (registrationId.equals("google")) {
            GoogleResponseDTO responseDTO = new GoogleResponseDTO(oAuth2User.getAttributes());
            return new GoogleOAuth2User(responseDTO, "ROLE_USER");
        }
        if (registrationId.equals("instagram")) {
            //TODO
            //Instagram Oauth2.0 Implements
        }
        return null;
    }
}
