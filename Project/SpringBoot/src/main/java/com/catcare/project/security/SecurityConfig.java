package com.catcare.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration // Esta clase crea beans
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.
            csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))
            .authorizeHttpRequests( requests -> requests
                .requestMatchers("/h2/**").permitAll()
                .requestMatchers("/administrador/details").hasAuthority("ADMINISTRADOR")
                .requestMatchers("/veterinario/details").hasAuthority("VETERINARIO")
                .requestMatchers("/cliente/details").hasAuthority("CLIENTE")
                .requestMatchers("/administrador/**").hasAuthority("ADMINISTRADOR")
                .requestMatchers("/veterinario/**").hasAuthority("VETERINARIO")
                .requestMatchers("/cliente/**").hasAuthority("CLIENTE")
                .anyRequest().permitAll()
            )
            .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint));
            http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }

}