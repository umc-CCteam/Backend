package backend.CC.web.dto;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class GoogleResponseDTO {
    private final Map<String, Object> attribute;

    private String provider;
    private String providerId;
    private String email;
    private String name;

    public String getProvider() {
        return "google";
    }

    public String getProviderId() {
        return attribute.get("sub").toString();
    }

    public String getEmail() {
        return attribute.get("email").toString();
    }

    public String getName() {
        return attribute.get("name").toString();
    }
}
