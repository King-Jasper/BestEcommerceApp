package jaspertechShoppingCentre.config;

import jaspertechShoppingCentre.security.JwtAuthenticationFilter;
import jaspertechShoppingCentre.security.LogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final LogoutService logoutService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
      http.csrf(AbstractHttpConfigurer::disable)
              .authorizeHttpRequests(authorize-> authorize
                      .requestMatchers("/api/v1/auth**", "api/v1/state/**", "api/v1/pickupCenter/**", "api/v1/admin/**")
                      .permitAll()
                      .anyRequest()
                      .authenticated())
              .sessionManagement(session -> session
                      .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              .authenticationProvider(authenticationProvider)
              .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
              .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer
                      .logoutUrl("/api/v1/auth/logout")
                      .addLogoutHandler(logoutService)
                      .logoutSuccessHandler(((request, response, authentication) -> SecurityContextHolder.clearContext())));
    return http.build();

    }
}
