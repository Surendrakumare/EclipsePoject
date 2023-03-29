package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfigaration {
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
}
