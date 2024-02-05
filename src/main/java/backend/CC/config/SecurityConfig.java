package backend.CC.config;

import backend.CC.service.OAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final OAuth2UserService oAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .oauth2Login(oauth2 ->
                        oauth2.userInfoEndpoint(endPoint ->
                                endPoint.userService(oAuth2UserService)))
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(this::decideClientPermission);
        return http.build();
    }

    /*
    Decide Security Permission to URL Path
    Deny All access of client(Using authenticated),
    excluded implicit URL Path(permitAll)
     */
    private void decideClientPermission(AuthorizeHttpRequestsConfigurer<HttpSecurity>
                                                .AuthorizationManagerRequestMatcherRegistry auth) {
        auth.requestMatchers("/", "/auth/**", "/oauth2/**", "/login/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
