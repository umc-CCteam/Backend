package backend.CC.web.dto;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class InstagramResponseDTO {
    private final Map<String, Object> attribute;

    private String provider;
    private String providerId;
    private String email;
    private String name;

    public String getProvider() {
        return "instagram";
    }

    public String getProviderId() {
        return attribute.get("id").toString();
    }

    public String getEmail() {
        return attribute.get("instagram_business_account").toString();
    }

    public String getName() {
        return attribute.get("name").toString();
    }
}
