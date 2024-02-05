package backend.CC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .oauth2Login(Customizer.withDefaults())
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
