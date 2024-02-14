package com.store.SportswearStore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SportswearConfigurationSecurity {
    @Bean
    public UserDetailsService inMemoryUserDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User
                .withUsername("admin")
                .password("{noop}123")
                .roles("ADMIN")
                .build());

        manager.createUser(User
                .withUsername("user")
                .password("{noop}321")
                .roles("USER")
                .build());

        return manager;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests(auth -> auth
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                        .requestMatchers("/user/**").hasAnyRole("USER")
                        .requestMatchers("/product/**").permitAll()
                        .requestMatchers("/image/**").permitAll()
                        .anyRequest()
                        .authenticated())
                        .formLogin(Customizer.withDefaults())
                        .build();
    }
}