package backend.CC.security;

import backend.CC.web.dto.GoogleResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@RequiredArgsConstructor
public class GoogleOAuth2User implements OAuth2User {
    private final GoogleResponseDTO dto;
    private final String role;

    @Override
    public Map<String, Object> getAttributes() {
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

    public String getUsername() {
        return dto.getProvider() + " " + dto.getProviderId();
    }
}
