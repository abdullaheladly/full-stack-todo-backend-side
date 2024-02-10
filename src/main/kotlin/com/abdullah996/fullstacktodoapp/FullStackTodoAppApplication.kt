package com.abdullah996.fullstacktodoapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class FullStackTodoAppApplication

fun main(args: Array<String>) {
	runApplication<FullStackTodoAppApplication>(*args)
}

@Configuration
@EnableWebMvc
class MyWebMvcConfigurer : WebMvcConfigurer {

	override fun addCorsMappings(registry: CorsRegistry) {
		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS").allowedOrigins("http://localhost:3000")
	}
}

@Configuration
class WebMvcConfig {

	@Bean
	fun corsConfigurer(): WebMvcConfigurer {
		return MyWebMvcConfigurer()
	}
}


