package com.abdullah996.fullstacktodoapp.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain


//@Configuration
class BasicAuthenticationSecurityConfiguration {

    //filter chain
    //authenticate all requests
    //basic authentication
    //disable csrf
    //stateless restApi

    @Bean
    fun filterChain(http: HttpSecurity) : SecurityFilterChain {
        http.authorizeHttpRequests{
            it.requestMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest().authenticated()
        }.httpBasic(Customizer.withDefaults())
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }.csrf().disable()
        return http.build()
    }
}