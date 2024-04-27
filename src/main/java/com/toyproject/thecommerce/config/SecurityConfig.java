package com.toyproject.thecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable()
                .cors().configurationSource(corsConfigurationSource())
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers(HttpMethod.POST, "/api/user/**").permitAll()
                        .antMatchers(HttpMethod.PATCH, "/api/user/**").permitAll()
                        .antMatchers(HttpMethod.DELETE, "/api/user/**").permitAll()
                        .antMatchers(HttpMethod.GET, "/api/user/**").permitAll()
                        .anyRequest().permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:8080")); //직접입력
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "DELETE")); // 직접입력
        configuration.setAllowedHeaders(Arrays.asList("*")); // 직접입력
//        configuration.setExposedHeaders(Arrays.asList("*","Authorization","Refresh")); //직접입력
//        configuration.setAllowCredentials(true); // true일 경우 * 가 작동안함
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);//직접입력
        return source;
    }
}
