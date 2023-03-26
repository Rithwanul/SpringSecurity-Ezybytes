package com.tutorials.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers("/v1/api/welcome").permitAll()
                .requestMatchers("/v1/api/auth/**").authenticated()
                .requestMatchers("/v1/api/**").permitAll())
                .httpBasic();
        return http.build();
    }

    /* @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("Admin")
                .password("12345")
                .roles("Admin")
                .authorities(new SimpleGrantedAuthority("Admin"))
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("Don")
                .password("12345")
                .roles("User")
                .authorities(new SimpleGrantedAuthority("User"))
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    } */

    
    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
    

     @Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class);

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails userAdmin = User.withUsername("Admin")
        .password("12345").authorities("Admin").build();

        UserDetails user = User.withUsername("User")
                .password("12345").authorities("User").build();


        manager.createUser(user);
        manager.createUser(userAdmin);

        authenticationManagerBuilder.userDetailsService(manager).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }



}
