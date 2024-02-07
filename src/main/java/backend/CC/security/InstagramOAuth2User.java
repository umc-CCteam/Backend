package backend.CC.security;

import backend.CC.web.dto.InstagramResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@RequiredArgsConstructor
public class InstagramOAuth2User implements OAuth2User {
    private final InstagramResponseDTO dto;
    private final String role;

    @Override
    public Map<String, Object> getAttributes() {
        //TODO : Add token_access Option
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add((GrantedAuthority) () -> role);
        return collection;
    }

    @Override
    public String getName() {
        return dto.getName();
    }
}
