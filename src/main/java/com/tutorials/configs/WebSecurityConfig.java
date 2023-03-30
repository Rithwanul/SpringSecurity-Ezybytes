package com.tutorials.configs;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.csrf(csrf -> {
                        csrf.ignoringRequestMatchers("/v1/api/welcome", "/v1/api/**");
                })
                                .headers(headers -> headers.frameOptions().sameOrigin())
                                .authorizeHttpRequests((authz) -> authz
                                                .requestMatchers("/v1/api/welcome").permitAll()
                                                .requestMatchers("/v1/api/auth/**").authenticated()
                                                .requestMatchers("/v1/api/**").permitAll())
                                .httpBasic();

                return http.build();
        }

        /*
         * @Bean
         * public InMemoryUserDetailsManager userDetailsService() {
         * UserDetails admin = User.withDefaultPasswordEncoder()
         * .username("Admin")
         * .password("12345")
         * .roles("Admin")
         * .authorities(new SimpleGrantedAuthority("Admin"))
         * .build();
         * 
         * UserDetails user = User.withDefaultPasswordEncoder()
         * .username("Don")
         * .password("12345")
         * .roles("User")
         * .authorities(new SimpleGrantedAuthority("User"))
         * .build();
         * 
         * return new InMemoryUserDetailsManager(admin, user);
         * }
         */

        @Bean
        public PasswordEncoder passwordEncoder() {
                return NoOpPasswordEncoder.getInstance();
        }

        // @Bean
        // public DataSource dataSource() {
        //         DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        //         dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        //         dataSourceBuilder.url("jdbc:mysql://localhost:3306/hibernatedemo");
        //         dataSourceBuilder.username("root");
        //         dataSourceBuilder.password("");
        //         DataSource dataSource = dataSourceBuilder.build();

        //         return dataSourceBuilder.build();
        // }

        


        @Bean
        public DataSource dataSource() {
                BasicDataSource dataSource = new BasicDataSource();
                dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                dataSource.setUrl("jdbc:mysql://localhost:3306/hibernatedemo");
                dataSource.setUsername("root");
                dataSource.setPassword("");
                return dataSource;
        }

        // @Bean
        // public AuthenticationManager authenticationManagerBean(HttpSecurity http)
        // throws Exception {
        // AuthenticationManagerBuilder authenticationManagerBuilder = http
        // .getSharedObject(AuthenticationManagerBuilder.class);

        // InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // UserDetails userAdmin = User.withUsername("Admin")
        // .password(passwordEncoder().encode("12345")).authorities("Admin").build();

        // UserDetails user = User.withUsername("User")
        // .password(passwordEncoder().encode("12345")).authorities("User").build();

        // manager.createUser(user);
        // manager.createUser(userAdmin);

        // authenticationManagerBuilder.userDetailsService(userDetailsService())
        // .passwordEncoder(passwordEncoder());
        // return authenticationManagerBuilder.build();
        // }

        @Bean
        public JdbcUserDetailsManager userDetailsService(DataSource dataSource) {
           return new JdbcUserDetailsManager(dataSource);
        }

}
