package com.panha.gatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        .requestMatchers(HttpMethod.GET).permitAll()
                        .requestMatchers("/api/v1/products/**").hasRole("catalog_api")
                        .requestMatchers("/api/v1/orders/**").hasRole("catalog_api")
        ).oauth2ResourceServer(
                oauth2ResourceServer -> oauth2ResourceServer.jwt(jwtSpec -> jwtSpec.jwtAuthenticationConverter(grantedAuthorityExtractor()))
        );
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
        /*http.authorizeExchange(
                exchange -> exchange.pathMatchers(HttpMethod.GET).permitAll()
                        .pathMatchers("/api/v1/products/**").authenticated()
                        .pathMatchers("/api/v1/orders/**").authenticated()
        ).oauth2ResourceServer(
                oauth2 -> oauth2.jwt(Customizer.withDefaults())
        );
        http.csrf(ServerHttpSecurity.CsrfSpec::disable);
        return http.build();*/
    }
    private Converter<Jwt, AbstractAuthenticationToken> grantedAuthorityExtractor() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConvert());
        return jwtAuthenticationConverter;
    }
}
