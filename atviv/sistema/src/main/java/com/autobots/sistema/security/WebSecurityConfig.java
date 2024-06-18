package com.autobots.sistema.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc

@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    
    final UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig (UserDetailsServiceImpl userDetailsService){
        this.userDetailsService = userDetailsService;
        }

    @Autowired
    private JwtFilter jwtFilter;

  

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .httpBasic()
        .and()
        .authorizeHttpRequests()
        .requestMatchers("/login/").permitAll()
        //.antMatchers(HttpMethod.GET, "/parking-spot/**").permitAll()
        // .antMatchers(HttpMethod.POST, "/parking-spot/**").hasRole("USER")
        // .antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN")
        //.permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .csrf()
        .and()
        .cors()
        .disable()
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); 
       
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
