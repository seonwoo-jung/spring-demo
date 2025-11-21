package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {
		Info info = new Info()
			.version("1.0.0")
			.title("회원 마이그레이션")
			.description("API 테스트");

		return new OpenAPI()
			.info(info)
			.addServersItem(new Server().url("/"));
	}
}
