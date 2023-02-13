package com.examen.twitterlike.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {		
		
		http.authorizeHttpRequests()
			.requestMatchers("/").permitAll()
			.requestMatchers("/public/user/**").permitAll()
			.requestMatchers("/private/categories/**").hasAnyRole("USER","ADMIN")
			.requestMatchers("/private/comment/**").hasAnyRole("USER","ADMIN")
			.requestMatchers("/private/profile/**").hasAnyRole("USER","ADMIN")
			.anyRequest().authenticated()
			.and().formLogin();
		
		return http.build();
	}
	

	@Bean
	public AuthenticationManager authenticationManager(
			HttpSecurity http, 
			BCryptPasswordEncoder bCryptPasswordEncoder, 
			UserDetailsService userDetailService) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailService)
				.passwordEncoder(bCryptPasswordEncoder)
				.and().build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
