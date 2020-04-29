package com.xebia.uma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ForwardedHeaderFilter;

import com.xebia.uma.infra.config.ApplicationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ ApplicationProperties.class })
public class PaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaginationApplication.class, args);
	}

	@Bean
	ForwardedHeaderFilter forwardedHeaderFilter() {
	    return new ForwardedHeaderFilter();
	}
}
